package com.company.stringmanipulator.pojo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> data = Collections.emptyList();
	private String message = "NO MATCH FOUND";

	public Response() {

	}

	public Response(final List<String> data) {
		if (data != null) {
			this.data = data;
			this.message = "MATCH FOUND";
		}
	}

	/**
	 * @return the data
	 */
	public List<String> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<String> data) {
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
