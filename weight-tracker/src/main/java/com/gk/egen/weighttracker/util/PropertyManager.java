/**
 *
 */
package com.gk.egen.weighttracker.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Contains all the loaded properties from the system
 *
 * @author Gaurav Karale
 *
 */
@Component
@PropertySource(value="classpath:application.properties")
public class PropertyManager {
	
	@Value("${max.weight}")
	private Integer maxAcceptableWeight;

	/** Dynamic configuration for the minimum acceptable weight before creating an alert **/
	@Value("${min.weight}")
	private Integer minAcceptableWeight;
	
	/**
	 * Return the Maximum Acceptable Weight
	 *
	 * @return
	 */
	public Integer getMaxAcceptableWeight(){
		return maxAcceptableWeight;
	}

	/**
	 * Return the Minimum Acceptable Weight
	 *
	 * @return
	 */
	public Integer getMinAcceptableWeight(){
		return minAcceptableWeight;
	}
	
}
