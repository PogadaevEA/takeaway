-- author: Egor Pogadaev

drop table if exists t_role cascade;
create table t_role (
    id varchar(250) not null primary key,
    name varchar(300) not null,
    creator varchar(250),
    created timestamp not null
);

insert into t_role (id, name, creator, created) values
    ('SUPER_ADMIN', 'Администратор TakeAway LLC', 'egor.pogadaev@gmail.com', now()),
    ('ADMIN', 'Администратор Ресторана','egor.pogadaev@gmail.com', now()),
    ('USER', 'Клиент','egor.pogadaev@gmail.com', now());