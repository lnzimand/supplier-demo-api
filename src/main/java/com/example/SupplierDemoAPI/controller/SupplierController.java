package com.example.SupplierDemoAPI.controller;

import com.example.SupplierDemoAPI.services.SupplierService;
import com.example.SupplierDemoAPI.domian.entity.Supplier;
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

    @GetMapping(path = "{companyId}")
    public Supplier getSupplier(@PathVariable("companyId") Long companyId) {
        return supplierService.getSupplier(companyId);
    }

    @PostMapping(path = "register")
    public void registerNewSupplier(@RequestBody Supplier supplier) {

        System.out.println(supplier.toString());
        supplierService.addNewSupplier(supplier);
    }

    @DeleteMapping(path = "delete/{companyId}")
    public void deleteSupplier(
            @PathVariable("companyId") Long companyId) {
        supplierService.deleteSupplier(companyId);
    }

    @PutMapping(path = "update/{companyId}")
    public void updateSupplier(
            @PathVariable("companyId") Long companyId,
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String bankName,
            @RequestParam(required = false) String bankHolderName,
            @RequestParam(required = false) Long branchCode,
            @RequestParam(required = false) Long accountNumber,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String product,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Long contactNumber,
            @RequestParam(required = false) Long price,
            @RequestParam(required = false) Long quantity) {
        supplierService.updateSupplier(
                companyId,
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
}
