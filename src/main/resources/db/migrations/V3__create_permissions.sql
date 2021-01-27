-- author: Egor Pogadaev

drop table if exists t_role_permission cascade;
create table t_role_permission (
    role_id varchar(250) not null,
    permission varchar(128) not null,

    constraint t_role_permission_pk primary key (role_id, permission)
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