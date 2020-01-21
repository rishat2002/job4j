create database createupdateinsert;

create table role(
Id serial primary key,
Name varchar(30)
);

create table Users(
Id serial primary key,
Name varchar(30),
id_role Integer,
foreign key (Id_role) references role(id)
);

insert into role (name) values ('admin');
insert into role (name) values  ('mentor');

insert into users (name,id_role) values ('ivan',1);
insert into users (name,id_role) values ('slava',2);
insert into users (name,id_role) values ('pasha',1);

create table rule(
Id serial primary key,
ruleName varchar(30)
);

insert into rule (ruleName) values ('firstRule');
insert into rule (ruleName) values ('secondRule');

create table role_rule(
Id serial primary key,
Id_role Integer,
Id_rule Integer,
foreign key (Id_role) references role(id),
foreign key (Id_rule) references rule(id)
);

insert into role_rule (id_role,id_rule) values (1,1);
insert into role_rule (id_role,id_rule) values (2,1);
insert into role_rule (id_role,id_rule) values (2,2);

create table state(
Id serial primary key,
statename varchar(30)
);

create table category(
Id serial primary key,
categoryname varchar(30)
);

create table item(
Id serial primary key,
itemname varchar(30),
id_users Integer,
foreign key (id_users) references users(id),
id_category Integer,
foreign key (id_category) references category(id),
id_state Integer,
foreign key (id_state) references state(id)
);

create table attachs(
Id serial primary key,
atname varchar(30),
id_item Integer,
foreign key (id_item) references item(id)
);

create table comments1(
Id serial primary key,
itemname varchar(30),
id_item Integer,
foreign key (id_item) references item(id)
);
insert into state (statename) values ('firststate');
insert into state (statename) values ('secondstate');

insert into category (categoryname) values ('firstcat');
insert into category (categoryname) values ('secondcat');

insert into item (itemname,id_users,id_category,id_state) values ('firstitem',1,1,1);
insert into item (itemname,id_users,id_category,id_state) values ('seconditem',2,1,2);

insert into attachs (atname,id_item) values ('firstat',1);
insert into attachs (atname,id_item) values ('secondat',2);

insert into attachs (id_item) values (1);
insert into attachs (id_item) values (2);