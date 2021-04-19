package com.example.SupplierDemoAPI.domian.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "surname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String surname;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "supplier",
            optional = false
    )
    private SupplierBankDetails bankDetails;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "supplier",
            optional = false
    )
    private SupplierContactDetails contactDetails;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "supplier",
            optional = false
    )
    private SupplierCompanyDetails companyDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
