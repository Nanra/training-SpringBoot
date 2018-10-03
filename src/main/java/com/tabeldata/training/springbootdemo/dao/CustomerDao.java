package com.tabeldata.training.springbootdemo.dao;

import com.tabeldata.training.springbootdemo.entity.Customer;
import com.tabeldata.training.springbootdemo.entity.Produk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method For View By ID
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

    // Method for Save
    public Customer save(Customer cs){
        String query = "insert into customer(id, nama, email, alamat, noHP) values (? ,?, ?, ?, ?)";
        String primaryKey = UUID.randomUUID().toString();
        this.jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, primaryKey);
                ps.setString(2, cs.getNama());
                ps.setString(3, cs.getEmail());
                ps.setString(4, cs.getAlamat());
                ps.setString(5, cs.getNoHP());
            }
        });
        cs.setId(primaryKey);
        return cs;
    }

    //    Method for Update
    public Customer update(Customer cs){
        String query = "update customer set nama = ?, email = ?, alamat = ?, noHP = ? where id = ?";
        this.jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, cs.getNama());
                ps.setString(2, cs.getEmail());
                ps.setString(3, cs.getAlamat());
                ps.setString(4, cs.getNoHP());
                ps.setString(5, cs.getId());
            }
        });
        return cs;
    }

    // Method For Delete by ID
    public void deleteById(String id){
        String query = "delete from customer where id = ?";
        this.jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, id);
            }
        });
    }

}
