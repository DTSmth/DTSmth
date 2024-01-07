package com.techelevator.dao;

import com.techelevator.model.Client;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component

public class JdbcClientDao implements ClientDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcClientDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private static final RowMapper<Client> MAPPER = new RowMapper<Client>() {
        @Override
        public Client mapRow(ResultSet resultSet, int i) throws SQLException {
            int clientId = resultSet.getInt("client_id");
            String name = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            boolean hasPersonalCare = resultSet.getBoolean("has_personal_care");
            boolean hasLifting = resultSet.getBoolean("has_lifting");
            String address1 = resultSet.getString("address_1");
            String address2 = resultSet.getString("address_2");
            String zipcode = resultSet.getString("zipcode");
            String phoneNumber = resultSet.getString("phone_number");
            return new Client(clientId, name, lastName, hasPersonalCare, hasLifting, address1, address2, zipcode, phoneNumber );
        }
    };

    @Override
    public Client getClientById(int id) {
        String sql = "SELECT * FROM client WHERE client_id = ?";
        try {
            List<Client> client = jdbcTemplate.query(sql, MAPPER, id);
            return client.isEmpty() ? null : client.get(0);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> getAllClients() {
        String sql = "SELECT * FROM client";
        try {
            return jdbcTemplate.query(sql, MAPPER);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> getClientByFirstNameLastName(String firstname, String lastname) {
        String sql = "SELECT * FROM client WHERE first_name ILIKE ? AND last_name ILIKE ?";
        return jdbcTemplate.query(sql, MAPPER, firstname, lastname);
    }

    @Override
    public List<Client> getClientByZipCode(String zipcode) {
        String sql = "SELECT * FROM client WHERE zipcode = ?";
        return jdbcTemplate.query(sql, MAPPER, zipcode);
    }

    @Override
    public Client createClient(Client client) {
        String sql = "INSERT INTO client (first_name, last_name, has_personal_care, has_lifting, address_1, address_2, zipcode, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING client_id";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, client.getName(), client.getLastName(), client.isHasPersonalCare(), client.isHasLifting(), client.getAddress1(), client.getAddress2(), client.getZipcode(), client.getPhoneNumber());
        return getClientById(newId);
    }

    @Override
    public Client updateClient(Client client) {
        String sql = "UPDATE client SET first_name = ?, last_name = ?, has_personal_care = ?, has_lifting = ?, address_1 = ?, address_2 = ?, zipcode = ?, phone_number = ? WHERE client_id = ?";
        jdbcTemplate.update(sql, client.getName(), client.getLastName(), client.isHasPersonalCare(), client.isHasLifting(), client.getAddress1(), client.getAddress2(), client.getZipcode(), client.getPhoneNumber(), client.getClientId());
        return getClientById(client.getClientId());
    }

}
