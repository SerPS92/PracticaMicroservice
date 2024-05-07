package com.example.PracticaMicroservice.Service;

import com.example.PracticaMicroservice.Model.Persona;
import com.example.PracticaMicroservice.Repository.IPersonaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPersonaServiceImpl implements IPersonaService {

    private final IPersonaRepo personaRepo;

    public IPersonaServiceImpl(IPersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }

    @Override
    public List<Persona> findAll() {
        return personaRepo.findAll();
    }

    @Override
    public Optional<Persona> getPersonaById(int id) {
        return personaRepo.findById(id);
    }

    @Override
    public void deleteById(int id) {
        personaRepo.deleteById(id);
    }

    @Override
    public void update(Persona persona) {
        if(getPersonaById(persona.getId()).isPresent()){
            personaRepo.save(persona);
        }
    }

    @Override
    public boolean add(Persona persona) {
        personaRepo.save(persona);
        return true;
    }
}
