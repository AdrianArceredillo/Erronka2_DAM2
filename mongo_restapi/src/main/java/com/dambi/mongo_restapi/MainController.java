package com.dambi.mongo_restapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private LangileaRepository langileaRepository;

    @Autowired
    private BalorazioaRepository balorazioaRepository;

    @GetMapping("/partidak")
    public List<Partida> getAllPartidas() {
        return partidaRepository.findAll();
    }

    @GetMapping("/langileak")
    public List<Langilea> getAllLangileak() {
        return langileaRepository.findAll();
    }

    @GetMapping("/balorazioak")
    public List<Balorazioa> getAllBalorazioak() {
        return balorazioaRepository.findAll();
    }

    @PostMapping("/partidas")
    public Partida createPartida(@RequestBody Partida partida) {
        partida.set_id(ObjectId.get());
        partidaRepository.save(partida);
        return partida;
    }

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
