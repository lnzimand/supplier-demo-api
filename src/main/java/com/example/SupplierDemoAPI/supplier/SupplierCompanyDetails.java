package com.example.SupplierDemoAPI.supplier;

public class SupplierCompanyDetails {

    private String companyName;
    private String address;
    private String product;
    private Long price;
    private Long quantity;

    public SupplierCompanyDetails(String companyName, String address, String product, Long price, Long quantity) {
        this.companyName = companyName;
        this.address = address;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
