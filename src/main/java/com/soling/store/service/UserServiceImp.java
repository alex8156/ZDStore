package com.soling.store.service;

import com.soling.store.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImp implements UserService {



    public <T> List<T> findAll(Class<T> entityClass) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mongoDB.xml");
        MongoTemplate mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
        return mongoTemplate.findAll(entityClass);

    }


    public <T> void insert(Class<T> entityClass,T t) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mongoDB.xml");
        MongoTemplate mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
        mongoTemplate.insert(entityClass).one(t);
    }
}
