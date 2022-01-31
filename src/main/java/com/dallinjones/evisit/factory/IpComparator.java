package com.dallinjones.evisit.factory;

import java.util.Comparator;
import java.util.Map;

public class IpComparator implements Comparator<String> {
    private final Map<String, Long> freqMap;
    
    // Assign the specified map
    IpComparator(Map<String, Long> tFreqMap) {
        this.freqMap = tFreqMap;
    }

    // Compare the values
    @Override
    public int compare(String k1, String k2) {

        // Compare by frequency
        int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

        // Compare key if frequency is equal
        int valueCompare = k1.compareTo(k2);

        // If frequency is equal, then just compare by value, otherwise -
        // compare by the frequency.
        if (freqCompare == 0)
            return valueCompare;
        else
            return freqCompare;
    }
}
