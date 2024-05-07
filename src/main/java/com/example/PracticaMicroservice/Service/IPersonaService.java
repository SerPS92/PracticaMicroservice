package com.example.PracticaMicroservice.Service;

import com.example.PracticaMicroservice.Model.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    List<Persona> findAll();
    Optional<Persona> getPersonaById(int id);
    void deleteById(int id);
    void update(Persona persona);
    boolean add(Persona persona);
}
