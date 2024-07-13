package com.javid.customer.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressOverviewResponse {
    private Long id;
    private String street;
    private String city;
    private String postalCode;
}
