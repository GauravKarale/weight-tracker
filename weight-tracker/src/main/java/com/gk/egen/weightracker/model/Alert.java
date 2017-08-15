package com.gk.egen.weightracker.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
@Entity("alert")
public class Alert {

	@Id
	private String id;
	
    @Property("message")
	private String alertMsg;
    
    @Property("timestamp")
    private Timestamp timestamp;
    
    @Property("type")
    private String alertType;
    

	public Alert() {
		super();
		id=UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlertMsg() {
		return alertMsg;
	}

	public void setAlertMsg(String alertMsg) {
		this.alertMsg = alertMsg;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}
}
