package com.example.demo.repository;

import com.example.demo.model.Suscriptor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscriptorRepository extends MongoRepository<Suscriptor, String>{
}
