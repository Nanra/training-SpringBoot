# Springboot v2

## Create user mysql

```mysql
# connect to root
mysql -h 127.0.0.1 -u root -p
# create user
create user bootcamp identified by 'bootcamp';
# grant user
grant all privileges on *.* to bootcamp@'%' identified by 'bootcamp';
# database bootcamp;
create database bootcamp;
```

## How to import sql file to mysql

```bash
## change directory to file sql
cd src/main/resources/db/migration 

## connect to mysql bootcamp database
mysql -h 127.0.0.1 -u bootcamp -p

## use database bootcamp
use bootcamp;

## import sql file to database bootcamp
source schema_database.sql;

## check tables
show tables;

## select rows data
select * from produk;
```