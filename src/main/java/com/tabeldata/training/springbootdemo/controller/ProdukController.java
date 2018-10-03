package com.tabeldata.training.springbootdemo.controller;

import com.tabeldata.training.springbootdemo.dao.ProdukDao;
import com.tabeldata.training.springbootdemo.entity.Produk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produk")
public class ProdukController {

    @Autowired
    private ProdukDao dao;

//    Service for view produk by Id
    @GetMapping("/{kode}/findById")
    public ResponseEntity<Produk> findById(@PathVariable("kode") String id){
        try {
            Produk produk = dao.findById(id);
            return ResponseEntity.ok(produk);

        } catch (EmptyResultDataAccessException erdae) {
            return ResponseEntity.noContent().build();
        }
    }

//    Service for view all produk
    @GetMapping("/list")
    public List<Produk> findAll(){
        return dao.findAll();
    }

//    Service for save new produk
    @PostMapping("/save")
    public ResponseEntity<Produk> save(@RequestBody Produk produk){
        produk = this.dao.save(produk);
        return ResponseEntity.ok(produk);
    }

//    Service for update produk
    @PutMapping("/update")
    public ResponseEntity<Produk> update(@RequestBody Produk produk){
        produk = this.dao.update(produk);
        return ResponseEntity.ok(produk);
    }

//   Service for Delete
    @DeleteMapping("/{kode}")
    public ResponseEntity<Produk> delete(@PathVariable("kode") String kode){
        this.dao.deleteById(kode);
        return ResponseEntity.ok().build();
    }
}
