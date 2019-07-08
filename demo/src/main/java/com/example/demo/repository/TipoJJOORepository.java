package com.example.demo.repository;

import com.example.demo.entities.TipoJJOO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoJJOORepository extends JpaRepository<TipoJJOO, Integer> {
}
