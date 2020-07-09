package com.damo.example.async.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.damo.example.async.model.EmployeeAddresses;
import com.damo.example.async.model.EmployeeNames;
import com.damo.example.async.model.EmployeePhone;

@Service
public class AsyncService {

	private static Logger log = LoggerFactory.getLogger(AsyncService.class);
	private final RestTemplate restTemplate;
	
	 public AsyncService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Async
	public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException 
	{
		log.info("{}:  getEmployeeName Starts", Thread.currentThread().getName());
		EmployeeNames employeeNameData = restTemplate.getForObject("http://localhost:8080/names", EmployeeNames.class);
		log.info("employeeNameData, {}", employeeNameData);
		Thread.sleep(1000L);	//Intentional delay
		log.info("employeeNameData completed");
		return CompletableFuture.completedFuture(employeeNameData);
	}

	@Async
	public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException 
	{
		
		log.info("{}:  getEmployeeAddress Starts", Thread.currentThread().getName());
		EmployeeAddresses employeeAddressData = restTemplate.getForObject("http://localhost:8080/addresses", EmployeeAddresses.class);

		log.info("employeeAddressData, {}", employeeAddressData);
		Thread.sleep(1000L);	//Intentional delay
		log.info("employeeAddressData completed");
		return CompletableFuture.completedFuture(employeeAddressData);
	}

	@Async("damoTask")
	public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException 
	{
		log.info("{}:  getEmployeePhone Starts", Thread.currentThread().getName());
		EmployeePhone employeePhoneData = restTemplate.getForObject("http://localhost:8080/phones", EmployeePhone.class);

		log.info("employeePhoneData, {}", employeePhoneData);
		Thread.sleep(1000L);	//Intentional delay
		log.info("employeePhoneData completed");
		return CompletableFuture.completedFuture(employeePhoneData);
	}
}
