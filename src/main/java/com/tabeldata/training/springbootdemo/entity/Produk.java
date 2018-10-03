
package com.tabeldata.training.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


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
    

}
