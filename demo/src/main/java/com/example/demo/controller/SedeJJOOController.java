package com.example.demo.controller;

import com.example.demo.daos.mongo.DAODelete;
import com.example.demo.daos.mongo.DAOGets;
import com.example.demo.daos.mongo.DAOPosts;
import com.example.demo.daos.mysql.DAO;
import com.example.demo.dtos.Consulta1Dtos;
import com.example.demo.dtos.FullDtos.SedeJJOOFullDtos;
import com.example.demo.dtos.SedeJJOODtos;
import com.example.demo.services.CiudadService;
import com.example.demo.services.PaisService;
import com.example.demo.services.SedeJJOOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class SedeJJOOController {

    @Autowired
    private SedeJJOOService sedeJJOOService;

    @Autowired
    private PaisService paisService;

    @Autowired
    private CiudadService ciudadService;

    private final DAOGets daoGets = new DAOGets();
    private final DAOPosts daoPosts = new DAOPosts();
    private final DAODelete daoDelete = new DAODelete();

    @GetMapping("consulta")
    ResponseEntity getConsulta(){
        DAO dao = new DAO();
        List<Consulta1Dtos> toret = dao.get();
    //    daoGets.create(toret, HttpStatus.OK.toString());
        return new ResponseEntity(toret, HttpStatus.OK);
    }

    @GetMapping("sedeJJOO/get")
    ResponseEntity get(){
        Optional<List> toret = sedeJJOOService.findAll();
        if(toret.isPresent()) {
    //        daoGets.create(toret.get(), HttpStatus.OK.toString());
            return new ResponseEntity(toret.get(), HttpStatus.OK);
        } else {
    //        daoGets.create(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity("ERROR: Juego Olímpico no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("pais/get")
    ResponseEntity getPais() {
        Optional<List> toret = paisService.findAll();
        if(toret.isPresent()) {
     //       daoGets.create(toret.get(), HttpStatus.OK.toString());
            return new ResponseEntity(toret.get(), HttpStatus.OK);
        } else {
    //        daoGets.create(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity("ERROR: Pais no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("sedeJJOO/getAll")
    ResponseEntity getAll(){
        Optional<List> toret = sedeJJOOService.findAllFull();
        if(toret.isPresent()) {
    //        daoGets.create(toret.get(), HttpStatus.OK.toString());
            return new ResponseEntity(toret.get(), HttpStatus.OK);
        } else {
    //        daoGets.create(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity("ERROR: Juego Olímpico no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("sedeJJOO/get/{año}/{id_tipo_JJOO}")
    ResponseEntity one(@PathVariable Integer año, @PathVariable Integer id_tipo_JJOO){
        Optional toret = sedeJJOOService.findById(año, id_tipo_JJOO);
        if(toret.isPresent()) {
    //        daoGets.create((SedeJJOODtos) toret.get(), HttpStatus.OK.toString());
            return new ResponseEntity(toret.get(), HttpStatus.OK);
        } else {
     //       daoGets.create(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity("ERROR: El año y/o tipo del juego olímpico no ha sido encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("sedeJJOO/update/{año}/{id_tipo_JJOO}")
    ResponseEntity update(@RequestBody SedeJJOODtos sedeJJOO, @PathVariable Integer año, @PathVariable Integer id_tipo_JJOO) throws Exception {
        if(año == sedeJJOO.getAño() && id_tipo_JJOO == sedeJJOO.getIdTipoJJOO()){
            if(sedeJJOOService.findById(año, id_tipo_JJOO).isPresent()) {
                if(sedeJJOOService.save(sedeJJOO).isPresent()){
                    SedeJJOODtos toret = (SedeJJOODtos) sedeJJOOService.save(sedeJJOO).get();
      //              daoPosts.create(toret, HttpStatus.OK.toString());
                    return new ResponseEntity(toret, HttpStatus.OK);
                } else {
      //              daoPosts.create(HttpStatus.NOT_FOUND.toString());
                    return new ResponseEntity("ERROR: Ciudad no encontrada", HttpStatus.NOT_FOUND);
                }
            }
            else {
      //          daoPosts.create(HttpStatus.NOT_FOUND.toString());
                return new ResponseEntity("ERROR: El año y/o tipo del juego olímpico no ha sido encontrado", HttpStatus.NOT_FOUND);
            }
        } else{
      //      daoPosts.create(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity("ERROR: Los campos de la URL no coinciden con los del BODY", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("sedeJJOO/post/{año}/{id_tipo_JJOO}")
    ResponseEntity post(@RequestBody SedeJJOODtos sedeJJOO, @PathVariable Integer año, @PathVariable Integer id_tipo_JJOO) throws Exception {
        if(año == sedeJJOO.getAño() && id_tipo_JJOO == sedeJJOO.getIdTipoJJOO()){
            if(sedeJJOOService.findById(año, id_tipo_JJOO).isPresent()){
      //          daoPosts.create(HttpStatus.BAD_REQUEST.toString());
                return new ResponseEntity("ERROR: Este id ya existe, solo se puede modificar", HttpStatus.FOUND);
            } else {
                if (sedeJJOOService.save(sedeJJOO).isPresent()) {
                    SedeJJOODtos toret = (SedeJJOODtos) sedeJJOOService.save(sedeJJOO).get();
      //              daoPosts.create(toret, HttpStatus.OK.toString());
                    return new ResponseEntity(toret, HttpStatus.OK);
                } else {
                  //  daoPosts.create(HttpStatus.NOT_FOUND.toString());
                    return new ResponseEntity("ERROR: Ciudad y/o ID del Tipo de juego olímpico no encontrado", HttpStatus.NOT_FOUND);
                }
            }
        } else {
           // daoPosts.create(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity("ERROR: Los campos de la URL no coinciden con los del BODY", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("sedeJJOO/postfully/{año}/{id_tipo_JJOO}")
    ResponseEntity postFull(@RequestBody SedeJJOOFullDtos sedeFullJJOO, @PathVariable Integer año, @PathVariable Integer id_tipo_JJOO) throws Exception {
        if(año.equals(sedeFullJJOO.getAño()) && id_tipo_JJOO.equals(sedeFullJJOO.getIdTipoJJOO())){
            if(sedeJJOOService.findById(año, id_tipo_JJOO).isPresent()){
                sedeJJOOService.findById(año, id_tipo_JJOO);
             //   daoPosts.create(HttpStatus.BAD_REQUEST.toString());
                return new ResponseEntity("ERROR: Este id ya existe, solo se puede modificar", HttpStatus.FOUND);
            } else {
                if(sedeJJOOService.save(sedeFullJJOO).isPresent()) {
                    SedeJJOOFullDtos toret = (SedeJJOOFullDtos) sedeJJOOService.save(sedeFullJJOO).get();
               //     daoPosts.create(toret, HttpStatus.OK.toString());
                    return new ResponseEntity(toret, HttpStatus.OK);
                } else {
               //     daoPosts.create(HttpStatus.NOT_FOUND.toString());
                    return new ResponseEntity("ERROR: Ciudad y/o ID del Tipo de juego olímpico no encontrado", HttpStatus.NOT_FOUND);
                }
            }
        } else {
          //  daoPosts.create(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity("ERROR: Los campos de la URL no coinciden con los del BODY", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("sedeJJOO/delete/{año}/{id_tipo_JJOO}")
    ResponseEntity deleteSedeJJOO(@PathVariable Integer año, @PathVariable Integer id_tipo_JJOO) {
        if(sedeJJOOService.findById(año, id_tipo_JJOO).isPresent()) {
            sedeJJOOService.deleteById(año, id_tipo_JJOO);
         //   daoDelete.create(año, id_tipo_JJOO, HttpStatus.OK.toString());
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
        //    daoDelete.create(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity("ERROR: Sede no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("ciudad/delete/{id}")
    ResponseEntity deleteCiudad(@PathVariable("id") Integer id) {
        if(ciudadService.findById(id).isPresent()) {
            ciudadService.deleteById(id);
        //    daoDelete.create(id, HttpStatus.OK.toString());
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
         //   daoDelete.create(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity("ERROR: Ciudad no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}