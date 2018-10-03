package com.tabeldata.training.springbootdemo.dao;

import com.tabeldata.training.springbootdemo.entity.Customer;
import com.tabeldata.training.springbootdemo.entity.Produk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //    Method For View By ID
    public Customer findById(String id) throws EmptyResultDataAccessException {
        String query = "select id as kode_unique, nama, email, alamat, noHP from customer where id = ?";
        Customer cs = jdbcTemplate.queryForObject(query, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                return new Customer(
                        rs.getString("kode_unique"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("alamat"),
                        rs.getString("noHP"));
            }

        }, id);
        return cs;
    }

    // Method for view All
    public List<Customer> findAll(){
        String query = "select id as kode_unique, nama, email, alamat, noHP from customer";
        List<Customer> list = jdbcTemplate.query(query, new RowMapper<Customer>(){
            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                return new Customer(
                        rs.getString("kode_unique"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("alamat"),
                        rs.getString("noHP"));
            }

        });
        return list;
    }

}
