create database payroll_service;

use payroll_service;
create table employee_payroll(Id int not null auto_increment, 
                  name varchar(30) not null,
                  department varchar(30),
                  gender char(1),
                  BasicPay decimal(20,2) null,
                  primary key(Id));
                  
                  
	desc employee_payroll;
    select * from payroll_service.employee_payroll;