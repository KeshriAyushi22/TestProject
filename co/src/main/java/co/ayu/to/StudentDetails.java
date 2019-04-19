package co.ayu.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDetails {
	@JsonProperty("SNo")
	private int SNo;
	@JsonProperty("name")
	private String studentName;
	@JsonProperty("college")
	private String collegeNmae;
	@JsonProperty("mob")
	private String studentPhone;
	@JsonProperty("email")
	private String emailID;
	@JsonProperty("collegeID")
	private String collegeID;
	@JsonProperty("DOB")
	private String dob;
	@JsonProperty("androidId")
	private String androidId;
	@JsonProperty("registerToken")
	private String registerToken;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("pass")
	private String password;
	@JsonProperty("type")
	private String type;
	@JsonProperty("photo")
	private String photo;

	@JsonProperty("status")
	private String status;


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCollegeNmae() {
		return collegeNmae;
	}
	public void setCollegeNmae(String collegeNmae) {
		this.collegeNmae = collegeNmae;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getCollegeID() {
		return collegeID;
	}
	public void setCollegeID(String collegeID) {
		this.collegeID = collegeID;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getSNo() {
		return SNo;
	}
	public void setSNo(int sNo) {
		SNo = sNo;
	}
	@Override
	public String toString() {
		return "StudentDetails [studentName=" + studentName + ", collegeNmae=" + collegeNmae + ", studentPhone="
				+ studentPhone + ", emailID=" + emailID + ", collegeID=" + collegeID + ", dob=" + dob + ", androidId="
				+ androidId + ", registerToken=" + registerToken + ", gender=" + gender + ", password=" + password
				+ ", type=" + type + ", photo=" + photo + ", status=" + status + "]";
	}

}
