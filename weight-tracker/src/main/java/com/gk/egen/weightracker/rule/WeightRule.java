package com.gk.egen.weightracker.rule;

import java.sql.Timestamp;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Rule;
import org.easyrules.core.BasicRule;
import org.easyrules.spring.SpringRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gk.egen.weightracker.model.Alert;
import com.gk.egen.weighttracker.service.AlertService;
import com.gk.egen.weighttracker.util.PropertyManager;

@Component("weightRule")
@SpringRule
@Rule(name="Weight Rules",description=" rule will be triggered when the base weight is 10% below the base")
public class WeightRule extends BasicRule{

	@Autowired
	protected PropertyManager propertyManager;
	
	@Autowired
	protected AlertService alertService;


	protected boolean isAlertCreated;
	private Long baseweight;
	private Long currentValue;
	private boolean underWeightRule;
	private boolean overWeightRule;
	
	@Override
	@Action
	public boolean evaluate() {
		Integer maxWeight = propertyManager.getMaxAcceptableWeight();
		Integer minWeight = propertyManager.getMinAcceptableWeight();
		
		if(1- (float)baseweight / currentValue > (float)maxWeight/100){
			overWeightRule = true;
		}
		if(1- (float)currentValue/baseweight > (float)minWeight/100){
			underWeightRule = true;
		}
		if(overWeightRule)
			return overWeightRule;
		else if(underWeightRule)
			return underWeightRule;
		else
			return false;
	}
	@Override
	public void execute() throws Exception {
		super.execute();
		String alertMessage;
		Alert alert= new Alert();
		alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
		/**Rule1 is underweight **/
		if(underWeightRule){
			alert.setAlertType("UNDERWEIGHT");
			alertMessage = "The current weight " + currentValue + " is below the minimum expected: " + (baseweight - propertyManager.getMinAcceptableWeight()/100 * baseweight);
			alert.setAlertMsg(alertMessage);
		}

		/**Rule2 is overweight **/
		if(overWeightRule){
			alert.setAlertType("OVERWEIGHT");
			alertMessage = "The current weight " + currentValue + " is above the maximum expected: " + (baseweight + propertyManager.getMaxAcceptableWeight()/100 * baseweight);
			alert.setAlertMsg(alertMessage);
		}
		alertService.createAlert(alert);
		isAlertCreated=true;
	}
	public boolean isAlertCreated() {
		return isAlertCreated;
	}
	public void setAlertCreated(boolean isAlertCreated) {
		this.isAlertCreated = isAlertCreated;
	}
	public Long getBaseweight() {
		return baseweight;
	}
	public void setBaseweight(Long baseweight) {
		this.baseweight = baseweight;
	}
	public Long getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(Long currentValue) {
		this.currentValue = currentValue;
	}
	public boolean isUnderWeightRule() {
		return underWeightRule;
	}
	public void setUnderWeightRule(boolean underWeightRule) {
		this.underWeightRule = underWeightRule;
	}
	public boolean isOverWeightRule() {
		return overWeightRule;
	}
	public void setOverWeightRule(boolean overWeightRule) {
		this.overWeightRule = overWeightRule;
	}
}
