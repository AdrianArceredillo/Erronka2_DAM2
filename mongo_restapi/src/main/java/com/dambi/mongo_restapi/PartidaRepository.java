package com.dambi.mongo_restapi;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dambi.mongo_restapi.pojoak.Partida;

public interface PartidaRepository extends MongoRepository<Partida, ObjectId> {
    List<Partida> findByJokoaEquals(int jokoa);
}
    