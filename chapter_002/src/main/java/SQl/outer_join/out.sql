--create table cusov (
--id serial primary key,
--name varchar(80),
--color varchar(90)
--);

--create table korobka (
--id serial primary key,
--name varchar(80),
--color varchar(90)
--);

--create table engine (
--id serial primary key,
---name varchar(80),
--max_power integer
--);

--insert into cusov (name,color) values ('vr2003','red');
--insert into cusov (name,color) values ('vr2010','green');
--insert into cusov (name,color) values ('mp2001','black');
--insert into cusov (name,color) values ('mp3000','red');
--insert into korobka (name,color) values ('gr3000','red');
--insert into korobka (name,color) values ('gr3001','green');
--insert into korobka (name,color) values ('gr3002','black');
--insert into korobka (name,color) values ('gr3003','red-black');
--insert into korobka (name,color) values ('gr3004','green');
---insert into engine (name,max_power) values ('engine1',4000);
--insert into engine (name,max_power) values ('engine2',2500);
--insert into engine (name,max_power) values ('engine3',2500);
--create table car (
--id serial primary key,
--name varchar(80),
--color varchar(90),
--id_cusov Integer not null,
--id_engine Integer not null,
--id_korobka Integer not null,
--FOREIGN KEY (id_cusov) REFERENCES cusov(id),
--FOREIGN KEY (id_korobka) REFERENCES korobka(id),
--FOREIGN KEY (id_engine) REFERENCES engine(id)
--);

--insert into car (name,color,id_cusov,id_engine,id_korobka)
--values ('logan','red',1,1,1);
--insert into car (name,color,id_cusov,id_engine,id_korobka)
--values ('kaptur','green',2,2,1);

--select * from car
--left join cusov on  cusov.id=car.id_cusov
--left join korobka on  korobka.id=car.id_korobka
--left join engine on  engine.id=car.id_engine;

--select *from cusov where id<>(select id_cusov from car where name='logan');
--select *from korobka where id<>(select id_korobka from car where name='logan');
--select *from engine where id<>(select id_engine from car where name='logan');