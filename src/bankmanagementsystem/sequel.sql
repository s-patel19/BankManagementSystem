create database bankmanagementsystem;

show databases;

use bankmanagementsystem;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20), email varchar(30), marital_status varchar(20), address varchar(40), city varchar(20), state varchar(25), pin varchar(20));	

show tables;

select * from signup;

create table signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(30), pan varchar(20), aadhar varchar(40), senior_citizen varchar(20), existing_account varchar(25));

select * from signuptwo;

create table signupthree(formno varchar(20), account_type varchar(20), card_number varchar(25), pin_number varchar(10), facility varchar(100));

create table login(formno varchar(20), card_number varchar(25), pin_number varchar(10));

select * from signupthree;

select * from login;

create table bank(pin varchar(20), date varchar(50), type varchar(20), amount varchar(20));

 select * from bank;
 