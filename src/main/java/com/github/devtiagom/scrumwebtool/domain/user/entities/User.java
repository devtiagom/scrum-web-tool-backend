package com.github.devtiagom.scrumwebtool.domain.user.entities;

import com.github.devtiagom.scrumwebtool.domain.user.api.v1.controller.dtos.request.UserRequestSaveDTO;
import com.github.devtiagom.scrumwebtool.domain.user.entities.enumerator.UserProfile;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;

    private String fullName;
    private String email;
    private String password;
    private LocalDate birthdate;

    @Setter(value = AccessLevel.NONE)
    @Getter(value = AccessLevel.NONE)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profiles")
    private Set<Integer> profiles = new HashSet<>();

    private String avatar;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public User() {
        this.profiles.add(UserProfile.USER.getProfileCode());
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public User(UserRequestSaveDTO userRequestSaveDTO) {
        this();
        this.fullName = userRequestSaveDTO.getFullName();
        this.email = userRequestSaveDTO.getEmail();
        this.password = userRequestSaveDTO.getPassword();
    }

    public Set<UserProfile> getProfiles() {
        return profiles.stream().map(profile -> UserProfile.toEnum(profile)).collect(Collectors.toSet());
    }

    public void addProfile(UserProfile profile) {
        this.profiles.add(profile.getProfileCode());
    }
}
