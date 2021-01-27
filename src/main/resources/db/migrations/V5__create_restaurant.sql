-- author: Egor Pogadaev

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

insert into t_restaurant(name, address, contact_person, contact_phone, lat, lon, work_time, created, type) VALUES
    ('Coffee Like', 'г.Томск, ул. Усова 3/1', 'Иван Валуев', '8–800–333–41–30', 56.464077, 84.953329, '10:00 - 21:00 Ежедневно', now(), 'COFFEE'),
    ('Донер Мастер', 'г.Томск, ул. Усова 11а', 'Павел Иванович', '33-25-00', 56.454077, 85.953329, '09:00 - 22:00 Ежедневно', now(), 'FASTFOOD'),
    ('Донер Мастер', 'г.Томск, ул. Нахимова 87', 'Павел Иванович', '33-26-00', 55.445277, 84.953329, '09:00 - 22:00 Ежедневно', now(), 'FASTFOOD');