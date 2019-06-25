package com.home.takeaway.domain.repository;

import com.home.takeaway.domain.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, String> {
}
