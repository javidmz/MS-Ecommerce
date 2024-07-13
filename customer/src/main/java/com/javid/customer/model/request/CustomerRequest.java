package com.javid.customer.model.request;

import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {
    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 20, message = "Invalid First name: Must be of 3 - 20 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 20, message = "Invalid Last name: Must be of 3 - 20 characters")
    private String lastName;

    @Email(message = "Invalid email")
    private String email;
}
