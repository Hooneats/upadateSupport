package com.example.temptest;

import com.example.temptest.entity.GreenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaInterface extends JpaRepository<GreenEntity, Long> {

}
