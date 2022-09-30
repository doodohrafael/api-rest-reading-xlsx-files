-- drop tables
drop table costumer;
drop table address;

-- create tables
create table costumer (
	id bigint not null auto_increment,
    firstName varchar(50),
    lastName varchar(50),
    birthDate datetime,
    
    primary key (id)
)engine=InnoDB default charset=utf8mb4;

create table address (
	id bigint not null auto_increment,
    number varchar(15),
    email varchar(50),
    costumer_id bigint,
    primary key (id)
)engine=InnoDB default charset=utf8mb4;

-- select tables
select * from address;
select * from costumer;

-- insert data tables
insert into costumer (firstname, lastname, birthdate) values ('Douglas', 'Souza', '1996-10-26');
insert into costumer (firstname, lastname, birthdate) values ('Deborah', 'Santos', '1995-05-05');
insert into costumer (firstname, lastname, birthdate) values ('Betânia', 'Silva', '1974-09-07');

insert into address (number, email, costumer_id) values ('(81) 98531-2446', 'rafael_profissional@outlook.com', '1');
insert into address (number, email, costumer_id) values ('(81) 96324-6892', 'doodohrafael@gmail.com', '1');
insert into address (number, email, costumer_id) values ('(81) 93987-6565', 'doodoh2013@hotmail.com', '1');

insert into address (number, email, costumer_id) values ('(81) 98127-4545', 'beta@outlook.com', '3');
insert into address (number, email, costumer_id) values ('(81) 97642-1927', 'betania@outlook.com', '3');
insert into address (number, email, costumer_id) values ('(81) 92197-2717', 'bety@gmail.com', '3');

insert into address (number, email, costumer_id) values ('(81) 91379-6424', 'deborah@outlook.com', '2');
insert into address (number, email, costumer_id) values ('(81) 94793-1434', 'deby@outlook.com', '2');

-- select customized
select c.id, c.firstname, a.email, a.number
from costumer c
inner join address a on a.costumer_id = c.id
where c.id = 1 and a.email = 'doodohrafael@gmail.com';





