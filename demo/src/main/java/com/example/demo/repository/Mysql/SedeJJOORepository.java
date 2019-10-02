package com.example.demo.repository.Mysql;

import com.example.demo.entities.Mysql.SedeJJOO;
import com.example.demo.entities.Mysql.SedeJJOOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeJJOORepository extends JpaRepository<SedeJJOO, SedeJJOOPK> {
}
