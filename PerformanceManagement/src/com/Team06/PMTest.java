import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PMTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		testInstance ti0 = new testInstance("ringo", 1, 5, 1000);
        testInstance ti1 = new testInstance("paul", 1, 4, 2000);
        testInstance ti2 = new testInstance("harrison", 1, 3, 1500);
        testInstance ti3 = new testInstance("lennon", 1, 2, 1000);

        
        ti0.start();
        ti1.start();
        ti2.start();
        ti3.start();
        try{
        	ti0.join();
        	ti1.join();
        	ti2.join();
        	ti3.join();
        }catch (Exception e)
        {
        	throw e;
        }
        
        
	}

    private static class testInstance extends Thread
    {
        private int internal;
        private int count;
        String key;
        int value;

        private testInstance(String key, int value, int count, int internal)
        {
            this.key = key;
            this.value = value;
            this.count = count;
            this.internal = internal;
        }

        @Override
        public void run()
        {
            while(count-- > 0)
            {
                try {
                    sleep(internal);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                PM.sendMsg(key, value);
                System.out.println(key + " : " + value + "  sent.");
            }

        }
    }

}
