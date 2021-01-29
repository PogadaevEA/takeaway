--liquibase formatted sql

--changeset Egor Pogadaev:1
drop table if exists dish_restaurant_categories cascade;
create table dish_restaurant_categories (
    dish_id bigint not null,
    restaurant_id bigint not null,
    category_id varchar(25) not null,

    constraint t_drc_dish_id_fkey foreign key (dish_id) references dishes(id),
    constraint t_drc_restaurant_id_fkey foreign key (restaurant_id) references restaurants(id),
    constraint t_drc_category_id_fkey foreign key (category_id) references categories(id)
);


