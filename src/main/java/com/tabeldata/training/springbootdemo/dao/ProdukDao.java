package com.tabeldata.training.springbootdemo.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


import com.tabeldata.training.springbootdemo.entity.Produk;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dimasm93
 */

@Repository
public class ProdukDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    Method For View By ID
    public Produk findById(String id) throws EmptyResultDataAccessException {
        String query = "select id as kode_unique, kode, nama, harga, qty from produk where id = ?";
        Produk produk = jdbcTemplate.queryForObject(query, new RowMapper<Produk>(){
            @Override
            public Produk mapRow(ResultSet rs, int i) throws SQLException {
                return new Produk(
                        rs.getString("kode_unique"),
                        rs.getString("kode"), 
                        rs.getString("nama"),
                        rs.getBigDecimal("harga"), 
                        rs.getInt("qty"));
            }
            
        }, id);
        return produk;
    }

//    Method for view All
    public List<Produk> findAll(){
        String query = "select id as kode_unique, kode, nama, harga, qty from produk";
        List<Produk> list = jdbcTemplate.query(query, new RowMapper<Produk>(){
            @Override
            public Produk mapRow(ResultSet rs, int i) throws SQLException {
                return new Produk(
                        rs.getString("kode_unique"),
                        rs.getString("kode"),
                        rs.getString("nama"),
                        rs.getBigDecimal("harga"),
                        rs.getInt("qty"));
            }

        });
        return list;
    }

//    Method for Save
    public Produk save(Produk produk){
        String query = "insert into produk(id, kode, nama, harga, qty) values (? ,?, ?, ?, ?)";
        String primaryKey = UUID.randomUUID().toString();
        this.jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, primaryKey);
                ps.setString(2, produk.getKode());
                ps.setString(3, produk.getNama());
                ps.setBigDecimal(4, produk.getHarga());
                ps.setInt(5, produk.getQty());
            }
        });
        produk.setId(primaryKey);
        return produk;
    }

//    Method for Update
    public Produk update(Produk produk){
        String query = "update produk set kode = ?, nama = ?, harga = ?, qty = ? where id = ?";
        this.jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, produk.getKode());
                ps.setString(2, produk.getNama());
                ps.setBigDecimal(3, produk.getHarga());
                ps.setInt(4, produk.getQty());
                ps.setString(5, produk.getId());
            }
        });
        return produk;
    }

    public void deleteById(String id){
        String query = "delete from produk where id = ?";
        this.jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, id);
            }
        });
    }
}
