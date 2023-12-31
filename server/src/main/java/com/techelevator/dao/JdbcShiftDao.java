package com.techelevator.dao;

import com.techelevator.model.Shift;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class JdbcShiftDao implements  ShiftDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcShiftDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

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
            return new Shift(shiftId, clientId, serviceId, totalHours, zipcode, isAvailable, clientFirstName, clientLastName, serviceName) ;
        }
    };
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
    public List<Shift> getAvailableShifts(boolean isAvailable) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE s.available = ?";
        return jdbcTemplate.query(sql, MAPPER, isAvailable);
    }

    @Override
    public List<Shift> getShiftByClientId(int clientId, boolean isAvailable) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE s.client_id = ? " +
                "AND s.available = ?";
        return jdbcTemplate.query(sql, MAPPER, clientId, isAvailable);
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
    public List<Shift> getShiftByTotalHours(int minHours, int maxHours, boolean isAvailable) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE s.total_hours BETWEEN ? AND ? " +
                "AND s.available = ?";
        return jdbcTemplate.query(sql, MAPPER, minHours, maxHours, isAvailable);
    }

    @Override
    public List<Shift> getShiftByZipcode(String zipcode, boolean isAvailable) {
        String sql = "SELECT " +
                " s.*, " +
                "c.first_name, " +
                "c.last_name, " +
                "se.service_name " +
                "FROM shift s " +
                "JOIN client c ON s.client_id = c.client_id " +
                "JOIN service se ON s.service_id = se.service_id " +
                "WHERE s.zipcode = ? AND s.available = ?";
        return jdbcTemplate.query(sql, MAPPER, zipcode, isAvailable);
    }
}
