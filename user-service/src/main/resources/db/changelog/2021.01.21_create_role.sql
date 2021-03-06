--liquibase formatted sql

--changeset Egor Pogadaev:1
drop table if exists roles cascade;
create table roles (
    id varchar(250) not null primary key,
    name varchar(300) not null,
    creator varchar(250),
    created timestamp not null
);
--changeset Egor Pogadaev:2
insert into roles (id, name, creator, created) values
    ('SUPER_ADMIN', 'Администратор TakeAway LLC', 'egor.pogadaev@gmail.com', now()),
    ('ADMIN', 'Администратор Ресторана','egor.pogadaev@gmail.com', now()),
    ('USER', 'Клиент','egor.pogadaev@gmail.com', now());