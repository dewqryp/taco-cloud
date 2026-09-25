package org.dewqryp.tacocloud.repositories;

import org.dewqryp.tacocloud.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
