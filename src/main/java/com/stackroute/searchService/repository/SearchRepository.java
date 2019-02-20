package com.stackroute.searchService.repository;

import com.stackroute.searchService.model.SearchString;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends MongoRepository<SearchString, Integer> {
}
