create table type (
id serial primary key,
name varchar(30)
);
create table product (
id serial primary key ,
name varchar(30),
type_id Integer,
expired_date timestamp ,
price Integer,
foreign key (type_id) references type(id)
);
insert into type (name) values ('СЫР');
insert into type (name) values ('МОРОЖЕНОЕ');
insert into type (name) values ('МЯСО');
insert into type (name) values ('МОЛОКО');
insert into product (name,type_id,expired_date,price) values ('голландский',1,'15.10.2020',200);
insert into product (name,type_id,expired_date,price) values ('сулугуни',1,'15.02.2020',250);
insert into product (name,type_id,expired_date,price)
values ('советское мороженое',2,'15.03.2020',60);
insert into product (name,type_id,expired_date,price)
values ('bon pari',2,'15.02.2020',60);
insert into product (name,type_id,expired_date,price)
select *from product where type_id=1;
select *from product where name like '%мороженое%';
select *from product where expired_date < '01.03.2020';
select max(price) from product;
select count(*) from product where type_id=2;
values ('молочник',3,'30.01.2020',60);
select * from product where type_id=1 or type_id=3;
select *from product ;