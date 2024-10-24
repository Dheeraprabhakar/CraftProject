package com.example.CraftProject.repository;

import com.example.CraftProject.model.Sum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SumRepository extends JpaRepository<Sum, Long> {
}