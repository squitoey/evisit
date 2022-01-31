package com.dallinjones.evisit.factory;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DefaultIpFactoryTest {

    private List<String> getItems(int count) {
        List<String> toReturn = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            toReturn.add("item " + (i % 150));
        }
        return toReturn;
    }

    @Test
    public void testClean() throws Exception {
        IpFactory factory = new DefaultIpFactory();
        List<String> items = getItems(50);

        for (String item: items) {
            factory.requestHandled(item);
        }

        assertEquals(factory.size(), 50);
        factory.clean();

        assertEquals(factory.size(), 0);
    }

    @Test
    public void testTop100() throws Exception {
        IpFactory factory = new DefaultIpFactory();
        List<String> items = getItems(2000000);

        long start = System.currentTimeMillis();
        for (String item: items) {
            factory.requestHandled(item);
        }

        long current = System.currentTimeMillis();
        System.out.println("records added in " + ( (current - start)) + " milli seconds");

        long start100 = System.currentTimeMillis();
        List<String> values = factory.top100();
        long current100 = System.currentTimeMillis();
        System.out.println("sorted in " + ( (current100 - start100) ) + " milli seconds");
        assertEquals(values.size(), 100);

    }

    @Test
    public void testRequestHandled() throws Exception {
        IpFactory factory = new DefaultIpFactory();
        List<String> items = getItems(2000);

        long start = System.currentTimeMillis();
        int i = 0;
        for (String item: items) {
            factory.requestHandled(item);

            if (i / 10000 == 0) {
                i = 0;
                long current = System.currentTimeMillis();

                System.out.println("10k at marker " + ( (current - start) / 1000) + " seconds");
            }
        }

        assertEquals(factory.size(), 150);
    }
}