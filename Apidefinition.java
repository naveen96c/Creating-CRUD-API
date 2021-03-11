package projects;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Apidefinition {
			Definitions def=new Definitions();
			Parameters para=new Parameters();
			Info ifo=new Info();
			Object definition=def.def();
			Object parameter=para.para();
			Object info=ifo.info();
			ArrayList<String> al=new ArrayList<String>();
			String host="localhost:5555";
			String basepath="/";
			//object definitions;
			//object parameters;
		
public Object json(){
	
		JSONObject subjson=new JSONObject();
		subjson.put("definitions",definition);
		subjson.put("parameters",parameter);
		subjson.put("info", info);
	    al.add("http");
	    subjson.put("schemes", al);
		subjson.put("host", host);
		subjson.put("basepath", basepath);
		
		return subjson;
		
		
}
}