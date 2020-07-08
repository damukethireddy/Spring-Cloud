package com.damo.rest.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestramp;
	private String message;
	private String detail;

	public ExceptionResponse(Date timestramp, String message, String detail) {
		super();
		this.timestramp = timestramp;
		this.message = message;
		this.detail = detail;
	}

	public Date getTimestramp() {
		return timestramp;
	}

	public void setTimestramp(Date timestramp) {
		this.timestramp = timestramp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
