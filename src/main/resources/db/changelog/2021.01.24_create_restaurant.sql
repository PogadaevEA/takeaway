--liquibase formatted sql

--changeset Egor Pogadaev:1
drop table if exists restaurants cascade;
create table restaurants (
    id bigint not null default nextval('hibernate_sequence') primary key,
    name varchar(250) not null,
    address varchar not null,
    contact_person varchar(250),
    contact_phone varchar(30),
    lat double precision,
    lon double precision,
    work_time varchar,
    created timestamp not null,
    type varchar(30) not null
);

--changeset Egor Pogadaev:2
insert into restaurants(name, address, contact_person, contact_phone, lat, lon, work_time, created, type) VALUES
    ('Coffee Like', 'г.Томск, ул. Усова 3/1', 'Иван Валуев', '8–800–333–41–30', 56.464077, 84.953329, '10:00 - 21:00 Ежедневно', now(), 'COFFEE'),
    ('Донер Мастер', 'г.Томск, ул. Усова 11а', 'Павел Иванович', '33-25-00', 56.454077, 85.953329, '09:00 - 22:00 Ежедневно', now(), 'FASTFOOD'),
    ('Донер Мастер', 'г.Томск, ул. Нахимова 87', 'Павел Иванович', '33-26-00', 55.445277, 84.953329, '09:00 - 22:00 Ежедневно', now(), 'FASTFOOD');