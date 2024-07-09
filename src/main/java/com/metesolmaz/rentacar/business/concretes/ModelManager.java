package com.metesolmaz.rentacar.business.concretes;

import com.metesolmaz.rentacar.business.abstracts.ModelService;
import com.metesolmaz.rentacar.business.requests.CreateModelRequest;
import com.metesolmaz.rentacar.business.responses.GetAllBrandsResponse;
import com.metesolmaz.rentacar.business.responses.GetAllModelsResponse;
import com.metesolmaz.rentacar.core.utilities.mappers.ModelMapperService;
import com.metesolmaz.rentacar.dataAccess.abstracts.ModelRepository;
import com.metesolmaz.rentacar.entities.concretes.Brand;
import com.metesolmaz.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponses= models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponses;
    }
    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
