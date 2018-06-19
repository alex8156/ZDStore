package com.soling.store.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
//@PropertySource(value = "classpath:mongodb.properties")
public class MongoDBConf {

    @Bean
    public MongoClient mongo() throws  Exception {
        return new MongoClient("localhost",27017);

    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return  new MongoTemplate(mongo(),"soling");
    }



}
