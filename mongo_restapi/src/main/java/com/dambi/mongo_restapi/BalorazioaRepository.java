package com.dambi.mongo_restapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dambi.mongo_restapi.pojoak.Balorazioa;


public interface BalorazioaRepository extends MongoRepository<Balorazioa, ObjectId> {
}