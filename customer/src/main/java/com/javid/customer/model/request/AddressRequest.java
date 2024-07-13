package com.javid.customer.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {
    @NotBlank(message = "Street name is required")
    @Size(min = 3, max = 100, message = "Street name should be between 3 - 100 characters")
    private String street;

    @NotBlank(message = "City name is required")
    @Size(min = 3, max = 100, message = "City name should be between 3 - 100 characters")
    private String city;

    @NotBlank(message = "Postal code is required")
    @Size(min = 3, max = 100, message = "Postal code should be between 3 - 100 characters")
    private String postalCode;

    @NotNull(message = "Customer detail is required.")
    private Long customer;
}
