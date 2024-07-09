package com.metesolmaz.rentacar.webApi.controllers;
import com.metesolmaz.rentacar.business.abstracts.ModelService;
import com.metesolmaz.rentacar.business.requests.CreateModelRequest;
import com.metesolmaz.rentacar.business.responses.GetAllModelsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//annotation
@RequestMapping("/api/models")
public class ModelsController {
    private ModelService modelService;

    @Autowired
    public ModelsController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
