package com.gk.egen.weighttracker.service;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
@Service("morphiaService")
public class MorphiaService {
	
	private Morphia morphia;
	private Datastore datastore;
	private MongoClient mongoClient = new MongoClient("127.0.0.1:27017");
	
	public MorphiaService(){
		this.morphia = new Morphia(); 
		String databaseName = "foobar_academy";
		this.datastore = morphia.createDatastore(mongoClient, databaseName);
	}
	
	public Morphia getMorphia() {
		return morphia;
	}
 
	public void setMorphia(Morphia morphia) {
		this.morphia = morphia;
	}
 
	public Datastore getDatastore() {
		return datastore;
	}
 
	public void setDatastore(Datastore datastore) {
		this.datastore = datastore;
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
}
