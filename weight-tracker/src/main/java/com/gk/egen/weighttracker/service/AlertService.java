package com.gk.egen.weighttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gk.egen.weightracker.model.Alert;
import com.gk.egen.weighttracker.repository.AlertDAO;

@Service("alertService")
public class AlertService {

	@Autowired
	@Qualifier("alertDAO")
	AlertDAO alertDAO;
	
	public void createAlert(Alert alert){
		alertDAO.save(alert);
	}
	
	
}
