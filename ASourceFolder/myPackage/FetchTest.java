package myPackage;
import static org.junit.Assert.*;


import org.junit.Test;


public class FetchTest {

	@Test
	public void testInitialization() {
		Fetch a = new Fetch();
		assertEquals("class myPackage.Fetch", a.getClass().toString());
	}
	
	@Test
	public void testGetList() {
		Fetch a = new Fetch();
		assertEquals("[]", a.getBase64List().toString());
	}
	
	@Test(expected = Exception.class)
	public void testFetch() throws Exception {
		Fetch a = new Fetch();
		a.fetchData("invalidLink");
	}
}
