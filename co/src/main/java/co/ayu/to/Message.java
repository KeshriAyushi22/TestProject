package co.ayu.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	@JsonProperty("to")
	private	String to;
	@JsonProperty("data")
	private Data data;
	public String getTo() {
		return to;
	}
	public void setTo(String token) {
		this.to = token;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Message [token=" + to+ ", data=" + data + "]";
	}


}
