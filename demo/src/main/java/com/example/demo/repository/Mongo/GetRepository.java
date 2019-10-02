package com.example.demo.repository.Mongo;

import com.example.demo.entities.Mongo.GET;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GetRepository extends MongoRepository<GET, ObjectId> {
}
