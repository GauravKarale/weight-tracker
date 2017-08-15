package com.gk.egen.weighttracker.repository;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gk.egen.weightracker.model.Alert;
@Repository("alertDAO")
public class AlertDAOImpl extends BasicDAO<Alert, Integer> implements AlertDAO{

	@Autowired
	Datastore ds;
	
	@Autowired 
    public AlertDAOImpl(Datastore ds) { 
        super(Alert.class, ds); 
    } 

}


