package com.damo.rest.filter;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.damo.rest.model.SomeBean;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class SomeBeanFilter {

	public static MappingJacksonValue getFilter(Object bean, String... propertyArray) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(propertyArray);
		String filterName = SomeBean.class.getAnnotation(JsonFilter.class).value();
		FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filters);
		return mapping;
	}
}
