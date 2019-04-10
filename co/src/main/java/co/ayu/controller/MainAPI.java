package co.ayu.controller;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import co.ayu.constants.TxnType;
import co.ayu.helper.AppHelper;
import co.ayu.helper.JsonHelper;
import co.ayu.helper.ValidationHelper;
import co.ayu.service.Login;
import co.ayu.service.Register;
import co.ayu.to.ApiRequest;
import co.ayu.to.ApiResponse;
import co.ayu.to.Notify;
import co.ayu.util.IsNullorEmpty;





@Path("txn")
public class MainAPI {



	@GET
	@Path("/getData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object test() {
		System.out.println("coming");

     /*String a="\"response:true\"";
     String error=null;
     JSONParser parser = new JSONParser();
     JSONObject json = (JSONObject) parser.parse(stringToParse);*/



		return "done";

	}

	//creating the apirequest object here which will come from device itself.




	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ApiResponse login(String request) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("coming to main api");
		String error=null;
		ObjectMapper mapper = new ObjectMapper();
		ApiRequest req= mapper.readValue(request, ApiRequest.class);
		ApiResponse response=new ApiResponse();
		//validation
		 error = ValidationHelper.validateRequest(req);
		if(IsNullorEmpty.isNullOrEmpty(error)) {
		response=Login.dologin(req);
		}else {
			response.setErrorCode("1111");
			response.setErrorStatus("validationError");
		}

		System.out.println("response"+response);
		return response;

	}

	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ApiResponse register(String request) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("coming to main api");
		String error=null;
		ObjectMapper mapper = new ObjectMapper();
		ApiRequest req= mapper.readValue(request, ApiRequest.class);
		ApiResponse response=new ApiResponse();
		//validation
		if(IsNullorEmpty.isNullOrEmpty(error)) {
			response=Register.doRegisteration(req);
			}else {
				response.setErrorCode("1111");
				response.setErrorStatus("validationError");
			}
		

		System.out.println("response"+response);
		return response;

	}
	
	@POST
	@Path("/notification")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void notification(String request) throws JsonParseException, JsonMappingException, IOException {

		
		ObjectMapper mapper = new ObjectMapper();
		Notify req= mapper.readValue(request, Notify.class);
		
	String requestString=JsonHelper.parseObject2Json(req,Notify.class);
		
		
		String url ="https://fcm.googleapis.com/fcm/send ";
	String response=AppHelper.connectPostMethod(url, requestString,"application/json");
		
		
		
		System.out.println("response"+response);
	

	}
	
	



}
