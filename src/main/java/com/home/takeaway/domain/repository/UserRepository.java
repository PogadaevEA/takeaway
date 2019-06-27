package com.home.takeaway.domain.repository;

import com.home.takeaway.domain.model.security.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
