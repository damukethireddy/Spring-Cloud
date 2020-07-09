package com.damo.example.async.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damo.example.async.model.EmployeeAddresses;
import com.damo.example.async.model.EmployeeNames;
import com.damo.example.async.model.EmployeePhone;
import com.damo.example.async.service.AsyncService;

@RestController
public class AsyncController {

	private static Logger log = LoggerFactory.getLogger(AsyncController.class);

	@Autowired
	private AsyncService service;

	@RequestMapping(value = "/testAsynch", method = RequestMethod.GET)
	public ResponseEntity<String> testAsynch() throws InterruptedException, ExecutionException 
	{
		log.info("testAsynch Start");

		CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress();
		CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName();
		CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();

		// Wait until they are all done
		CompletableFuture.allOf(employeeAddress, employeeName, employeePhone).join();
		
		log.info("EmployeeAddress--> " + employeeAddress.get());
		log.info("EmployeeName--> " + employeeName.get());
		log.info("EmployeePhone--> " + employeePhone.get());
		return ResponseEntity.ok("Success");
	}
}
