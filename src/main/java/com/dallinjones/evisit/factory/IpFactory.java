package com.dallinjones.evisit.factory;

import java.util.List;

public interface IpFactory {

    /**
     * This function accepts a string containing an IP address like "145.87.2.109". This function will be called by the web service every time it handles a request. The calling code is outside the scope of this project. Since it is being called very often, this function needs to have a fast runtime.
     *
     * @param ipAddress
     */
    void requestHandled(String ipAddress);

    /**
     * This function should return the top 100 IP addresses by request count, with the highest traffic IP address first.
     * This function also needs to be fast. Imagine it needs to provide a quick response (< 300 ms) to display on a
     * dashboard, even with 20 million IP addresses. This is a very important requirement. Do not forget to satisfy this
     * requirement.
     *
     * @return
     */
    List<String> top100();

    /**
     * Called as the start of each day, to forget about all IP addresses and tallies.
     */
    void clean();

    /**
     * Returns the current size of the collection.
     * @return
     */
    long size();
}
