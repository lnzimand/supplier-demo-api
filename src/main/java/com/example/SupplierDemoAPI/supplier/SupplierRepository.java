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
        Supplier supplierByCompanyName = getSupplierByCompanyName(supplier.getCompanyName());

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
                if (supplier.getCompanyName() != null)
                    if (supplier.getCompanyName().equalsIgnoreCase(companyName))
                        return supplier;
            }
        }
        return null;
    }

    public void deleteSupplier(String companyName) {
        if (!database.isEmpty() && supplierExistsByCompanyName(companyName)) {
            for (Supplier supplier :
                    database) {
                if (supplier.getCompanyName() != null)
                    if (supplier.getCompanyName().equalsIgnoreCase(companyName)) {
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
                if (supplier.getCompanyName() != null)
                    if (supplier.getCompanyName().equalsIgnoreCase(companyName))
                        return true;
            }
        }
        return false;
    }

    public void updateSupplier(String companyName, String name, String surname, String address, String product, String email, Long contactNumber, Long price, Long quantity) {
        if (!database.isEmpty() && supplierExistsByCompanyName(companyName)) {
            for (Supplier supplier :
                    database) {
                if (supplier.getCompanyName() != null)
                    if (supplier.getCompanyName().equalsIgnoreCase(companyName)) {
                        if (name != null && name.length() > 0 && !Objects.equals(supplier.getName(), name))
                            supplier.setName(name);
                        if (surname != null && surname.length() > 0 && !Objects.equals(supplier.getSurname(), surname))
                            supplier.setSurname(surname);
                        if (address != null && address.length() > 0 && !Objects.equals(supplier.getAddress(), address))
                            supplier.setAddress(address);
                        if (product != null && product.length() > 0 && !Objects.equals(supplier.getProduct(), product))
                            supplier.setProduct(product);
                        if (email != null && email.length() > 0 && !Objects.equals(supplier.getEmail(), email))
                            supplier.setEmail(email);
                        if (contactNumber != null && !Objects.equals(supplier.getContactNumber(), contactNumber))
                            supplier.setContactNumber(contactNumber);
                        if (price != null && !Objects.equals(supplier.getPrice(), price))
                            supplier.setPrice(price);
                        if (quantity != null && !Objects.equals(supplier.getQuantity(), quantity))
                            supplier.setQuantity(quantity);
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
                if (supplier.getCompanyName() != null)
                    if (supplier.getCompanyName().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getName() != null)
                    if (supplier.getName().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getSurname() != null)
                    if (supplier.getSurname().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getProduct() != null)
                    if (supplier.getProduct().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getAddress() != null)
                    if (supplier.getAddress().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
                if (supplier.getEmail() != null)
                    if (supplier.getEmail().equalsIgnoreCase(searchVariable))
                        foundResults.add(supplier);
            }
        }
        return foundResults;
    }
}
