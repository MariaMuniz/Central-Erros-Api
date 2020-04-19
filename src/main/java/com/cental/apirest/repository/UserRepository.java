package com.cental.apirest.repository;

import com.cental.apirest.model.Log;
import com.cental.apirest.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {




    List<User> findAll();

    @Query(value = "select id, name, email, password, created_at from tb_user where id = :userId", nativeQuery = true)
    Optional<User> findById(@Param("userId") Long userId);

    Optional<User> findByEmail(@Param("email") String email);


}




