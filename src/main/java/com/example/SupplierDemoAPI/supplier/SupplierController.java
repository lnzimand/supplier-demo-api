package com.example.SupplierDemoAPI.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> getSuppliers() {
        return supplierService.getSuppliers();
    }

    @GetMapping(path = "{companyName}")
    public Supplier getSupplier(@PathVariable("companyName") String companyName) {
        return supplierService.getSupplier(companyName);
    }

    @GetMapping(path = "search/{searchName}")
    public List<Supplier> search(@PathVariable("searchName") String searchVariable) {
        return supplierService.search(searchVariable);
    }

    @PostMapping(path = "register")
    public void registerNewStudent(@RequestBody Supplier supplier) {
        supplierService.addNewSupplier(supplier);
    }

    @DeleteMapping(path = "{companyName}")
    public void deleteSupplier(
            @PathVariable("companyName") String companyName) {
        supplierService.deleteSupplier(companyName);
    }

    @PutMapping(path = "{companyName}")
    public void updateSupplier(
            @PathVariable("companyName") String companyName,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String product,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Long contactNumber,
            @RequestParam(required = false) Long price,
            @RequestParam(required = false) Long quantity) {
        supplierService.updateSupplier(
                companyName,
                name,
                surname,
                address,
                product,
                email,
                contactNumber,
                price,
                quantity
        );
    }
}
