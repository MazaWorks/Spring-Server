package com.example.demo.services;

import com.example.demo.dtos.FullDtos.SedeJJOOFullDtos;
import com.example.demo.dtos.IdsDtos;
import com.example.demo.dtos.PostedDto;
import com.example.demo.dtos.SedeJJOODtos;
import com.example.demo.entities.Mongo.DELETE;
import com.example.demo.entities.Mongo.GET;
import com.example.demo.entities.Mongo.POST;
import com.example.demo.repository.Mongo.DeleteRepository;
import com.example.demo.repository.Mongo.GetRepository;
import com.example.demo.repository.Mongo.PostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class LogService {

    @Autowired
    private GetRepository getRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private DeleteRepository deleteRepository;

    public void getLog(List devuelto, String status) {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String time = localDate.format(myFormatObj);
        GET getLog = new GET(new ObjectId(), time, devuelto, status);
        getRepository.save(getLog);
    }

    public void postLog(SedeJJOODtos devuelto1, SedeJJOOFullDtos devuelto2,  String status) {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String time = localDate.format(myFormatObj);
        POST getLog;
        if(devuelto1 == null && devuelto2 == null){
            getLog = new POST(new ObjectId(), time, null, status);
        } else {
            PostedDto devuelto = new PostedDto(devuelto1, devuelto2);
            getLog = new POST(new ObjectId(), time, devuelto, status);
        }
        postRepository.save(getLog);
    }

    public void deleteLog(IdsDtos devuelto, String status) {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String time = localDate.format(myFormatObj);
        DELETE getLog = new DELETE(new ObjectId(), time, devuelto, status);
        deleteRepository.save(getLog);
    }
}
