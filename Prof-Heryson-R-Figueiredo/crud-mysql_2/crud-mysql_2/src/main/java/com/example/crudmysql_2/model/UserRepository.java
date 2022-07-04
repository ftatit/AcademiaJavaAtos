package com.example.crudmysql_2.model;

import org.springframework.data.repository.CrudRepository;

//Interface auto implementada pelo Spring no Bean chamada de UserRepository
//CRUD - Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}
