package com.example.demo.repository.Mysql;

import com.example.demo.entities.SedeJJOO;
import com.example.demo.entities.SedeJJOOPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeJJOORepository extends JpaRepository<SedeJJOO, SedeJJOOPK> {

}
