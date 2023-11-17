package com.restapi.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterRequest {

    @NotEmpty
    @UniqueElements
    @Size(min = 6, message = "Username should have at least 6 characters")
    private String username;

    @NotEmpty
    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;

    @NotEmpty
    @Size(min = 4, message = "name must be at least 4 characters")
    private String name;
}
