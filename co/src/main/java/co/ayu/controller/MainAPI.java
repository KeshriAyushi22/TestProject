package co.ayu.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

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
import com.mysql.cj.core.log.NullLogger;

import co.ayu.constants.TxnType;
import co.ayu.dao.DaoImpl;
import co.ayu.helper.AppHelper;
import co.ayu.helper.JsonHelper;
import co.ayu.helper.ValidationHelper;
import co.ayu.service.Login;
import co.ayu.service.Register;
import co.ayu.to.Adrino;
import co.ayu.to.ApiRequest;
import co.ayu.to.ApiResponse;
import co.ayu.to.Message;

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

	public void notification(String request) throws JsonParseException, JsonMappingException, IOException {

	    System.out.println(request);
	  ObjectMapper mapper = new ObjectMapper();
		Message req= mapper.readValue(request, Message.class);
	    
		
	String requestString=JsonHelper.parseObject2Json(req,Message.class);
		
		
	String url ="https://fcm.googleapis.com/fcm/send ";
	String response=AppHelper.connectPostMethod(url, requestString,"application/json");
		
		
		
		System.out.println("response"+response);
	

	}
	
	
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
public void uploadFile(InputStream inputStream ) throws IOException,FileNotFoundException{
		String fileLocation ="C:\\Users\\Ayushi\\Desktop\\images.txt";
		OutputStream out = new FileOutputStream(new File(fileLocation));
		int read=0;
		byte[] bytes= new byte[1024];
					while((read= inputStream.read(bytes)) != -1) {
						out.write(bytes,0,read);
				
			}
					out.flush();
					out.close();
		} 
		
		

	@POST
	@Path("/id")
	@Produces(MediaType.APPLICATION_JSON)

	public ApiResponse testId(String request) throws JsonParseException, JsonMappingException, IOException {

	  
	  ObjectMapper mapper = new ObjectMapper();
		ApiRequest req= mapper.readValue(request, ApiRequest.class);
		ApiResponse response = new ApiResponse();
		if(!IsNullorEmpty.isNullOrEmpty(req)) {
	        Adrino ad= new Adrino();
	       ad.setAdrinoId(req.getAdrinoId());
	         DaoImpl.save(ad);
		
	       
	        response.setResStatus("Success");
	        response.setResCode("0000");
	        }else{
	        	 response.setErrorStatus("DataInvalid");
	        	 response.setErrorCode("1111");
	        }
		return response;
		
	

	}
	



}

