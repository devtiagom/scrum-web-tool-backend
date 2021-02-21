package com.github.devtiagom.scrumwebtool.domain.user.api.v1.controller.dtos.request;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserRequestSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fullName;
    private String email;
    private String password;
}
