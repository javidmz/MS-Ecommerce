package com.javid.customer.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOverviewResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}