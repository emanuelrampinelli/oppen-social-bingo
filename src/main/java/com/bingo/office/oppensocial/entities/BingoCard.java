package com.bingo.office.oppensocial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_BINGO_CARD")
public class BingoCard {

    @Id
    @Column(name = "ID_BINGO_CARD")
    private String id;

    @Column(name = "NUMBERS_B", nullable = false)
    private String numbersB;

    @Column(name = "NUMBERS_I", nullable = false)
    private String numbersI;

    @Column(name = "NUMBERS_N", nullable = false)
    private String numbersN;

    @Column(name = "NUMBERS_G", nullable = false)
    private String numbersG;

    @Column(name = "NUMBERS_O", nullable = false)
    private String numbersO;

    @OneToOne @JoinColumn(name = "FK_USER")
    private User user;
}
