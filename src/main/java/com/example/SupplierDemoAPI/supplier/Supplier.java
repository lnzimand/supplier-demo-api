package com.example.SupplierDemoAPI.supplier;

public class Supplier {

    private String name;
    private String surname;
    private String companyName;
    private String address;
    private String product;
    private String email;
    private Long contactNumber;
    private Long price;
    private Long quantity;

    public Supplier(String name, String surname, String companyName, String address, String product, String email, Long contactNumber, Long price, Long quantity) {
        this.name = name;
        this.surname = surname;
        this.companyName = companyName;
        this.address = address;
        this.product = product;
        this.email = email;
        this.contactNumber = contactNumber;
        this.price = price;
        this.quantity = quantity;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", product='" + product + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber=" + contactNumber +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
