package com.damo.rest.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damo.rest.model.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("v1", "v2", "v3");
		return SomeBeanFilter.getFilter(someBean, "field1");
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {
		List<SomeBean> list = Arrays.asList(new SomeBean("v1", "v2", "v3"),
				new SomeBean("v4", "v5", "v6"),
				new SomeBean("v7", "v8", "v9"));
		
		return SomeBeanFilter.getFilter(list, "field2");
	}
}
