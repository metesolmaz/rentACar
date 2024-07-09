package com.metesolmaz.rentacar.business.abstracts;
import com.metesolmaz.rentacar.business.requests.CreateModelRequest;
import com.metesolmaz.rentacar.business.responses.GetAllModelsResponse;
import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add (CreateModelRequest createModelRequest);
}
