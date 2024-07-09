package com.metesolmaz.rentacar.dataAccess.abstracts;
import com.metesolmaz.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);
}
