package com.techelevator.dao;

import com.techelevator.model.ClientService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcClientServiceDao implements ClientServiceDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcClientServiceDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<ClientService> MAPPER = new RowMapper<ClientService>() {
        @Override
        public ClientService mapRow(ResultSet resultSet, int i) throws SQLException {
            int clientId = resultSet.getInt("client_id");
            int serviceId = resultSet.getInt("service_id");
            return new ClientService(clientId, serviceId);
        }
    };

    @Override
    public List<ClientService> getAllServicesForClientById(int id) {
        String sql = "SELECT * FROM client_service " +
                "WHERE client_id = ?";
        List<ClientService> clientServices = jdbcTemplate.query(sql, MAPPER, id);
        return clientServices;
    }

    @Override
    public List<ClientService> getAllClientsForServiceById(int id, boolean isAvailable) {
        String sql = "SELECT * FROM client_service " +
                "WHERE service_id = ?";
        List<ClientService> clientServices = jdbcTemplate.query(sql, MAPPER, id);
        return clientServices;
    }


}
