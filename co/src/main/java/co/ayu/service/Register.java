package co.ayu.service;



import co.ayu.dao.DaoImpl;
import co.ayu.to.ApiRequest;
import co.ayu.to.ApiResponse;
import co.ayu.to.StudentDetails;
import co.ayu.util.IsNullorEmpty;

public class Register {

	public static ApiResponse doRegisteration(ApiRequest request) {
		ApiResponse regResponse=new ApiResponse();
			if(!IsNullorEmpty.isNullOrEmpty(request)) {
				StudentDetails stuReq = new StudentDetails();
				stuReq.setStudentName(request.getStudentName());
				stuReq.setCollegeNmae(request.getCollegeNmae());
				stuReq.setEmailID(request.getEmailID());
				stuReq.setType(request.getType());
				stuReq.setAndroidId(request.getAndroidId());
				stuReq.setCollegeID(request.getCollegeID());
				stuReq.setGender(request.getStudentPhone());
				stuReq.setRegisterToken(request.getRegisterToken());
				stuReq.setDob(request.getDob());
				stuReq.setStatus("10001");  //this status shows its confirmation is pending.
				DaoImpl.saveData(stuReq);
				regResponse.setResCode("0000");
				regResponse.setResStatus("Success");
				
			}else {
				regResponse.setErrorCode("1111");
				regResponse.setErrorStatus("Failure");
				
			}
		return regResponse;
	}

}
