package com.github.kmu_wink.yeogichadae2.common.property;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import reactor.util.annotation.Nullable;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.data.redis")
public class RedisProperty {

    @NotBlank
    private String host;

    @Min(1)
    @Max(65535)
    private int port;

    @Nullable
    private String password;
}
