package com.dambi.mongo_restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private PartidaRepository repository;

    @GetMapping("/partidas")
    public List<Partida> getAllPartidas() {
        return repository.findAll();
    }

    // @GetMapping("/partidas/{id}")
    // public Partida getPartidaById(@PathVariable ObjectId id) {
    //     return repository.findById(id).orElse(null);
    // }

    // @PostMapping("/partidas")
    // public Partida createPartida(@RequestBody Partida partida) {
    //     partida.set_id(ObjectId.get());
    //     repository.save(partida);
    //     return partida;
    // }

    // @PutMapping("/partidas/{id}")
    // public Partida updatePartida(@PathVariable ObjectId id, @RequestBody Partida partida) {
    //     partida.set_id(id);
    //     repository.save(partida);
    //     return partida;
    // }

    // @DeleteMapping("/partidas/{id}")
    // public void deletePartida(@PathVariable ObjectId id) {
    //     repository.deleteById(id);
    // }
}
