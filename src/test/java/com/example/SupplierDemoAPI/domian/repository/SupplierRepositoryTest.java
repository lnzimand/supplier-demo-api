package com.example.SupplierDemoAPI.domian.repository;

import com.example.SupplierDemoAPI.domian.entity.Supplier;
import com.example.SupplierDemoAPI.domian.entity.SupplierBankDetails;
import com.example.SupplierDemoAPI.domian.entity.SupplierCompanyDetails;
import com.example.SupplierDemoAPI.domian.entity.SupplierContactDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class SupplierRepositoryTest {

    @Autowired
    private SupplierRepository dummyRepository;

    private Supplier supplier;

    @BeforeEach
    void setUp() {
        String name = "Alex";
        SupplierBankDetails bankDetails = new SupplierBankDetails();
        bankDetails.setBankName("Capitec");
        bankDetails.setBankHolderName("Alex Doe");
        bankDetails.setAccountNumber(44564465645L);
        bankDetails.setBranchCode(14700L);

        SupplierContactDetails contactDetails = new SupplierContactDetails();
        contactDetails.setContactNumber(736645820L);
        contactDetails.setEmail("alex@example.com");

        SupplierCompanyDetails companyDetails = new SupplierCompanyDetails();
        companyDetails.setCompanyName("Alex's");
        companyDetails.setProduct("Grocery Parcels");
        companyDetails.setPrice(500L);
        companyDetails.setQuantity(40L);

        supplier = new Supplier();
        supplier.setName(name);
        supplier.setSurname("Doe");
        supplier.setBankDetails(bankDetails);
        supplier.setContactDetails(contactDetails);
        supplier.setCompanyDetails(companyDetails);
    }

    @Test
    void findSupplierByName() {

        // given
        dummyRepository.save(supplier);

        // when
        boolean expected = dummyRepository.supplierExistsByName(supplier.getName());

        // then
        assertThat(expected).isTrue();
    }
}