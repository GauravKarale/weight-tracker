package com.gk.egen.weighttracker.repository;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gk.egen.weightracker.model.Metric;
@Repository("metricDAO")
public class MetricDAOImpl extends BasicDAO<Metric, Integer> implements MetricDAO{

	@Autowired
	Datastore ds;
	
	@Autowired 
    public MetricDAOImpl(Datastore ds) { 
        super(Metric.class, ds); 
    } 

}
