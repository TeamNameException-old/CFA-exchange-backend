package com.fintech.market.repos;

import com.fintech.market.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User, Long> {}
