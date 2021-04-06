package com.example.SupplierDemoAPI.supplier;

public class SupplierContactDetails {

    private String email;
    private Long contactNumber;

    public SupplierContactDetails(String email, Long contactNumber) {
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }
}
