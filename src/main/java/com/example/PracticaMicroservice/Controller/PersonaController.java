package com.example.PracticaMicroservice.Controller;

import com.example.PracticaMicroservice.Model.Persona;
import com.example.PracticaMicroservice.Service.IPersonaService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonaController {

    private final IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping(value = "persona", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> getPersonas(){
        List<Persona> personas = personaService.findAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("total", String.valueOf(personas.size()));
        return new ResponseEntity<List<Persona>>(personas, headers, HttpStatus.OK);
    }

    @GetMapping(value = "persona/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Persona>> getPersona(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(personaService.getPersonaById(id), HttpStatus.OK);
    }

    @PostMapping(value = "persona", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> añadir(@RequestBody Persona persona){
        if(personaService.add(persona)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "persona/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") int id){
        personaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "persona", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Persona persona){
        personaService.update(persona);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
