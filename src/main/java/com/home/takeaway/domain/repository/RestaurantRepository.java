package com.home.takeaway.domain.repository;

import com.home.takeaway.domain.model.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {
}
