package com.example.SupplierDemoAPI.services;

import com.example.SupplierDemoAPI.domian.entity.Supplier;
import com.example.SupplierDemoAPI.domian.entity.SupplierBankDetails;
import com.example.SupplierDemoAPI.domian.entity.SupplierCompanyDetails;
import com.example.SupplierDemoAPI.domian.entity.SupplierContactDetails;
import com.example.SupplierDemoAPI.domian.repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class SupplierServiceTest {

    @Mock
    private SupplierRepository supplierRepository;
    private SupplierService supplierService;
    private Supplier supplier;

    @BeforeEach
    void setUp() {
        openMocks(supplierRepository);
        supplierService = new SupplierService(supplierRepository);

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
    void getSuppliers() {
        // when
        supplierService.getSuppliers();
        // then
        verify(supplierRepository).findAll();
    }

    @Test
    void addNewSupplier() {
        // when
        supplierService.addNewSupplier(supplier);
        // then
        ArgumentCaptor<Supplier> supplierArgumentCaptor = ArgumentCaptor.forClass(Supplier.class);
        verify(supplierRepository).save(supplierArgumentCaptor.capture());
        Supplier capturedSupplier = supplierArgumentCaptor.getValue();
        assertThat(capturedSupplier).isEqualTo(supplier);
    }

    @Test
    @Disabled
    void updateSupplier() {

        // given
        supplierRepository.save(supplier);
        supplier = supplierRepository.findSupplierByName(supplier.getName())
                .orElseThrow(() -> new IllegalStateException(
                        "Supplier does not exists"
                ));
        // when
        supplier = spy(supplier);
        supplierService.updateSupplier(supplier.getId(),
                null,
                null,
                "tza",
                null,
                null,
                null,
                null,
                null,
                "mascopas",
                null,
                null,
                20L,
                null);
        verify(supplier, new NoSetterCalls()).setName("Name is ignored");

    }

    @Test
    @Disabled
    void getSupplier() {
        // when
        supplierService.getSupplier(supplier.getId());

        // then
        verify(supplierRepository).findById(supplier.getId());
    }

    @Test
    @Disabled
    void getSupplierByName() {
        // when
        supplierService.getSupplierByName(supplier.getName());

        // then
        verify(supplierRepository).findSupplierByName(supplier.getName());
    }

    @Test
    void deleteSupplier() {
        // when
        supplierRepository.save(supplier);
        verify(supplierRepository).save(supplier);
        supplier = supplierRepository.findSupplierByName("Alex")
                .orElseThrow(() -> new IllegalStateException(
                        "Supplier not found"
                ));
        supplierService.deleteSupplier(supplier.getId());

        // then
        verify(supplierRepository).deleteById(supplier.getId());
    }
}