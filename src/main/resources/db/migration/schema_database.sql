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

