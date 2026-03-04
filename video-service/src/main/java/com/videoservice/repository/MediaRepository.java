package com.videoservice.repository;

import com.videoservice.entity.MediaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MediaRepository extends MongoRepository<MediaEntity, String> {
}
