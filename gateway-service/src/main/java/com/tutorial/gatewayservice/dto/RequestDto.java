package com.tutorial.gatewayservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDto {
    private String uri;
    private String method;
}
