package co.ayu.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	@JsonProperty("token")
	private	String token;
	@JsonProperty("data")
	private Data data;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Message [token=" + token + ", data=" + data + "]";
	}


}
