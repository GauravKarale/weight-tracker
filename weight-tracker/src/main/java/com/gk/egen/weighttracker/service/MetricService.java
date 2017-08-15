package com.gk.egen.weighttracker.service;
import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

import org.apache.log4j.Logger;
import org.easyrules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gk.egen.weightracker.model.Metric;
import com.gk.egen.weightracker.rule.WeightRule;
import com.gk.egen.weighttracker.repository.MetricDAO;

@Service("metricService")
public class MetricService {
	/** Static Logger **/
	private final Logger log = Logger.getLogger(MetricService.class.getName());
	
	
	@Autowired
	@Qualifier("metricDAO")
	private MetricDAO metrciDAO;

	@Autowired
	@Qualifier("weightRule")
	private WeightRule weightRule;
	
	private Long baseWeight;
	
	private int firstRequest=0;
	
	private boolean isValidWeight(Metric metric){
		
		RulesEngine rulesEngine = aNewRulesEngine().build();
		weightRule.setBaseweight(baseWeight);
		weightRule.setCurrentValue(metric.getValue());
		rulesEngine.registerRule(weightRule);
		rulesEngine.fireRules();

		return !weightRule.isAlertCreated();
	}
	
	public void createMtric(Metric metric){
		firstRequest++;
		if(firstRequest==1){
			baseWeight=metric.getValue();
		}
		
		if(!isValidWeight(metric)){
			log.warn("Metric  ID " + metric.getId() + " has an invalid weight " );
		}
		metrciDAO.save(metric);
	}
	
}
