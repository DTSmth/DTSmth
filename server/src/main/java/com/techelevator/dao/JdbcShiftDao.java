package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Client;
import com.techelevator.model.Service;
import com.techelevator.model.Shift;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcShiftDao implements ShiftDao {


    public static final RowMapper<Shift> MAPPER = new RowMapper<Shift>() {
        @Override
        public Shift mapRow(ResultSet resultSet, int i) throws SQLException {
            int shiftId = resultSet.getInt("shift_id");
            int clientId = resultSet.getInt("client_id");
            int serviceId = resultSet.getInt("service_id");
            int totalHours = resultSet.getInt("total_hours");
            String zipcode = resultSet.getString("zipcode");
            boolean isAvailable = resultSet.getBoolean("available");
            String clientFirstName = resultSet.getString("first_name");
            String clientLastName = resultSet.getString("last_name");
            String serviceName = resultSet.getString("service_name");
            return new Shift(shiftId, clientId, serviceId, totalHours, zipcode, isAvailable, clientFirstName, clientLastName, serviceName);
        }
    };
    private final JdbcTemplate jdbcTemplate;
    private final ClientDao clientDao;
    private final ServiceDao serviceDao;

    public JdbcShiftDao(DataSource dataSource, ClientDao clientDao, ServiceDao serviceDao) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.clientDao = clientDao;
        this.serviceDao = serviceDao;
    }

    @Override
    public Shift getShiftById(int shiftId) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE shift_id = ?";
        List<Shift> shift = jdbcTemplate.query(sql, MAPPER, shiftId);
        return shift.isEmpty() ? null : shift.get(0);
    }

    @Override
    public List<Shift> getAvailableShifts() {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE s.available = true";
        return jdbcTemplate.query(sql, MAPPER);
    }

    @Override
    public List<Shift> getShiftByClientId(int clientId) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE s.client_id = ? " +
                "AND s.available = true";
        return jdbcTemplate.query(sql, MAPPER, clientId);
    }

    @Override
    public List<Shift> getShiftByServiceName(String serviceName) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE se.service_name = ? " +
                "AND s.available = true";
        return jdbcTemplate.query(sql, MAPPER, serviceName);
    }

    @Override
    public List<Shift> getShiftByClientName(String firstName, String lastName) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE c.first_name = ? AND c.last_name = ? " +
                "AND s.available = true";
        return jdbcTemplate.query(sql, MAPPER, firstName, lastName);
    }


    @Override
    public List<Shift> getShiftByTotalHours(int minHours, int maxHours) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE s.total_hours BETWEEN ? AND ? " +
                "AND s.available = true";
        return jdbcTemplate.query(sql, MAPPER, minHours, maxHours);
    }

    @Override
    public List<Shift> getShiftByZipcode(String zipcode) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE s.zipcode = ? AND s.available = true";
        return jdbcTemplate.query(sql, MAPPER, zipcode);
    }

    @Override
    public void removeShift(int shiftId) {
        String sql = "DELETE FROM shift WHERE shift_id = ?";
        jdbcTemplate.update(sql, shiftId);
    }

    @Override
    public Shift createShift(Shift shift) {
        int clientId = shift.getClientId();
        if (clientId <= 0) {
            List<Client> clients = clientDao.getClientByFirstNameLastName(shift.getFirstName(), shift.getLastName());
            Client client = clients.isEmpty() ? null : clients.get(0);
            if (client == null ) {
                throw new DaoException(String.format("Client %s %s does not exist", shift.getFirstName(), shift.getLastName()));
            }
            clientId = client.getClientId();
        }
        int serviceId = shift.getServiceId();
        if (serviceId <= 0 ) {
            Service service = serviceDao.getServiceByName(shift.getServiceName());
            if (service == null) {
                throw new DaoException(String.format("Service %s does not exist", shift.getServiceName()));
            }
            serviceId = service.getServiceId();
        }

        // Insert or update the client-service relationship
        String clientServiceSql = "INSERT INTO client_service (client_id, service_id) VALUES (?, ?) ON CONFLICT (client_id, service_id) DO NOTHING";

        jdbcTemplate.update(clientServiceSql, clientId, serviceId);


        String sql = "INSERT into SHIFT (client_id, service_id, total_hours, zipcode, available) VALUES (?,?,?,?,?) RETURNING shift_id";
        Integer shiftId = jdbcTemplate.queryForObject(sql, Integer.class, clientId, serviceId, shift.getTotalHours(), shift.getZipcode(), shift.isAvailable());
        return getShiftById(shiftId);
    }

    @Override
    public Shift updateShift(Shift shift) {
        int clientId = shift.getClientId();
        if (clientId <= 0) {
            List<Client> clients = clientDao.getClientByFirstNameLastName(shift.getFirstName(), shift.getLastName());
            Client client = clients.isEmpty() ? null : clients.get(0);
            if (client == null ) {
                throw new DaoException(String.format("Client %s %s does not exist", shift.getFirstName(), shift.getLastName()));
            }
            clientId = client.getClientId();
        }
        int serviceId = shift.getServiceId();
        if (serviceId <= 0 ) {
            Service service = serviceDao.getServiceByName(shift.getServiceName());
            if (service == null) {
                throw new DaoException(String.format("Service %s does not exist", shift.getServiceName()));
            }
            serviceId = service.getServiceId();
        }
        String sql = "UPDATE shift SET client_id = ?, service_id = ?, total_hours = ?, zipcode = ?, available = ? WHERE shift_id = ?";
        jdbcTemplate.update(sql, clientId, serviceId, shift.getTotalHours(), shift.getZipcode(), shift.isAvailable(), shift.getShiftId());
        return getShiftById(shift.getShiftId());
    }

    @Override
    public List<Shift> getShiftByClientID(int clientId) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE s.client_id = ? AND s.available = true";
        return jdbcTemplate.query(sql, MAPPER, clientId);
    }
}
