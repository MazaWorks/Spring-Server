package com.example.demo.repository.Mysql;

import com.example.demo.entities.Mysql.TipoJJOO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoJJOORepository extends JpaRepository<TipoJJOO, Integer> {
}
