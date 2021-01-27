-- author: Egor Pogadaev

drop table if exists t_dish cascade;
create table t_dish (
    id bigint not null default nextval('hibernate_sequence') primary key,
    name text not null,
    price double precision not null,
    ingredients varchar(300),
    weight double precision not null,
    cooking_time double precision,
    calories double precision,
    created timestamp not null,
    updated timestamp not null
);

insert into t_dish(name, price, ingredients, weight, cooking_time, calories, created, updated) values
    ('Шаурма', 115.00, 'Лаваш, курица, помидоры, огурец, картофель фри, соус', 250.00, 10.00, 345.00 , now(), now()),
    ('Шашлык', 150.00, 'Свинная шея, маринад', 200.00, 15.00, 215.00, now(), now()),
    ('Латте', 120.00, 'Молотый кофе, вода, молоко', 150.00, 5.00, 100.00, now(), now());