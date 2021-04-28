--liquibase formatted sql

--changeset Egor Pogadaev:1
drop table if exists role_permissions cascade;
create table role_permissions (
    role_id varchar(250) not null,
    permission varchar(128) not null,

    constraint role_permissions_pk primary key (role_id, permission)
);

--changeset Egor Pogadaev:2
insert into role_permissions (role_id, permission) values
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