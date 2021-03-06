package com.damo.limits.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damo.limits.service.Configuration;
import com.damo.limits.service.bean.LimitConfiguration;

@RestController
@RequestMapping("limits")
public class LimitConfigurationController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
}
