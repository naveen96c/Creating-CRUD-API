package projects;

	import java.util.ArrayList;

	import org.json.simple.JSONObject;

	public class Mainjson {
		
		
			Apidefinition ref=new Apidefinition();
			
			Object apiDefinition=ref.json();
		    String apiName="Test";
			String apiVersion="1.0";
			String maturityState="beta";
			String apiGroups=null;
			ArrayList<String> al=new ArrayList<String>();
			public  String main() {
			JSONObject json1=new JSONObject();
			json1.put("apiDefinition", apiDefinition);
			json1.put("apiName",apiName);
			json1.put("apiVersion",apiVersion);
			json1.put("maturityState",maturityState);
			json1.put("apiGroups",apiGroups);
			json1.put("apiDocuments", al);
			String payload=json1.toString();
			return payload;
			//System.out.println(ref);
			//System.out.println(payload);
			
		}
			
}

