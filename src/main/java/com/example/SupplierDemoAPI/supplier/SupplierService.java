package com.example.SupplierDemoAPI.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }


    public List<Supplier> getSuppliers() {
        return this.supplierRepository.findAll();
    }

    public void addNewSupplier(Supplier supplier) {
        this.supplierRepository.addNewSupplier(supplier);
    }

    public void deleteSupplier(String companyName) {
        this.supplierRepository.deleteSupplier(companyName);
    }

    public void updateSupplier(
            String companyName,
            String name,
            String surname,
            String bankName,
            String bankHolderName,
            Long branchCode,
            Long accountNumber,
            String address,
            String product,
            String email,
            Long contactNumber,
            Long price,
            Long quantity) {

        supplierRepository.updateSupplier(
                companyName,
                name,
                surname,
                bankName,
                bankHolderName,
                branchCode,
                accountNumber,
                address,
                product,
                email,
                contactNumber,
                price,
                quantity
        );
    }

    public Supplier getSupplier(String companyName) {
        return supplierRepository.getSupplierByCompanyName(companyName);
    }

    public List<Supplier> search(String searchVariable) {
        return supplierRepository.search(searchVariable);
    }
}
