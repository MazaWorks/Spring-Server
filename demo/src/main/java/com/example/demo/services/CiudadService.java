package com.example.demo.services;

import com.example.demo.dtos.IdsDtos;
import com.example.demo.entities.Mysql.Ciudad;
import com.example.demo.repository.Mysql.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CiudadService {
/*    @Autowired
    private LogService logService;
*/
    @Autowired
    private CiudadRepository ciudadRepository;

    public boolean delete(Integer id){
        boolean toret = false;
//        IdsDtos log = new IdsDtos(id, null, null);
        Optional<Ciudad> byId = ciudadRepository.findById(id);
        if(byId.isPresent()) {
            ciudadRepository.deleteById(id);
//            logService.deleteLog(log, HttpStatus.OK.toString());
            toret = true;
        }// else
//            logService.deleteLog(null, HttpStatus.NOT_FOUND.toString());
        return toret;
    }
}
