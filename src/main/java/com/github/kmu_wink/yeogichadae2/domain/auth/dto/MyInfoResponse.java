package com.github.kmu_wink.yeogichadae2.domain.auth.dto;

import com.github.kmu_wink.yeogichadae2.domain.user.entity.User;
import lombok.Builder;

@Builder
public record MyInfoResponse(
        User user
) {
}
