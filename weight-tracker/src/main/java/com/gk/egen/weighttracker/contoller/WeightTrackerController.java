package com.gk.egen.weighttracker.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gk.egen.weightracker.model.Metric;
import com.gk.egen.weighttracker.service.MetricService;

@RestController("/weight-tracker")
public class WeightTrackerController {

	@Autowired
	MetricService metricService;
	
	@RequestMapping(value="/mock-data",method=RequestMethod.POST)
	public void creatMockData(@RequestBody Metric metric){
		metricService.createMtric(metric);
	}
}
