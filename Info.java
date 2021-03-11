package projects;

import org.json.simple.JSONObject;

public class Info {
	

	String title="test1";
	String description=null;
	String version="1.0";

	public Object info() {
		
		JSONObject infojson=new JSONObject();
		infojson.put("title", title);
		infojson.put("description", description);
		infojson.put("version", version);
		return infojson;
}
}
