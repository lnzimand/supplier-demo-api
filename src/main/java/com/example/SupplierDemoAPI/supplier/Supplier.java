package com.example.SupplierDemoAPI.supplier;

public class Supplier {

    private String name;
    private String surname;
    private SupplierBankDetails bankDetails;
    private SupplierContactDetails contactDetails;
    private SupplierCompanyDetails companyDetails;

    public Supplier(String name, String surname, String bankName, String bankHolderName, Long branchCode, Long accountNumber, String companyName, String address, String product, String email, Long contactNumber, Long price, Long quantity) {
        this.name = name;
        this.surname = surname;
        this.bankDetails = new SupplierBankDetails(bankName, bankHolderName, branchCode, accountNumber);
        this.contactDetails = new SupplierContactDetails(email, contactNumber);
        this.companyDetails = new SupplierCompanyDetails(companyName, address, product, price, quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public SupplierBankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(SupplierBankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    public SupplierContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(SupplierContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public SupplierCompanyDetails getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(SupplierCompanyDetails companyDetails) {
        this.companyDetails = companyDetails;
    }
}
