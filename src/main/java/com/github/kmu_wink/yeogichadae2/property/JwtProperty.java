package com.github.kmu_wink.yeogichadae2.property;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.jwt")
public class JwtProperty {

    @NotBlank
    private String key;

    @Min(1)
    private int accessTokenExpirationHours;
}
