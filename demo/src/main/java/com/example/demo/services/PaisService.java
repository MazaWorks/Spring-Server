package com.example.demo.services;

import com.example.demo.dtos.PaisDtos;
import com.example.demo.entities.Pais;
import com.example.demo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public Optional<List> findAll() {
        List<PaisDtos> toret = new ArrayList<>();
        List<Pais> paisList = paisRepository.findAll();
        Iterator<Pais> listIt = paisList.iterator();
        while (listIt.hasNext()) {
            Pais pais = listIt.next();
            PaisDtos paisDtos = new PaisDtos(pais.getValorPais(), pais.getIdPais(), pais.getNombrePais(), pais.getCodigoPais());
            toret.add(paisDtos);
        }
        return Optional.of(toret);
    }
}
