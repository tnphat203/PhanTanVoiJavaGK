package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;

import entity.Album;

import org.neo4j.driver.Result;
import org.neo4j.driver.Record;
import until.AppUntil;

public class AlbumDAO {
	private Driver driver;
	
	public AlbumDAO() {
		this.driver = AppUntil.getDriver();
	}
	
	 
	public void close() {
		driver.close();
	}
	
	public boolean updatePriceOfAlbum(String id, double newPrice) {
		String query = "MATCH (a:Album) WHERE a.id= $id SET a.price = $newPrice";
		Map<String, Object> map = Map.of("id", id, "newPrice", newPrice);
		try (Session session = driver.session()) {
			return session.executeWrite(tx -> {
				Result result = tx.run(query, map);
				return result.consume().counters().propertiesSet() > 0;
			});
		}
	}
	public List<Album> listAlbumByGenre(String genreName) {
		List<Album> ds = new ArrayList<Album>();
		String query = "MATCH (a:Album)-[r:BELONG_TO]->(g:Genre) WHERE toUpper(g.name) = toUpper($genreName) return a";
		Map<String, Object> map = Map.of("genreName", genreName);
		try (Session session = driver.session()) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, map);
				if (!result.hasNext())
					return null;
				while (result.hasNext()) {
					Record record = result.next();
					Node node = record.get("a").asNode();
					Album a = AppUntil.toConvert(node, Album.class);
					ds.add(a);
				}
				return ds;
			});
		}
	}

	public Map<String, Long> getNumberOfAlbumByGenre() {
		String query = "MATCH (a:Album)-[r:BELONG_TO]->(g:Genre) RETURN g.name as genreName, count(a) as count ORDER BY genreName";
		try (Session session = driver.session()) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);
				if (!result.hasNext())
					return null;
                Map<String, Long> map = new LinkedHashMap<>();
				while (result.hasNext()) {
					Record record = result.next();
					String genreName = record.get("genreName").asString();
					long count = record.get("count").asLong();
					map.put(genreName, count);
				}
				return map;
			});
		}
	}
}
