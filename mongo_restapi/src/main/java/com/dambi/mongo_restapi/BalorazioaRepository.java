package com.dambi.mongo_restapi;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dambi.mongo_restapi.pojoak.Balorazioa;


public interface BalorazioaRepository extends MongoRepository<Balorazioa, ObjectId> {
    List<Balorazioa> findByJokoaEquals(String jokoa);
}