package com.github.kmu_wink.yeogichadae2.common.property;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.kakao")
public class KakaoProperty {

    @NotBlank
    private String clientId;

    @NotBlank
    private String redirectUrl;
}
