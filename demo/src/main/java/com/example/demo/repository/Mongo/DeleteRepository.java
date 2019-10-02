package com.example.demo.repository.Mongo;

import com.example.demo.entities.Mongo.DELETE;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeleteRepository extends MongoRepository<DELETE, ObjectId> {
}
