package co.ayu.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.ayu.Constants.TxnType;
import co.ayu.service.Login;
import co.ayu.service.Register;
import co.ayu.to.ApiRequest;
import co.ayu.to.ApiResponse;


@Path("txn")
public class MainAPI {


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		System.out.println("coming");
		return "yes";
	}

	//creating the apirequest object here which will come from device itself.





	@POST
	@Path("/p")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getInfo(String req) {
		System.out.println("coming to main api");
		ApiRequest request= new ApiRequest();
		request.setName("sangita");
		request.setLoginID("S23");
		request.setRollno(2435421);
		request.setPhone("8604104636");
		request.setStudentAdd("kolkata");
		request.setTxnType("Registration");
		ApiResponse response=null;
		String txnType=request.getTxnType();
		switch(txnType) {
		case TxnType.login:
			response=Login.dologin(request);
			break;
		case TxnType.Register:
			response=Register.doRegister(request);
			break;
		}
		System.out.println("response"+response);
		return "finally";

	}


}