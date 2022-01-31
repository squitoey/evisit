package com.dallinjones.evisit.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultIpFactory implements IpFactory {
    private Map<String, Long> requests = new HashMap<>();

    @Override
    public void requestHandled(String ipAddress) {
        Long count = requests.getOrDefault(ipAddress, 0l);
        count++;
        requests.put(ipAddress, count);
    }

    @Override
    public List<String> top100() {

        // Compare the map by value
        IpComparator comp = new IpComparator(requests);
        List<String> keys = new ArrayList<>(requests.keySet());
        Collections.sort(keys, comp);
        return keys.subList(0, 100);
//        return keys;
    }

    @Override
    public void clean() {
        requests.clear();
    }

    @Override
    public long size() {
        return requests.size();
    }
}
