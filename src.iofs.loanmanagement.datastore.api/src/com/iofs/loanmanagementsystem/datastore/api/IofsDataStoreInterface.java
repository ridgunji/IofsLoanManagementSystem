package com.iofs.loanmanagementsystem.datastore.api;

import com.google.gson.JsonObject;

/**
 * This interface provides the API for the Data Store <br>
 * 
 * This interface provides the API for the Data Store defining <br> 
 * operations to the store data into the respective database <br>
 * Creation <br>
 * Reading / Retrieving <br>
 * Updation <br>
 * Deletion <br>
 * 
 * 
 * @author admin <br>
 * 
 */
public interface IofsDataStoreInterface {
	/** 
	 * This method in the interface is used to create a new record. 
	 * @param jsonObject Object containing the details of the record to be 
	 * created. <br>
	 * @return Object iofsResponse which contains the status of the request
	 * 			as well as the result set of the request
	 * @throws Exception Exception
	 */
	IofsResponse createRecord(JsonObject jsonObject) throws Exception;
	
	IofsResponse getRecord(String id) throws Exception;
	
	IofsResponse getRecords() throws Exception;
	
	IofsResponse putRecord( 
					String id, 
					JsonObject jsonObject) throws Exception;

	IofsResponse deleteRecord(String id) throws Exception;	
}
