# eVisit
Coding challenge for engineering candidates at eVisit

The challenge:

Imagine your team has developed a web service that receives requests from about 20 million unique IP addresses everyday.
You want to keep track of the IP addresses that are making the most requersts to your service each day. Your job is to
write a program that (1) tracks these IP addresses in memory (dont use a database), and (2) returns the 100 most common
IP addresses.

In the language of your choice, please implement these functions:

* request_handled(ip address)
    This function accepts a string containing an IP address like "145.87.2.109". This function will be called by the web service every time it handles a request. The calling code is outside the scope of this project. Since it is being called very often, this function needs to have a fast runtime.

* top100()
    This function should return the top 100 IP addresses by request count, with the highest traffic IP address first.
    This function also needs to be fast. Imagine it needs to provide a quick response (< 300 ms) to display on a
    dashboard, even with 20 million IP addresses. This is a very important requirement. Do not forget to satisfy this
    requirement.
* clean()
    Called as the start of each day, to forget about all IP addresses and tallies.
