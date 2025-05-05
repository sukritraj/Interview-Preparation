package com.example.design.structural.proxy;

public  class RealInternet implements Internet{
    @Override
    public void connectTo(String site) throws Exception {
        System.out.println("Connecting to " + site);
    }
}
