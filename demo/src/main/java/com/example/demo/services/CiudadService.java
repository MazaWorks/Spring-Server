package com.example.demo.services;

import com.example.demo.entities.Ciudad;
import com.example.demo.repository.Mysql.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public void deleteById(Integer id) {
        ciudadRepository.deleteById(id);
    }

    public Optional<Ciudad> findById(Integer id) {
        return ciudadRepository.findById(id);
    }
}
