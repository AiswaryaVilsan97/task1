import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FetchClass {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://bajajfinsecapis.cmots.com/api/CompanyBackground/227");
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			InputStream ip = httpUrlConnection.getInputStream();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(ip));
			StringBuilder response = new StringBuilder();
			String responseSingle = null;
			int responseCode = httpUrlConnection.getResponseCode();
			if(responseCode !=200) {
				
			}else {
				while((responseSingle = br1.readLine())!=null) {
					response.append(responseSingle);
				}
				String str = response.toString();
				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse(str);  
				System.out.println(json);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
