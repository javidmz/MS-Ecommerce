package com.javid.notification.kafka.payment;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
