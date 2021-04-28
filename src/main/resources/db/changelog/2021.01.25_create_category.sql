--liquibase formatted sql

--changeset Egor Pogadaev:1
drop table if exists categories cascade;
create table categories (
    id varchar(25) not null primary key,
    name varchar(25) not null,
    created timestamp not null
);

--changeset Egor Pogadaev:2
insert into categories (id, name, created) values
    ('FASTFOOD', 'Фастфуд', now()),
    ('COFFEE', 'Кофе', now());