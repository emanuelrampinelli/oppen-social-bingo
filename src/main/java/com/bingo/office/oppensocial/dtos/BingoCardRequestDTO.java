package com.bingo.office.oppensocial.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BingoCardRequestDTO {

    @NotNull int[] numbersB = new int[5];
    @NotNull int[] numbersI = new int[5];
    @NotNull int[] numbersN = new int[5];
    @NotNull int[] numbersG = new int[5];
    @NotNull int[] numbersO = new int[5];
    @NotNull private int code;
}
