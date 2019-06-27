drop table if exists t_role cascade;
create table t_role (
    id varchar(250) not null primary key,
    name varchar(300) not null,
    creator varchar(250),
    created timestamp not null
);

drop table if exists t_role_permission cascade;
create table t_role_permission (
    role_id varchar(250) not null,
    permission varchar(128) not null,

    constraint t_role_permission_pk primary key (role_id, permission)
);

drop table if exists t_restaurant cascade;
create table t_restaurant (
    id bigint not null default nextval('hibernate_sequence') primary key,
    name varchar(250) not null,
    address varchar not null,
    contact_person varchar(250),
    contact_phone varchar(30),
    lat double precision,
    lon double precision,
    work_time text,
    created timestamp not null,
    type varchar(30) not null
);

drop table if exists t_user cascade;
create table t_user (
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

    constraint t_user_role_fk foreign key (role_id) references t_role (id)
);

drop table if exists t_category cascade;
create table t_category (
    id varchar(25) not null primary key,
    name varchar(25) not null,
    created timestamp not null
);

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

drop table if exists t_dish_restaurant_category cascade;
create table t_dish_restaurant_category (
    dish_id bigint not null,
    restaurant_id bigint not null,
    category_id varchar(25) not null,

    constraint t_drc_dish_id_fkey foreign key (dish_id) references t_dish(id),
    constraint t_drc_restaurant_id_fkey foreign key (restaurant_id) references t_restaurant(id),
    constraint t_drc_category_id_fkey foreign key (category_id) references t_category(id)
);

insert into t_role_permission (role_id, permission) values
    ('SUPER_ADMIN', 'USER_READ'),
    ('SUPER_ADMIN', 'USER_CREATE'),
    ('SUPER_ADMIN', 'USER_MODIFY'),
    ('SUPER_ADMIN', 'USER_REMOVE'),
    ('SUPER_ADMIN', 'ROLE_READ'),
    ('SUPER_ADMIN', 'ROLE_CREATE'),
    ('SUPER_ADMIN', 'ROLE_MODIFY'),
    ('SUPER_ADMIN', 'ROLE_REMOVE'),
    ('SUPER_ADMIN', 'RESTAURANT_READ'),
    ('SUPER_ADMIN', 'RESTAURANT_CREATE'),
    ('SUPER_ADMIN', 'RESTAURANT_MODIFY'),
    ('SUPER_ADMIN', 'RESTAURANT_REMOVE'),

    ('ADMIN', 'USER_READ'),
    ('ADMIN', 'USER_CREATE'),
    ('ADMIN', 'USER_MODIFY'),
    ('ADMIN', 'USER_REMOVE'),
    ('ADMIN', 'ROLE_READ'),
    ('ADMIN', 'ROLE_CREATE'),
    ('ADMIN', 'ROLE_MODIFY'),
    ('ADMIN', 'ROLE_REMOVE');


insert into t_role (id, name, creator, created) values
    ('SUPER_ADMIN', 'Администратор TakeAway LLC', 'egor.pogadaev@gmail.com', now()),
    ('ADMIN', 'Администратор Ресторана','egor.pogadaev@gmail.com', now()),
    ('USER', 'Клиент','egor.pogadaev@gmail.com', now());

-- TODO переделать инсерт для t_restaurant, t_category, t_dish и t_dish_restaurant_category
insert into t_restaurant(name, address, contact_person, contact_phone, lat, lon, work_time, created, type) VALUES
    ('Coffee Like', 'г.Томск, ул. Усова 3/1', 'Иван Валуев', '8–800–333–41–30', 56.464077, 84.953329, '10:00 - 21:00 Ежедневно', now(), 'COFFEE'),
    ('Донер Мастер', 'г.Томск, ул. Усова 11а', 'Павел Иванович', '33-25-00', 56.454077, 85.953329, '09:00 - 22:00 Ежедневно', now(), 'FASTFOOD'),
    ('Донер Мастер', 'г.Томск, ул. Нахимова 87', 'Павел Иванович', '33-26-00', 55.445277, 84.953329, '09:00 - 22:00 Ежедневно', now(), 'FASTFOOD');

insert into t_user(id, name, surname, middle_name, phone, password, password_temp, creator, restaurant_id, role_id, created) values
    ('egor.pogadaev@gmail.com', 'Егор', 'Погадаев', 'Андреевич', '8-961-886-99-69', '18346', '18346', 'egor.pogadaev@gmail.com', null, 'SUPER_ADMIN', now()),
    ('adminLike@like.ru', 'Алексей', 'Иванов', 'Юрьевич', '8-985-874-68-84', '123456', '123456', 'egor.pogadaev@gmail.com', 1, 'ADMIN', now()),
    ('admin1Doner@like.ru', 'Сергей', 'Мамаев', 'Сергеевич', '8-254-999-88-00', 'фывапр', 'фывапр', null, 2, 'ADMIN', now()),
    ('admin2Doner@like.ru', 'Павел', 'Томских', 'Семенович', '8-586-254-47-74', 'йцуйцу', 'йцуйцу', null, 3, 'ADMIN', now()),
    ('user1@user.ru', 'Людмила', 'Шишкачева', 'Ивановна', '89745879654', '123456', '123456', null, null, 'USER', now()),
    ('user2@user.ru', 'Наташа', 'Пухно', 'Артемовна', '+74569854125', '123123', '123123', null, null, 'USER', now()),
    ('user3@user.ru', 'Денис', 'Збродько', 'Солбонович', '78966589658', '111111', '111111', null, null, 'USER', now());

insert into t_category (id, name, created) values
    ('FASTFOOD', 'Фастфуд', now()),
    ('COFFEE', 'Кофе', now());

insert into t_dish(name, price, ingredients, weight, cooking_time, calories, created, updated) values
    ('Шаурма', 115.00, 'Лаваш, курица, помидоры, огурец, картофель фри, соус', 250.00, 10.00, 345.00 , now(), now()),
    ('Шашлык', 150.00, 'Свинная шея, маринад', 200.00, 15.00, 215.00, now(), now()),
    ('Латте', 120.00, 'Молотый кофе, вода, молоко', 150.00, 5.00, 100.00, now(), now());




