create database examplesForSQL; 
use examplesForSQL; 
create table mails (id int auto_increment, email varchar(30), primary key(id));

insert into mails (email) values ('perepechko@mail.ru');
insert into mails (email) values ('altshuler@mail.ru');
insert into mails (email) values ('perepechko@mail.ru');
insert into mails (email) values ('vlasik@mail.ru');
insert into mails (email) values ('vlasik@mail.ru');
insert into mails (email) values ('perepechko@mail.ru');

select * from mails where id%2=1; 
select email, count(email) from mails group by email having count(email)>1;

create table dates (id int auto_increment, Date date, primary key(id));
insert into dates (date) values ('2020-12-12');
insert into dates (date) values ('2020-03-11');
insert into dates (date) values ('2013-11-24');

select date+1 from dates;

create table workers (id int auto_increment, name varchar(30), salary int, departmentNumber int, primary key(id));
create table departments (id int auto_increment, name varchar(30),  primary key(id));
alter table workers add foreign key (departmentNumber) references departments(id);

insert into departments (name) values('Worker');
insert into departments (name) values('Manager');
insert into departments (name) values('Cleaner');
insert into departments (name) values('driver');
insert into workers (name, salary, departmentNumber) values ('Vasya', 300, 1);
insert into workers (name, salary, departmentNumber) values ('Vasya', 200, 1);
insert into workers (name, salary, departmentNumber) values ('Gena', 400, 2);
insert into workers (name, salary, departmentNumber) values ('Vasya', 350, 3);
insert into workers (name, salary, departmentNumber) values ('Ilya', 500, 3);
insert into workers (name, salary, departmentNumber) values ('Sergey', 300, 1);

select distinct name from workers;
select avg(salary) from workers;
select id,name from workers where salary>(select avg(salary) from workers); 
select departments.name from workers ws right join departments on ws.departmentNumber=departments.id where ws.departmentNumber is null;
update  workers set salary= case when salary=900  then 1000 else 1500 end; 
select concat (name,' ',salary)  as name_salary from workers; 
alter table workers rename slaves;


 