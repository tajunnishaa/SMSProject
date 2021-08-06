package bulksms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class BulkSms {
	
	public static void sendSms(String message,String number)
	{
//		System.out.println(message);
//		System.out.println(number);
		try
		{
		String apiKey="hxiW3weXqIQjskOyHdRCZabr1zn8B42fLSp5cPTYEG9NAtolmMNVerd4mCQ5EBDg9oGpZjSYHzyMILtO";
		String sendId ="CHKSMS";
		
		//important step...
		message=URLEncoder.encode(message, "UTF-8");
		String language="english";
		
		String route="v3";
		
		
		String myUrl="https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
		
		//sending get request using java..
		
		URL url=new URL(myUrl);
		
		HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
		
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		System.out.println("Wait..............");
		
		
		int code=con.getResponseCode();
		
		System.out.println("Response code : "+code);
		
		StringBuffer response=new StringBuffer();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true)
		{
			String line=br.readLine();
			if(line==null)
			{
				break;
			}
			response.append(line);
		}
		
		System.out.println(response);
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Program started.....");
		
		
		BulkSms.sendSms("Greetings from Haris Info Tech  ..."+ new Date().toLocaleString(), "8778299558");
	}
}
