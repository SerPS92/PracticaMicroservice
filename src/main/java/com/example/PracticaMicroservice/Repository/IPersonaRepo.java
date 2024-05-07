package com.example.PracticaMicroservice.Repository;

import com.example.PracticaMicroservice.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

    
}
