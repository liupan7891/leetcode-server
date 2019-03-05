package cn.util;

import com.google.gson.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Date;

public class JsonUtil {
	private static final Log log = LogFactory.getLog(JsonUtil.class);
	
	public static Object parseJson(String json, Class clazz) {
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
	        	.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

	            public Date deserialize(final JsonElement json, final Type typeOfT,
	                    JsonDeserializationContext context) throws JsonParseException {

					return DateUtils.parseDate(json.getAsString());
				}
	        })
	        .create();
		return gson.fromJson(json, clazz);
	}

	public static Object parseJson(String json, Type typeOfT) {
		Gson gson = new GsonBuilder()
	        .setPrettyPrinting()
	        .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

	            public Date deserialize(final JsonElement json, final Type typeOfT,
	                    JsonDeserializationContext context) throws JsonParseException {
					return DateUtils.parseDate(json.getAsString());
	            }
	        })
	        .create();
		return gson.fromJson(json, typeOfT);
	}
	
	public static Object getJsonObjFromFile(String path) {

		JSONParser jsonParser = new JSONParser();
		URL resource = JsonUtil.class.getClassLoader().getResource(path);

		if (resource != null) {
			Object obj;

			try {
				obj = jsonParser.parse(new FileReader(resource.getPath()));
				
				return obj;

			} catch (FileNotFoundException e) {
				log.error("JsonUtil get json obj from file, file not found error: ", e);

			} catch (IOException e) {
				log.error("JsonUtil get json obj from file, io error: ", e);

			} catch (org.json.simple.parser.ParseException e) {
				log.error("JsonUtil get json obj from file, ParseException error: ", e);

			}

			return null;
		}

		return null;
	}
}