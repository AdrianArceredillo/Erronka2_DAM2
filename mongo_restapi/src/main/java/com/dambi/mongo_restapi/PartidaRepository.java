package com.dambi.mongo_restapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartidaRepository extends MongoRepository<Partida, ObjectId> {
}
    