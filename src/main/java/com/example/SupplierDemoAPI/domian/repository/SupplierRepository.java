package com.example.SupplierDemoAPI.domian.repository;

import com.example.SupplierDemoAPI.domian.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE s.name = ?1")
    Optional<Supplier> findSupplierByName(String name);

    @Query("SELECT CASE WHEN COUNT(s)> 0 THEN true ELSE false END FROM Supplier s WHERE lower(s.name) LIKE lower(:name)")
    boolean supplierExistsByName(String name);
}
