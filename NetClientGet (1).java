import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class NetClientGet {

	public static void main(String[] args) {

	  try {
		  HttpURLConnection conn=null;
		  String baseurl="https://api.walletinsights.com";
		  Document doc = Jsoup.connect(baseurl).get();  
		  Elements links = doc.select("a[href]");  
		  int count=0;
		  for (Element link : links) {
		      String suburl=link.text();
		      URL url = new URL(baseurl+"/"+suburl+"/ping");
		      conn=(HttpURLConnection) url.openConnection();
		      conn.setRequestMethod("GET");
		      if (conn.getResponseCode() != 200) {
		    	 // System.out.println("failed for "+suburl);
		    	  //failed cases
				}
		      else {
		    	  
		      BufferedReader br = new BufferedReader(new InputStreamReader(
		  			(conn.getInputStream())));
		      String output;
		      while ((output = br.readLine()) != null ){
					if (output.equalsIgnoreCase("\"pong\""))
					{					 	
					 count++;
					}
				}		     
		      } //
		       
		  } // end of for  
		  System.out.println("The No. of services that respond with pong is :"+count);
	  } catch (MalformedURLException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}
}