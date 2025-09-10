package com.manu.template.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MailChangeDTO {

    @NotBlank
    private String mail;

    @NotBlank
    private String password;
}