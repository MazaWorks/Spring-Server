package com.example.demo.services;

import com.example.demo.dtos.PaisDtos;
import com.example.demo.entities.Mysql.Pais;
import com.example.demo.repository.Mysql.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class PaisService {
    @Autowired
    private LogService logService;

    @Autowired
    private PaisRepository paisRepository;

    public List findAll() {
        List<PaisDtos> toret = new ArrayList<>();
        List<Pais> paisList = paisRepository.findAll();
        Iterator<Pais> listIt = paisList.iterator();
        while (listIt.hasNext()) {
            Pais pais = listIt.next();
            PaisDtos paisDtos = new PaisDtos(pais.getValorPais(), pais.getIdPais(), pais.getNombrePais(), pais.getCodigoPais());
            toret.add(paisDtos);
        }
        if(toret.size() == 0)
            logService.getLog(toret, HttpStatus.OK.toString());
        else
            logService.getLog(toret, HttpStatus.OK.toString());
        return toret;
    }
}
