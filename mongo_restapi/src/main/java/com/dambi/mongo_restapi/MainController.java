package com.dambi.mongo_restapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dambi.mongo_restapi.pojoak.Balorazioa;
import com.dambi.mongo_restapi.pojoak.Jokoa;
import com.dambi.mongo_restapi.pojoak.Langilea;
import com.dambi.mongo_restapi.pojoak.Partida;

import java.util.ArrayList;
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

    @Autowired
    private JokoaRepository jokoaRepository;

    @GetMapping("/partidak")
    public List<Partida> getAllPartidas() {
        return partidaRepository.findAll();
    }

    @GetMapping("/partidak/{jokoa}")
    public List<Partida> getPartidas(@PathVariable String jokoa) {
        return partidaRepository.findByJokoaEquals(jokoa);
    }


    @GetMapping("/langileak")
    public List<Langilea> getAllLangileak() {
        return langileaRepository.findAll();
    }

    @GetMapping("/balorazioak")
    public List<Balorazioa> getAllBalorazioak() {
        return balorazioaRepository.findAll();
    }

    @GetMapping("/balorazioak/{jokoa}")
    public List<Balorazioa> getBalorazioaByTaldea(@PathVariable String jokoa) {
        return balorazioaRepository.findByJokoaEquals(jokoa);
    }

    @PostMapping("/balorazioaGehitu")
    public Balorazioa createBalorazioa(@RequestBody Balorazioa balorazioa) {
        balorazioaRepository.save(balorazioa);
        return balorazioa;
    }



    @GetMapping("/jokoak")
    public List<Jokoa> getAllJokoak() {
        return jokoaRepository.findAll();
    }

    @GetMapping("/jokoak/{taldea}")
    public Jokoa getJokoaByTaldea(@PathVariable int taldea) {
        return jokoaRepository.findByTaldea(taldea);
    }

    @PostMapping("/partidas")
    public Partida createPartida(@RequestBody Partida partida) {
        //partida.set_id(ObjectId.get());
        partidaRepository.save(partida);
        return partida;
    }

    @PutMapping("/partidas/{id}")
    public Partida updatePartida(@PathVariable ObjectId id, @RequestBody Partida
    partida) {
    //partida.set_id(id);
    partidaRepository.save(partida);
    return partida;
    }

    // @DeleteMapping("/partidas/{id}")
    // public void deletePartida(@PathVariable ObjectId id) {
    // repository.deleteById(id);
    // }
}
