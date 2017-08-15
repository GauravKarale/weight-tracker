package com.gk.egen.weighttracker;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mongodb.MongoClient;

@SpringBootApplication
@ComponentScan("com.gk.egen.weighttracker.repository")
@ComponentScan("com.gk.egen.weighttracker.service")
@ComponentScan("com.gk.egen.weighttracker.contoller")
@ComponentScan("com.gk.egen.weightracker.model")
@ComponentScan("com.gk.egen.weightracker.rule")
@ComponentScan("com.gk.egen.weighttracker.util")
public class WeightTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeightTrackerApplication.class, args);
	}
	
	@Bean
	public Datastore getDatastore(){
		Morphia morphia=new Morphia();
		MongoClient mongoClient= new MongoClient("127.0.0.1:27017");
		String dbName="metricDb";
		return morphia.createDatastore(mongoClient, dbName);
	}
}
