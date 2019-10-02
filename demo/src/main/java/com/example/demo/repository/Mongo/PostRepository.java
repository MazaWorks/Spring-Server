package com.example.demo.repository.Mongo;

import com.example.demo.entities.Mongo.POST;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<POST, ObjectId> {
}
