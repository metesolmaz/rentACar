package com.metesolmaz.rentacar.business.concretes;
import com.metesolmaz.rentacar.business.abstracts.BrandService;
import com.metesolmaz.rentacar.business.requests.CreateBrandRequest;
import com.metesolmaz.rentacar.business.requests.UpdateBrandRequest;
import com.metesolmaz.rentacar.business.responses.GetAllBrandsResponse;
import com.metesolmaz.rentacar.business.responses.GetByIdBrandResponse;
import com.metesolmaz.rentacar.business.rules.BrandBusinessRules;
import com.metesolmaz.rentacar.core.utilities.mappers.ModelMapperService;
import com.metesolmaz.rentacar.dataAccess.abstracts.BrandRepository;
import com.metesolmaz.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service // bu sınıf bir business nesnesidir.
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand bulunamadı."));
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);//id olduğu için save kullandık id olmasa insert yapar.
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
