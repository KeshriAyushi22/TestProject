package co.ayu.helper;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class AppHelper {

	public static String connectPostMethod(String serverURL,String requestData,String contentType) throws IOException 
	{
		String responseData = "";

		 responseData = connect(serverURL, requestData, contentType);

		
		return responseData;
	}

	private static  String connect(String apiServiceUrl, String ReqParameters,String contentType) throws IOException{
		HttpURLConnection urlConnection = (HttpURLConnection) new URL(apiServiceUrl).openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
		urlConnection.setRequestProperty("content-type",contentType);
		// send request
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream()));
		br.write(ReqParameters);
		br.close();

		// get response
		String response ="";
		Scanner s = new Scanner(urlConnection.getInputStream());
		while (s.hasNextLine()) {
			response += s.nextLine();
		}
		s.close();
		return response;
	}
}
