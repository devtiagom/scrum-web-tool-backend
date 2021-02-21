package com.github.devtiagom.scrumwebtool.domain.user.api.v1.controller.dtos.response;

import com.github.devtiagom.scrumwebtool.domain.user.entities.User;
import com.github.devtiagom.scrumwebtool.domain.user.entities.enumerator.UserProfile;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private String fullName;
    private String email;
    private LocalDate birthdate;

    @Setter(value = AccessLevel.NONE)
    @Getter(value = AccessLevel.NONE)
    private Set<Integer> profiles = new HashSet<>();

    private String avatar;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.birthdate = user.getBirthdate();
        this.profiles = user
                .getProfiles()
                .stream()
                .map(profile -> profile.getProfileCode())
                .collect(Collectors.toSet());
        this.avatar = user.getAvatar();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.deletedAt = user.getDeletedAt();
    }

    public Set<UserProfile> getProfiles() {
        return this.profiles
                .stream()
                .map(profileCode -> UserProfile.toEnum(profileCode))
                .collect(Collectors.toSet());
    }
}
