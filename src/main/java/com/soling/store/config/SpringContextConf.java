package com.soling.store.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value="com.soling.store")
@Import({MongoDBConf.class})
public class SpringContextConf {
}
