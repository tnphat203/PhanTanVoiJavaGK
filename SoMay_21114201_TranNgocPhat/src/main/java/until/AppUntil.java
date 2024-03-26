package until;

import java.util.Map;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.types.Node;

import com.google.gson.Gson;

public class AppUntil {
	private static final Gson GSON = new Gson();
	
	public static Driver getDriver() {
		return GraphDatabase.driver("neo4j://localhost:7687", AuthTokens.basic("neo4j", "12345678"));
	}
	
	public static <T> T toConvert(Node node, Class<T> clazz) {
        Map<String, Object> map = node.asMap();
        String json = GSON.toJson(map);
        return GSON.fromJson(json, clazz);
    }
	
}
