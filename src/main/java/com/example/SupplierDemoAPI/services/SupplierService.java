package com.example.SupplierDemoAPI.services;

import com.example.SupplierDemoAPI.domian.entity.Supplier;
import com.example.SupplierDemoAPI.domian.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public void addNewSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long companyId) {
        if (!supplierRepository.existsById(companyId)) {
            throw new IllegalStateException(
                    "Supplier with id: " + companyId + " does not exists"
            );
        }
        supplierRepository.deleteById(companyId);
    }

    @Transactional
    public void updateSupplier(
            Long companyId,
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

        Supplier supplier = supplierRepository.findById(companyId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id: " + companyId + " does not exists"
                ));

        if (name != null && name.length() > 0 && !Objects.equals(supplier.getName(), name))
            supplier.setName(name);
        if (surname != null && surname.length() > 0 && !Objects.equals(supplier.getSurname(), surname))
            supplier.setSurname(surname);
        if (bankName != null && bankName.length() > 0 && !Objects.equals(supplier.getBankDetails().getBankName(), bankName))
            supplier.getBankDetails().setBankName(bankName);
        if (bankHolderName != null && bankHolderName.length() > 0 && !Objects.equals(supplier.getBankDetails().getBankHolderName(), bankHolderName))
            supplier.getBankDetails().setBankHolderName(bankHolderName);
        if (branchCode != null && !Objects.equals(supplier.getBankDetails().getBranchCode(), branchCode))
            supplier.getBankDetails().setBranchCode(branchCode);
        if (accountNumber != null && !Objects.equals(supplier.getBankDetails().getAccountNumber(), accountNumber))
            supplier.getBankDetails().setAccountNumber(accountNumber);
        if (companyName != null && companyName.length() > 0 && !Objects.equals(supplier.getCompanyDetails().getCompanyName(), companyName))
            supplier.getCompanyDetails().setCompanyName(companyName);
        if (address != null && address.length() > 0 && !Objects.equals(supplier.getCompanyDetails().getAddress(), address))
            supplier.getCompanyDetails().setAddress(address);
        if (product != null && product.length() > 0 && !Objects.equals(supplier.getCompanyDetails().getProduct(), product))
            supplier.getCompanyDetails().setProduct(product);
        if (email != null && email.length() > 0 && !Objects.equals(supplier.getContactDetails().getEmail(), email))
            supplier.getContactDetails().setEmail(email);
        if (contactNumber != null && !Objects.equals(supplier.getContactDetails().getContactNumber(), contactNumber))
            supplier.getContactDetails().setContactNumber(contactNumber);
        if (price != null && !Objects.equals(supplier.getCompanyDetails().getPrice(), price))
            supplier.getCompanyDetails().setPrice(price);
        if (quantity != null && !Objects.equals(supplier.getCompanyDetails().getQuantity(), quantity))
            supplier.getCompanyDetails().setQuantity(quantity);
    }

    public Supplier getSupplier(Long companyId) {
        return supplierRepository.findById(companyId)
                .orElseThrow(() -> new IllegalStateException(
                    "Supplier with an id: " + companyId + " does not exists"
                ));
    }
}
