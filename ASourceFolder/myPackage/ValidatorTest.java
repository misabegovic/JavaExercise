package myPackage;
import static org.junit.Assert.*;


import org.junit.Test;


public class ValidatorTest {

	@Test
	public void testInitialization() {
		Validator a = new Validator();
		assertEquals("class myPackage.Validator", a.getClass().toString());
	}
	
	@Test
	public void testInvalidAddingToList() {
		Validator a = new Validator();
		a.validateString("abc");
		assertEquals("[]", a.getList().toString());
	}
	
	@Test
	public void testValidAddingToList() {
		Validator a = new Validator();
		a.validateString("www.google.com");
		assertEquals("[www.google.com]", a.getList().toString());
	}

}
