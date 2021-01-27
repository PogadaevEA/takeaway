-- author: Egor Pogadaev

drop table if exists t_dish_restaurant_category cascade;
create table t_dish_restaurant_category (
    dish_id bigint not null,
    restaurant_id bigint not null,
    category_id varchar(25) not null,

    constraint t_drc_dish_id_fkey foreign key (dish_id) references t_dish(id),
    constraint t_drc_restaurant_id_fkey foreign key (restaurant_id) references t_restaurant(id),
    constraint t_drc_category_id_fkey foreign key (category_id) references t_category(id)
);


