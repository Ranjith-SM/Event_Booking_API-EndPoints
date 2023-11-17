package com.restapi.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginRequest {

    @NotEmpty
    @Size(min = 6, message = "Username should have at least 6 characters")
    private String username;

    @NotEmpty
    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;
}
