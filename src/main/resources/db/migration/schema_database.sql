<<<<<<< HEAD

--Creating Table
create table produk (
id varchar(255) not null primary key,
kode varchar(50) not null unique,
nama varchar(100) not null,
harga decimal not null default 0,
qty int not null default 0 ) engine = InnoDB;

--Inserting Values of produk table
insert into produk(id, kode, nama, harga, qty) values
('produk-001', 'produk-001', 'Macbook Pro 13 inch', 2800000, 5),
('produk-002', 'produk-002', 'Macbook Pro 15 inch', 5098999, 3),
('produk-003', 'produk-003', 'Apple Watch', 549000, 2);
=======
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dimasm93
 * Created: Oct 3, 2018
 */

create table produk(
    id varchar(255) not null primary key,
    kode varchar(50) not null unique,
    nama varchar(100) not null,
    harga decimal not null default 0,
    qty int not null default 0
) engine = InnoDB;

insert into produk(id, kode, nama, harga, qty) values 
    ('produk-001', 'produk-001', 'Macbook Pro 13 inch', 28000000, 5),
    ('produk-002', 'produk-002', 'Macbook Pro 15 inch', 50000000, 2),
    ('produk-003', 'produk-003', 'Apple watch', 3000000, 1); 
    
>>>>>>> 85073699bdcb1521b51b97743f5954a82cf7f6ab
