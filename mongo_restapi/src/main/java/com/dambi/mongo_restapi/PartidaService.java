package com.dambi.mongo_restapi;

import com.dambi.mongo_restapi.pojoak.Partida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class PartidaService {
    
    @Autowired
    private PartidaRepository partidaRepository;

    public ResponseEntity<Partida> updatePartidaByPartidaIdAndJokoa(Integer partidaId, String jokoa, Partida partida) {
        Partida partidaToUpdate = partidaRepository.findByPartidaIdAndJokoa(partidaId, jokoa);
        if (partidaToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        partidaToUpdate.setLangilea(partida.getLangilea());
        partidaToUpdate.setPuntuazioa(partida.getPuntuazioa());
        partidaToUpdate.setData(partida.getData());
        partidaToUpdate.setTaldea(partida.getTaldea());
        Partida updatedPartida = partidaRepository.save(partidaToUpdate);
        return ResponseEntity.ok(updatedPartida);
    }
}
