package com.bingo.office.oppensocial.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BingoCardDTO {

    int[] numbersB = new int[5];
    int[] numbersI = new int[5];
    int[] numbersN = new int[5];
    int[] numbersG = new int[5];
    int[] numbersO = new int[5];
    private int code;
}
