<<<<<<< HEAD
package com.tabeldata.training.springbootdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
//@NoArgsConstructor
public class ResponseHalo {

=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.training.springbootdemo.dto;

import java.util.UUID;
import lombok.Data;

/**
 *
 * @author dimasm93
 */
@Data
//@NoArgsConstructor
public class ResponseHalo {
    
>>>>>>> 85073699bdcb1521b51b97743f5954a82cf7f6ab
    public ResponseHalo(String nama, String alamat){
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
        this.alamat = alamat;
    }
<<<<<<< HEAD

    private String id;
    private String nama;
    private String alamat;
=======
    
    private String id;
    private String nama;
    private String alamat;
    
>>>>>>> 85073699bdcb1521b51b97743f5954a82cf7f6ab
}
