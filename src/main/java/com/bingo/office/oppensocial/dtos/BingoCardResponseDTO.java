package com.bingo.office.oppensocial.dtos;

import com.bingo.office.oppensocial.entities.BingoCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BingoCardResponseDTO {

    private String message;
    private Object result;
}
