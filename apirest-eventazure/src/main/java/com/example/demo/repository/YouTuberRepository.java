package com.example.demo.repository;

import com.example.demo.model.YouTuber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YouTuberRepository extends MongoRepository<YouTuber, String> {
}
