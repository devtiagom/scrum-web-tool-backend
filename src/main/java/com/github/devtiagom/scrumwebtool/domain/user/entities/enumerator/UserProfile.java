package com.github.devtiagom.scrumwebtool.domain.user.entities.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserProfile {
    MASTER(1, "ROLE_MASTER"),
    ADMIN(2, "ROLE_ADMIN"),
    USER(3, "ROLE_USER");

    private static final String INVALID_PROFILE_CODE = "Código Inválido: ";

    private Integer profileCode;
    private String profileDescription;

    public static UserProfile toEnum(Integer profileCode) {
        if (profileCode == null) return null;

        for (UserProfile profile : UserProfile.values())
            if (profileCode.equals(profile.getProfileCode())) return profile;

        throw new IllegalArgumentException(UserProfile.INVALID_PROFILE_CODE + profileCode);
    }
}
