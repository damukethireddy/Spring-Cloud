package com.damo.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damo.rest.versioning.Name;
import com.damo.rest.versioning.PersonV1;
import com.damo.rest.versioning.PersonV2;

@RestController
public class PersonaVersioningController {

	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Tom Man");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Tom", "Man"));
	}
	
	
	@GetMapping(value="/person/param", params = "version=1")
	public PersonV1 personParamV1() {
		return new PersonV1("Tom Man");
	}
	
	@GetMapping(value="/person/param", params = "version=2")
	public PersonV2 personParamV2() {
		return new PersonV2(new Name("Tom", "Man"));
	}
	
	@GetMapping(value="/person/header", headers = "X-API-VERSION=1")
	public PersonV1 personHeaderV1() {
		return new PersonV1("Tom Man");
	}

	@GetMapping(value="/person/header", headers = "X-API-VERSION=2")
	public PersonV2 personHeaderV2() {
		return new PersonV2(new Name("Tom", "Man"));
	}
	
	@GetMapping(value="/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 personProducesV1() {
		return new PersonV1("Tom Man");
	}

	@GetMapping(value="/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 personProducesV2() {
		return new PersonV2(new Name("Tom", "Man"));
	}
	
	
}
