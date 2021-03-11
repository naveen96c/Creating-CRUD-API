package projects;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

import org.json.simple.JSONObject;



public class Activation {
	Mainjson ms=new Mainjson();
	String payloadnew=ms.main();
	  String apiId = "81660643-b7b1-4d8b-9ff9-305d486b40e2";
	  
	  String username = "Administrator";
		 String password = "manage";
	 
	 public void activateAPI (String apiId) throws IOException
	 { 
		
		 
		 URL url = new URL("http://localhost:5555/rest/apigateway/apis/"+apiId+"/activate") ;
		 HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		 httpCon.setDoOutput(true);
		 httpCon.setRequestMethod("PUT");
		 
		 String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));  //Java 8
		 httpCon.setRequestProperty("Authorization", "Basic "+encoded);
		 
		 
		 System.out.println(httpCon.getResponseCode());
		 System.out.println(httpCon.getResponseMessage());  
	 }
	 
	 public  void deactivateAPI (String apiId) throws IOException
	 { 
		 
		 String username = "Administrator";
		 String password = "manage";
		 URL url = new URL("http://localhost:5555/rest/apigateway/apis/"+apiId+"/deactivate") ;
		 HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		 httpCon.setDoOutput(true);
		 httpCon.setRequestMethod("PUT");
		 
		 //HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		 
		 
		 String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));  //Java 8
		 httpCon.setRequestProperty("Authorization", "Basic "+encoded);
		 
		 System.out.println(httpCon.getResponseCode());
		 System.out.println(httpCon.getResponseMessage()); 
	 }
	 
	 public  void deleteAPIs (String apiId) throws IOException
	 { 
		 
		 URL url = new URL("http://localhost:5555/rest/apigateway/apis/"+apiId) ;
		 HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		 String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));  //Java 8
		 httpCon.setRequestProperty("Authorization", "Basic "+encoded);
		 httpCon.setDoOutput(true);
		 httpCon.setRequestMethod("DELETE");
		 System.out.println(httpCon.getResponseCode());
		 System.out.println(httpCon.getResponseMessage()); 
	 }
	 public  void createAPIs(String payloadnew)throws IOException
	 {
	
	 URL url = new URL("http://localhost:5555/rest/apigateway/apis") ;
	 HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
	 String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));  //Java 8
	 httpCon.setRequestProperty("Authorization", "Basic "+encoded);
	 httpCon.setDoOutput(true);
	 httpCon.setDoInput(true);
     httpCon.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
     httpCon.setRequestProperty("Accept", "application/json");
	 httpCon.setRequestMethod("POST");
	 OutputStream os = httpCon.getOutputStream();
     os.write(payloadnew.getBytes("UTF-8"));
     os.close();
     System.out.println(payloadnew);
	 System.out.println(httpCon.getResponseCode());
	 System.out.println(httpCon.getResponseMessage()); 
	 }
	 public static void main(String[] args) throws IOException 
	 {
		
		 Activation ref=new Activation();
		  
		 Scanner scn=new Scanner(System.in);
		 System.out.println("press 1 for activateAPI");
		 System.out.println("press 2 for deactivateAPI");
		 System.out.println("press 3 for deleteAPI");
		 System.out.println("press 4 for createAPI");
		 System.out.println("press 5 for creating n number of APIs");
		 int val=scn.nextInt();
		// System.ouct.println("");
		 if(val==1)
		 {
			ref.activateAPI(ref.apiId);
		 }
		 else if (val==2)
		 {
			ref.deactivateAPI (ref.apiId);
		 }
		 else if (val==3)
		 {
			 ref.deleteAPIs(ref.apiId);
		 }
		 else if (val==4)
		 {
			 ref.createAPIs(ref.payloadnew);
		 }
		else if (val == 5)
		 {
			 Scanner scan = new  Scanner(System.in);
			 System.out.println("Enter the no: apis to be created");
			 int not = scan.nextInt();
			 for (int i =1; i<= not; i++)
			 {
				  
				 Apidefinition ref1=new Apidefinition();
					
					Object apiDefinition=ref1.json();
				    String apiName="Test";
					String apiVersion="1.0";
					String maturityState="beta";
					String apiGroups=null;
					ArrayList<String> al=new ArrayList<String>();
					 
					JSONObject json1=new JSONObject();
					json1.put("apiDefinition", apiDefinition);
					json1.put("apiName",apiName+i);
					json1.put("apiVersion",apiVersion);
					json1.put("maturityState",maturityState);
					json1.put("apiGroups",apiGroups);
					json1.put("apiDocuments", al);
					String payload=json1.toString();
					ref.createAPIs(payload);
				 
			 }
			 scan.close();
		 }
		 scn.close();
	 }
}
