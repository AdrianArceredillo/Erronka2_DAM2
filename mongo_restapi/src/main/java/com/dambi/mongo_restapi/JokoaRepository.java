package com.dambi.mongo_restapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dambi.mongo_restapi.pojoak.Jokoa;

public interface JokoaRepository extends MongoRepository<Jokoa, ObjectId> {
    Jokoa findByTaldea(int taldea);
}
    