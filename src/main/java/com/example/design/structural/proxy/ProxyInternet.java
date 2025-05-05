package com.example.design.structural.proxy;

import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet {
    private RealInternet realInternet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = Arrays.asList("facebook.com", "youtube.com");
    }

    @Override
    public void connectTo(String site) throws Exception {
        if (bannedSites.contains(site.toLowerCase())) {
            throw new Exception("Access Denied to " + site);
        }
        realInternet.connectTo(site);
    }

}
