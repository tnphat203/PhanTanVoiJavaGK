package test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import dao.AlbumDAO;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)	
public class AlbumDaoTest {
	private AlbumDAO albumDao;

	@BeforeAll
	void setUp() {
		albumDao = new AlbumDAO();
	}
	@Test
	@Order(1)
	void testUpdate() {
		boolean flag = albumDao.updatePriceOfAlbum("24", 10000);
		assertEquals(true, flag);
	}
	@AfterAll
	void close() {
		albumDao.close();
		albumDao = null;
	}
		
	
	
}
