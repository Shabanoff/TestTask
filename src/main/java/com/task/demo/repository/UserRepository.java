package com.task.demo.repository;

import com.task.demo.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findTop20ByUserIdOrderByResultDescLevelIdDesc (Long userId);

    List<User> findTop20ByLevelIdOrderByResultDescUserIdDesc (Long levelId);
}
