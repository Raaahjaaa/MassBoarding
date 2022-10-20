package com.example.demoWebsite.Entity;

public class DemoEntityPojo {
    private Object merchantProfile;

    public Object getMerchantProfile() {
        return merchantProfile;
    }

    @Override
    public String toString() {
        return "DemoEntityPojo{" +
                "merchantProfile=" + merchantProfile +
                '}';
    }
}
