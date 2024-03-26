package Chaitrali.imdbflow.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {

		// first reading file to string and that file we need to send as an argument
		String jsonContent = FileUtils.readFileToString(new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\Chaitrali\\imdbflow\\data\\Content.json"),
				StandardCharsets.UTF_8);

		// Now converting string to hashmap-need new dependency callled jackson databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
	}
}
