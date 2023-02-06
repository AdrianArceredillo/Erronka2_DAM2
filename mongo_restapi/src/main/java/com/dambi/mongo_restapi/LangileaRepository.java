package com.dambi.mongo_restapi;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LangileaRepository extends MongoRepository<Langilea, ObjectId> {
}
    