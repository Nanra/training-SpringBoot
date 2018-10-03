--Creating Table
create table customer (
id varchar(255) not null primary key,
nama varchar(100) not null,
email varchar(100) not null,
alamat varchar(100) not null,
noHP varchar(50) not null);

--Inserting Values of produk table
insert into customer(id, nama, email, alamat, noHP) values
('001', 'Nanra Sukedy', 'sukedynanra@gmail.com', 'Bandung', '081360708122'),
('002', 'Alfath Rajaya', 'alfathrajaya@gmail.com', 'Cimahi', '087860708124'),
('003', 'Peprandi', 'randi@gmail.com', 'Belgia', '085560708140');


