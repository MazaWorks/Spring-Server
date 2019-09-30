package com.example.demo.repository.Mysql;

import com.example.demo.entities.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
}
