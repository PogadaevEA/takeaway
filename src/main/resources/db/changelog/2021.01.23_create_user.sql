--liquibase formatted sql

--changeset Egor Pogadaev:1
drop table if exists users cascade;
create table users (
    id varchar(250) not null primary key ,
    name varchar(250) not null,
    surname varchar(250) not null,
    middle_name varchar(250),
    phone varchar(30),
    password varchar(250) not null,
    password_temp varchar(250) not null,
    creator varchar(250),
    restaurant_id bigint,
    role_id varchar(250) not null,
    created timestamp not null,

    constraint user_role_fk foreign key (role_id) references roles (id)
);

--changeset Egor Pogadaev:2
insert into users(id, name, surname, middle_name, phone, password, password_temp, creator, restaurant_id, role_id, created)values
    ('egor.pogadaev@gmail.com', 'Егор', 'Погадаев', 'Андреевич', '8-961-886-99-69', '$2a$10$a9AfZeFEZGGlQHRlRfxji.Tgc6cgUFuPgMwwsywG.kK9loV7RitzK', '18346', 'egor.pogadaev@gmail.com', null, 'SUPER_ADMIN', now()),
    ('adminLike@like.ru', 'Алексей', 'Иванов', 'Юрьевич', '8-985-874-68-84', '123456', '123456', 'egor.pogadaev@gmail.com', 1, 'ADMIN', now()),
    ('admin1Doner@like.ru', 'Сергей', 'Мамаев', 'Сергеевич', '8-254-999-88-00', 'фывапр', 'фывапр', null, 2, 'ADMIN', now()),
    ('admin2Doner@like.ru', 'Павел', 'Томских', 'Семенович', '8-586-254-47-74', 'йцуйцу', 'йцуйцу', null, 3, 'ADMIN', now()),
    ('user1@user.ru', 'Людмила', 'Шишкачева', 'Ивановна', '89745879654', '123456', '123456', null, null, 'USER', now()),
    ('user2@user.ru', 'Наташа', 'Пухно', 'Артемовна', '+74569854125', '123123', '123123', null, null, 'USER', now()),
    ('user3@user.ru', 'Денис', 'Збродько', 'Солбонович', '78966589658', '111111', '111111', null, null, 'USER', now());