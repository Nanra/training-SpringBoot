package com.tabeldata.training.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    private String id;
    private String nama;
    private String email;
    private String alamat;
    private String noHP;
}
