package com.metesolmaz.rentacar.core.utilities.exceptions;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ValidationProblemDetails extends ProblemDetails{
    private Map<String, String> validationErrors;
}
