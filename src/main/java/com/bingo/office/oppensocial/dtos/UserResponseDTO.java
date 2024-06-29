package com.bingo.office.oppensocial.dtos;

import com.bingo.office.oppensocial.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {

    private String message;
    private User result;
}
