package com.soling.store.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


public interface UserService {


   <T> List<T> findAll(Class<T> entityClass);


   <T> void insert(Class<T> entityClass,T t);


}
