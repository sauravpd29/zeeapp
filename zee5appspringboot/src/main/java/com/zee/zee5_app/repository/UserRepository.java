package com.zee.zee5_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5_app.dto.Register;
@Repository
public interface UserRepository extends JpaRepository<Register, String> {

}
