<<<<<<< HEAD
package com.tabeldata.training.springbootdemo.entity;

public class Produk {
    
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.training.springbootdemo.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dimasm93
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produk {
    
    private String id;
    private String kode;
    private String nama;
    private BigDecimal harga;
    private Integer qty;
    
>>>>>>> 85073699bdcb1521b51b97743f5954a82cf7f6ab
}
