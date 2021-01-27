-- author: Egor Pogadaev

drop table if exists t_category cascade;
create table t_category (
    id varchar(25) not null primary key,
    name varchar(25) not null,
    created timestamp not null
);

insert into t_category (id, name, created) values
    ('FASTFOOD', 'Фастфуд', now()),
    ('COFFEE', 'Кофе', now());