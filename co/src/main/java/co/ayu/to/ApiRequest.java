package co.ayu.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class ApiRequest {

	@JsonProperty("stuName")
	private String studentName;
	@JsonProperty("colName")
	private String collegeNmae;
	@JsonProperty("mob")
	private String studentPhone;
	@JsonProperty("email")
	private String emailID;
	@JsonProperty("colID")
	private String collegeID;
	@JsonProperty("DOB")
	private String dob;
	@JsonProperty("androidId")
	private String androidId;
	@JsonProperty("regToken")
	private String registerToken;
	@JsonProperty("gen")
	private String gender;
	@JsonProperty("photo")
	private String photo;
	@JsonProperty("pass")
	private String password;
	@JsonProperty("type")
	private String type; //used in login if type=google then no pswd else pswd check.
	@JsonProperty("adrinoId")
	private String adrinoId; 
	
	
	
	
	public String getAdrinoId() {
		return adrinoId;
	}
	public void setAdrinoId(String adrinoId) {
		this.adrinoId = adrinoId;
	}
	public String getCollegeNmae() {
		return collegeNmae;
	}
	public void setCollegeNmae(String collegeNmae) {
		this.collegeNmae = collegeNmae;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAndroidId() {
		return androidId;
	}
	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}
	public String getRegisterToken() {
		return registerToken;
	}
	public void setRegisterToken(String registerToken) {
		this.registerToken = registerToken;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}public String getCollegeID() {
		return collegeID;
	}
	public void setCollegeID(String collegeID) {
		this.collegeID = collegeID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStudentID() {
		return collegeID;
	}
	public void setStudentID(String studentID) {
		this.collegeID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	@Override
	public String toString() {
		return "ApiRequest [studentName=" + studentName + ", collegeNmae=" + collegeNmae + ", studentPhone="
				+ studentPhone + ", emailID=" + emailID + ", collegeID=" + collegeID + ", dob=" + dob + ", androidId="
				+ androidId + ", registerToken=" + registerToken + ", gender=" + gender + ", photo=" + photo
				+ ", password=" + password + ", type=" + type + "]";
	}

}
