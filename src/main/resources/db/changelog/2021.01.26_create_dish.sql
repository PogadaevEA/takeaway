--liquibase formatted sql

--changeset Egor Pogadaev:1
create sequence s_dishes;
drop table if exists dishes cascade;
create table dishes (
    id bigint not null default nextval('s_dishes') primary key,
    name varchar not null,
    price double precision not null,
    ingredients varchar(300),
    weight double precision not null,
    cooking_time double precision,
    calories double precision,
    created timestamp not null,
    updated timestamp not null
);

--changeset Egor Pogadaev:2
insert into dishes(id, name, price, ingredients, weight, cooking_time, calories, created, updated) values
    (nextval('s_dishes'), 'Шаурма', 115.00, 'Лаваш, курица, помидоры, огурец, картофель фри, соус', 250.00, 10.00, 345.00 , now(), now()),
    (nextval('s_dishes'), 'Шашлык', 150.00, 'Свинная шея, маринад', 200.00, 15.00, 215.00, now(), now()),
    (nextval('s_dishes'), 'Латте', 120.00, 'Молотый кофе, вода, молоко', 150.00, 5.00, 100.00, now(), now());