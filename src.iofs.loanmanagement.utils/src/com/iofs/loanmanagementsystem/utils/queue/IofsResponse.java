package com.iofs.loanmanagementsystem.utils.queue;

import java.util.List;

import com.google.gson.JsonObject;

public class IofsResponse {
	/**
	 * Status of the Request. The value contained here in is typically an HTTP
	 * response status such as 200, 201, 404, 400, etc.
	 */
	int status;
	
	/**
	 * Type field used for future implementations
	 */
	String type;
	
	/**
	 * Error field indicating the error description. This field is used to 
	 * represent the key which will be used for NLS translation
	 */
	String error;
	
	/**
	 * Reason field indicating the reason why the request failed 
	 */
	String reason;
	
	/**
	 * Return data list. The response of the request, if any will be returned 
	 * as a List object. 
	 */
	List<JsonObject> objectList;
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<JsonObject> getObjectList() {
		return objectList;
	}
	
	public void setObjectList(List<JsonObject> objectList) {
		this.objectList = objectList;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
}
