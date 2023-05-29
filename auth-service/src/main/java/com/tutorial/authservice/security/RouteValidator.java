package com.tutorial.authservice.security;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.tutorial.authservice.dto.RequestDto;

@Component
@ConfigurationProperties(prefix = "admin-paths")
public class RouteValidator {
    
    private List<RequestDto> paths;

    public List<RequestDto> getPaths() {
        return paths;
    }

    public void setPaths(List<RequestDto> paths) {
        this.paths = paths;
    }

    public boolean isAdminUri(RequestDto dto) {
        return paths.stream().anyMatch(p -> 
            Pattern.matches(p.getUri(), dto.getUri()) && p.getMethod().equals(dto.getMethod())
        );
    }

}
