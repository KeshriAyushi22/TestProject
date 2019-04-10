package co.ayu.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Notify {
	

	@JsonProperty("message")
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Notify [message=" + message + "]";
	}


}
