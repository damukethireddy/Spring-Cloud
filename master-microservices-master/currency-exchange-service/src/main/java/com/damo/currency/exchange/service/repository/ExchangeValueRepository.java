package com.damo.currency.exchange.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damo.currency.exchange.service.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

	ExchangeValue findByFromAndTo(String from, String to);
}
