package com.tabeldata.training.springbootdemo.controller;

import com.tabeldata.training.springbootdemo.dao.CustomerDao;
import com.tabeldata.training.springbootdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Spring Annotation
@RequestMapping("/api/customer") // Spring Annotation
public class CustomerController {

    @Autowired
    private CustomerDao dao;

    // Service for view customer by Id
    @GetMapping("/{kode}/findById")
    public ResponseEntity<Customer> findById(@PathVariable("kode") String id){
        try {
            Customer cs = dao.findById(id);
            return ResponseEntity.ok(cs);

        } catch (EmptyResultDataAccessException erdae) {
            return ResponseEntity.noContent().build();
        }
    }

    // Service for view all produk
    @GetMapping(path = {"/list", "/"}) // Dua URL address satu target pakai args path
    public List<Customer> findAll(){
        return dao.findAll();
    }

    // Service for save new produk
    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody Customer cs){
        cs = this.dao.save(cs);
        return ResponseEntity.ok(cs);
    }

    // Service for update produk
    @PutMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody Customer cs){
        cs = this.dao.update(cs);
        return ResponseEntity.ok(cs);
    }

    //  Service for Delete
    @DeleteMapping("/{kode}")
    public ResponseEntity<Customer> delete(@PathVariable("kode") String kode){
        this.dao.deleteById(kode);
        return ResponseEntity.ok().build();
    }

}
