package rahulshettyacademy.data;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException {
		//read json to string
	//	Files.readString(Paths.get("path/to/your/file.json"));
       String jsoncontent = Files.readString(Paths.get(System.getProperty(filePath))); 
      //string to Hashmap Jackson Databind
      ObjectMapper mapper = new ObjectMapper();
      List <HashMap<String, String>> data= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){
	});
	return data;	
	}

}
