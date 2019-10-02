package com.example.demo.dtos;

import com.example.demo.dtos.FullDtos.SedeJJOOFullDtos;

public class PostedDto {
    private SedeJJOODtos sede;
    private SedeJJOOFullDtos sedeFull;

    public PostedDto(SedeJJOODtos sede, SedeJJOOFullDtos sedeFull) {
        this.sede = sede;
        this.sedeFull = sedeFull;
    }

    public SedeJJOODtos getSede() {
        return sede;
    }

    public void setSede(SedeJJOODtos sede) {
        this.sede = sede;
    }

    public SedeJJOOFullDtos getSedeFull() {
        return sedeFull;
    }

    public void setSedeFull(SedeJJOOFullDtos sedeFull) {
        this.sedeFull = sedeFull;
    }
}
