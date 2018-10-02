package com.tabeldata.training.springbootdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
//@NoArgsConstructor
public class ResponseHalo {

    public ResponseHalo(String nama, String alamat){
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
        this.alamat = alamat;
    }

    private String id;
    private String nama;
    private String alamat;
}
