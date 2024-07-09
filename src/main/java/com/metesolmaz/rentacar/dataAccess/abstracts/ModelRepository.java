package com.metesolmaz.rentacar.dataAccess.abstracts;

import com.metesolmaz.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
