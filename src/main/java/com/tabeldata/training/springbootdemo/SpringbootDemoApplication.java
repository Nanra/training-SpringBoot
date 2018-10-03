package com.tabeldata.training.springbootdemo;

import com.tabeldata.training.springbootdemo.dao.ProdukDao;
import com.tabeldata.training.springbootdemo.entity.Produk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);
        ProdukDao bean = context.getBean(ProdukDao.class);
        Produk produk1 = bean.findById("produk-001");
        System.out.println(produk1.toString());
    }
}
