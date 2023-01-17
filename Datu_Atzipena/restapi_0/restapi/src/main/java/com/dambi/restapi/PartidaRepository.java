package com.dambi.restapi;

import org.springframework.data.repository.CrudRepository;

import com.dambi.restapi.pojoak.Partida;


public interface PartidaRepository extends CrudRepository<Partida, Integer> {
    
}
