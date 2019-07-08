package com.example.demo.repository;

import com.example.demo.entities.SedeJJOO;
import com.example.demo.entities.SedeJJOOPK;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SedeJJOORepository extends JpaRepository<SedeJJOO, SedeJJOOPK> {
}
