package com.takeaway.restaurant.domain.repository;

import com.takeaway.restaurant.domain.model.CoffeeRestaurant;
import com.takeaway.restaurant.domain.model.FastFoodRestaurant;
import com.takeaway.restaurant.domain.model.Restaurant;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RestaurantRepository {

    @Insert("insert into restaurants(name, address, contact_person, contact_phone, lat, lon, work_time, created, type, user_id) VALUES " +
            "('${restaurant.getName()}', #{restaurant.address}, #{restaurant.contactPerson}, #{restaurant.contactPhone}, #{restaurant.lat}, #{restaurant.lon}, #{restaurant.workTime}, now(), '${restaurant.getRestaurantType()}', 'egor.pogadaev@gmail.com')")
    /**
     * TODO сделать так что бы возвращался идентификатор вставки
     * Пробовал и НЕ сработало
     * @Options(useGeneratedKeys=true, keyProperty="person.id", keyColumn="id")
     * @SelectKey(statement = "select last_value from s_restaurants", keyProperty = "id", before = false, resultType = Long.class)
     */
    long save(@Param("restaurant") Restaurant restaurant);

    @Select("select * from restaurants")
    @TypeDiscriminator(javaType = String.class, column = "type", cases = {
            @Case(value = "FASTFOOD", type = FastFoodRestaurant.class),
            @Case(value = "COFFEE", type = CoffeeRestaurant.class)
    })
    List<Restaurant> findAll();

    @Select("select * from restaurants where user_id = #{userId}")
    @TypeDiscriminator(javaType = String.class, column = "type", cases = {
            @Case(value = "FASTFOOD", type = FastFoodRestaurant.class),
            @Case(value = "COFFEE", type = CoffeeRestaurant.class)
    })
    List<Restaurant> findAllByUserId(@Param("userId") String userId);

    @Select("select * from restaurants where id = #{restaurantId}")
    @TypeDiscriminator(javaType = String.class, column = "type", cases = {
            @Case(value = "FASTFOOD", type = FastFoodRestaurant.class),
            @Case(value = "COFFEE", type = CoffeeRestaurant.class)
    })
    Restaurant findOne(Long restaurantId);

    @Select("select last_value from s_restaurants")
    long getLastId();
}
