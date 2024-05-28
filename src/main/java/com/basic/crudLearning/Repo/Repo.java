package com.basic.crudLearning.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.basic.crudLearning.model.bookModel;

public interface Repo extends MongoRepository<bookModel,String> {

} 
