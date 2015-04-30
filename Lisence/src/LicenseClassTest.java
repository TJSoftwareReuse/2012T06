import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LicenseClassTest {

	private LisenceClass instance = null;
	
	@Before
	public void setUp() throws Exception {
		instance = new LisenceClass();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void testUseLisence() {
		for (int i=1;i<=10;i++)
			assertEquals(instance.useLisence(),true);
		instance = null;
	}
	

	@Test
	public void testUseLisence2() {
		for (int i=1;i<=10;i++)
			instance.useLisence();
		assertEquals(instance.useLisence(),false);
	}

}
