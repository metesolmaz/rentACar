package com.metesolmaz.rentacar.business.rules;

import com.metesolmaz.rentacar.core.utilities.exceptions.BusinessException;
import com.metesolmaz.rentacar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {
        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException("Brand name already exists.");
        }
    }
}
