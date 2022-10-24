package com.example.demoWebsite.Entity;

public class StatusReview {
    private String merchantProfile;
    private String locationAddress;
    private String financial;
    private String solution;
    private String bussinessLegalVerification;
    private String principalInformationSigner;

    public String getMerchantProfile() {
        return merchantProfile;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public String getFinancial() {
        return financial;
    }

    public String getSolution() {
        return solution;
    }

    public String getBussinessLegalVerification() {
        return bussinessLegalVerification;
    }

    public String getPrincipalInformationSigner() {
        return principalInformationSigner;
    }

    @Override
    public String toString() {
        return "StatusReview{" +
                "merchantProfile=" + merchantProfile +
                ", locationAddress='" + locationAddress + '\'' +
                ", financial='" + financial + '\'' +
                ", solution='" + solution + '\'' +
                ", bussinessLegalVerification='" + bussinessLegalVerification + '\'' +
                ", principalInformationSigner='" + principalInformationSigner + '\'' +
                '}';
    }
}
