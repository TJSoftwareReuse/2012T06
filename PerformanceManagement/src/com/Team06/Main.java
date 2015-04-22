package com.Team06;

public class Main {

    public static void main(String[] args) {
	    SimpleTest();
    }

    // a simple test
    public static void SimpleTest()
    {
        testInstance ti0 = new testInstance("ringo", 1, 100, 1000);
        testInstance ti1 = new testInstance("paul", 1, 40, 2000);
        testInstance ti2 = new testInstance("harrison", 1, 60, 1500);
        testInstance ti3 = new testInstance("lennon", 1, 75, 1000);

        System.out.println("Test start.");
        ti0.start();
        ti1.start();
        ti2.start();
        ti3.start();
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
