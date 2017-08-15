package com.gk.egen.weightracker.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
@Entity("metric")
public class Metric {

	@Id
	private String id;
	
    @Property("timestamp")
	private Timestamp timeStamp;
	
    @Property("value")
	private Long value;
	
	
	public Metric() {
		super();
		id=UUID.randomUUID().toString();
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
