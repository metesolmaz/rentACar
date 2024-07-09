package com.metesolmaz.rentacar.business.abstracts;

import com.metesolmaz.rentacar.business.requests.CreateBrandRequest;
import com.metesolmaz.rentacar.business.requests.UpdateBrandRequest;
import com.metesolmaz.rentacar.business.responses.GetAllBrandsResponse;
import com.metesolmaz.rentacar.business.responses.GetByIdBrandResponse;
import com.metesolmaz.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
     List<GetAllBrandsResponse> getAll();
     GetByIdBrandResponse getById(int id);
     void add(CreateBrandRequest createBrandRequest);
     void update(UpdateBrandRequest updateBrandRequest);
     void delete(int id);

}
