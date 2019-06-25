package com.home.takeaway.domain.repository;

import com.home.takeaway.domain.model.Dish;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DishRepository extends PagingAndSortingRepository<Dish, Long> {
}
