package com.techelevator.dao;

import com.techelevator.model.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcServiceDao  implements  ServiceDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcServiceDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<Service> MAPPER = new RowMapper<Service>() {
        @Override
        public Service mapRow(ResultSet resultSet, int i) throws SQLException {
            int serviceId = resultSet.getInt("service_id");
            String name = resultSet.getString("service_name");
            return new Service(serviceId, name);
        }
    };


    @Override
    public Service getServiceById(int id) {
        String sql = "SELECT * FROM service WHERE service_id = ?";
        try {
            List<Service> service = jdbcTemplate.query(sql, MAPPER, id);
            return service.isEmpty() ? null : service.get(0);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Service getServiceByName(String name) {
        String sql = "SELECT * FROM service WHERE service_name ILIKE ?";
        List<Service> service = jdbcTemplate.query(sql, MAPPER, name);
        return service.isEmpty() ? null : service.get(0);
    }

    @Override
    public List<Service> getServices() {
        String sql = "SELECT * FROM service";
        return jdbcTemplate.query(sql, MAPPER);
    }
}
