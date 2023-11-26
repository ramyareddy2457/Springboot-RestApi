package com.example.SpringBootRestApi.Repository;

import com.example.SpringBootRestApi.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findById(int id);
}
