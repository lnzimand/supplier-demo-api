package com.example.SupplierDemoAPI.supplier;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class SupplierRepository {

    private final List<Supplier> database = new ArrayList<>();

    public List<Supplier> findAll() {
        return database;
    }

    public void addNewSupplier(Supplier supplier) {
        Supplier supplierByCompanyName = getSupplierByCompanyName(supplier.getCompanyDetails().getCompanyName());

        if (supplierByCompanyName != null) {
            throw new IllegalStateException(
                    "Company name already taken"
            );
        }
        database.add(supplier);
    }

    public Supplier getSupplierByCompanyName(String companyName) {
        if (!database.isEmpty()) {
            for (Supplier supplier:
                    database) {
                if (supplier.getCompanyDetails().getCompanyName() != null)
                    if (supplier.getCompanyDetails().getCompanyName().equalsIgnoreCase(companyName))
                        return supplier;
            }
        }
        return null;
    }

    public void deleteSupplier(String companyName) {
        if (!database.isEmpty() && supplierExistsByCompanyName(companyName)) {
            for (Supplier supplier :
                    database) {
                if (supplier.getCompanyDetails().getCompanyName() != null)
                    if (supplier.getCompanyDetails().getCompanyName().equalsIgnoreCase(companyName)) {
                        database.remove(supplier);
                        break;
                    }
            }
        } else throw new IllegalStateException(
                "Supplier with the company name : " + companyName + " does not exists"
        );
    }

    private boolean supplierExistsByCompanyName(String companyName) {
        if (!database.isEmpty()) {
            for (Supplier supplier :
                    database) {
                if (supplier.getCompanyDetails().getCompanyName() != null)
                    if (supplier.getCompanyDetails().getCompanyName().equalsIgnoreCase(companyName))
                        return true;
            }
        }
        return false;
    }

    public void updateSupplier(String companyName, String name, String surname, String bankName, String bankHolderName, Long branchCode, Long accountNumber, String address, String product, String email, Long contactNumber, Long price, Long quantity) {
        if (!database.isEmpty() && supplierExistsByCompanyName(companyName)) {
            for (Supplier supplier :
                    database) {
                if (supplier.getCompanyDetails().getCompanyName() != null)
                    if (supplier.getCompanyDetails().getCompanyName().equalsIgnoreCase(companyName)) {
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
            }
        } else throw new IllegalStateException(
                "Supplier with the company name : " + companyName + " does not exists"
        );
    }

    public List<Supplier> search(String searchVariable) {

        List<Supplier> foundResults = new ArrayList<>();

        if (!database.isEmpty()) {
            for (Supplier supplier :
                    database) {
                if (supplier.getCompanyDetails().getCompanyName() != null)
                    if (supplier.getCompanyDetails().getCompanyName().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getName() != null)
                    if (supplier.getName().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getSurname() != null)
                    if (supplier.getSurname().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getCompanyDetails().getProduct() != null)
                    if (supplier.getCompanyDetails().getProduct().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getCompanyDetails().getAddress() != null)
                    if (supplier.getCompanyDetails().getAddress().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getContactDetails().getEmail() != null)
                    if (supplier.getContactDetails().getEmail().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getBankDetails().getBankName() != null)
                    if (supplier.getBankDetails().getBankName().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getBankDetails().getBankHolderName() != null)
                    if (supplier.getBankDetails().getBankHolderName().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
            }
        }
        return foundResults;
    }
}
