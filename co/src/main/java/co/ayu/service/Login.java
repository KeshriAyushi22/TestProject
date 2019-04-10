package co.ayu.service;

import java.util.List;

import co.ayu.dao.DaoImpl;
import co.ayu.to.ApiRequest;
import co.ayu.to.ApiResponse;
import co.ayu.to.StudentDetails;

public class Login {

	public static ApiResponse dologin(ApiRequest request) {
	
		ApiResponse response =new ApiResponse();
	    List<StudentDetails> list= DaoImpl.getStudentList(request);
		for(StudentDetails l:list) {
			if(!(l.getType().equals("google"))){
				if(l.getPassword().equals(request.getPassword())) {
                      response.setResCode("0000");
				response.setResStatus("passwordMatched");
				}else {
					response.setErrorCode("1111");
					response.setErrorStatus("passwordIncorrect");
				}
			}else if(l.getType().equals("google")) {
				 response.setResCode("0000");
				 response.setResStatus("LoginGranted");
			}
		}
		
		
		
		return response;
	}
}

