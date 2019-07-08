package com.example.demo.services;

import com.example.demo.dtos.FullDtos.CiudadFullDtos;
import com.example.demo.dtos.FullDtos.PaisFullDtos;
import com.example.demo.dtos.FullDtos.SedeJJOOFullDtos;
import com.example.demo.dtos.SedeJJOODtos;
import com.example.demo.entities.*;
import com.example.demo.repository.CiudadRepository;
import com.example.demo.repository.PaisRepository;
import com.example.demo.repository.SedeJJOORepository;
import com.example.demo.repository.TipoJJOORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SedeJJOOService {

    @Autowired
    private SedeJJOORepository sedeJJOORepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private TipoJJOORepository tipoJJOORepository;

    public Optional<List> findAll() {
        List<SedeJJOODtos> toret = new ArrayList<>();
        List<SedeJJOO> sedeJJOOList = sedeJJOORepository.findAll();
        Iterator<SedeJJOO> listIt = sedeJJOOList.iterator();
        while (listIt.hasNext()) {
            SedeJJOO sedeJJOO = listIt.next();
            SedeJJOODtos sedeJJOODtos = new SedeJJOODtos(sedeJJOO.getSedeJJOOPK().getAño(), sedeJJOO.getSedeJJOOPK().getTipoJJOO().getIdTipoJJOO(), sedeJJOO.getCiudadSede().getIdCiudad());
            toret.add(sedeJJOODtos);
        }
        return Optional.of(toret);
    }

    public Optional<List> findAllFull() {
        List<SedeJJOOFullDtos> toret = new ArrayList<>();
        List<SedeJJOO> sedeJJOOList = sedeJJOORepository.findAll(new Sort(Sort.DEFAULT_DIRECTION, "sedeJJOOPK"));
        Iterator<SedeJJOO> listIt = sedeJJOOList.iterator();
        while (listIt.hasNext()) {
            SedeJJOO sedeJJOO = listIt.next();
            PaisFullDtos paisFullDtos = new PaisFullDtos(sedeJJOO.getCiudadSede().getPais().getIdPais(), sedeJJOO.getCiudadSede().getPais().getNombrePais(), sedeJJOO.getCiudadSede().getPais().getCodigoPais(), sedeJJOO.getCiudadSede().getPais().getValorPais());
            CiudadFullDtos ciudadFullDtos = new CiudadFullDtos(sedeJJOO.getCiudadSede().getIdCiudad(), sedeJJOO.getCiudadSede().getValorCiudad(), sedeJJOO.getCiudadSede().getNombreCiudad(), paisFullDtos);
            SedeJJOOFullDtos sedeJJOOFullDtos = new SedeJJOOFullDtos(sedeJJOO.getSedeJJOOPK().getAño(), sedeJJOO.getSedeJJOOPK().getTipoJJOO().getIdTipoJJOO(), ciudadFullDtos);
            toret.add(sedeJJOOFullDtos);
        }
        return Optional.of(toret);
    }

    public Optional save(SedeJJOODtos sedeJJOODtos) {
        Optional toret;
        Optional ciudad = ciudadRepository.findById(sedeJJOODtos.getSede());
        if(ciudad.isPresent()) {
            Optional tipoJJOO = tipoJJOORepository.findById(sedeJJOODtos.getIdTipoJJOO());
            if(tipoJJOO.isPresent()) {
                SedeJJOO sedeJJOO = new SedeJJOO(new SedeJJOOPK(sedeJJOODtos.getAño(), (TipoJJOO) tipoJJOO.get()), (Ciudad) ciudad.get());
                SedeJJOO returned = sedeJJOORepository.save(sedeJJOO);
                sedeJJOODtos = new SedeJJOODtos(returned.getSedeJJOOPK().getAño(), returned.getSedeJJOOPK().getTipoJJOO().getIdTipoJJOO(), returned.getCiudadSede().getIdCiudad());
                return toret = Optional.of(sedeJJOODtos);
            }
            else return tipoJJOO;
        }
        else return ciudad;
    }

    public Optional save(SedeJJOOFullDtos sedeJJOODtos) {
        Optional toret;
        Optional tipoJJOO = tipoJJOORepository.findById(sedeJJOODtos.getIdTipoJJOO());
        if(tipoJJOO.isPresent()) {
            Optional ciudad = ciudadRepository.findById(sedeJJOODtos.getCiudad().getIdCiudad());
            if (!ciudad.isPresent()) {
                Optional pais = paisRepository.findById(sedeJJOODtos.getCiudad().getPais().getIdPais());
                if (!pais.isPresent()) {
                    paisRepository.save(new Pais(sedeJJOODtos.getCiudad().getPais().getIdPais(), sedeJJOODtos.getCiudad().getPais().getNombrePais(),
                            sedeJJOODtos.getCiudad().getPais().getCodigoPais(), sedeJJOODtos.getCiudad().getPais().getValorPais()));
                    pais = paisRepository.findById(sedeJJOODtos.getCiudad().getPais().getIdPais());
                }
                ciudadRepository.save(new Ciudad(sedeJJOODtos.getCiudad().getIdCiudad(), sedeJJOODtos.getCiudad().getValorCiudad(), sedeJJOODtos.getCiudad().getNombreCiudad(), (Pais) pais.get()));
                ciudad = ciudadRepository.findById(sedeJJOODtos.getCiudad().getIdCiudad());
            }
            SedeJJOO sedeJJOO = new SedeJJOO(new SedeJJOOPK(sedeJJOODtos.getAño(), (TipoJJOO) tipoJJOO.get()), (Ciudad) ciudad.get());
            sedeJJOORepository.save(sedeJJOO);
            return toret = Optional.of(sedeJJOODtos);
        } else {
            return tipoJJOO;
        }
    }

    public Optional findById(Integer id, Integer idTipoJJOO) {
        Optional optionalTipoJJOO = tipoJJOORepository.findById(idTipoJJOO);
        if(optionalTipoJJOO.isPresent()) {
            SedeJJOOPK sedeJJOOPK = new SedeJJOOPK(id, (TipoJJOO) optionalTipoJJOO.get());
            Optional sedeJJOOOptional = sedeJJOORepository.findById(sedeJJOOPK);
            if(sedeJJOOOptional.isPresent()) {
                SedeJJOO sedeJJOO = (SedeJJOO) sedeJJOOOptional.get();
                SedeJJOODtos sedeJJOODtos = new SedeJJOODtos(sedeJJOO.getSedeJJOOPK().getAño(), sedeJJOO.getSedeJJOOPK().getTipoJJOO().getIdTipoJJOO(), sedeJJOO.getCiudadSede().getIdCiudad());
                return Optional.of(sedeJJOODtos);
            }
            else
                return sedeJJOOOptional;
        }
        else
            return optionalTipoJJOO;
    }

    public void deleteById(Integer id, Integer idTipoJJOO) {
        TipoJJOO tipoJJOO = tipoJJOORepository.findById(idTipoJJOO).get();
        SedeJJOOPK sedeJJOOPK = new SedeJJOOPK(id, tipoJJOO);
        sedeJJOORepository.deleteById(sedeJJOOPK);
    }
}