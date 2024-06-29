package com.bingo.office.oppensocial.controllers;

import com.bingo.office.oppensocial.dtos.BingoCardDTO;
import com.bingo.office.oppensocial.dtos.BingoCardRequestDTO;
import com.bingo.office.oppensocial.dtos.BingoCardResponseDTO;
import com.bingo.office.oppensocial.dtos.UserResponseDTO;
import com.bingo.office.oppensocial.entities.BingoCard;
import com.bingo.office.oppensocial.entities.User;
import com.bingo.office.oppensocial.repositories.BingoCardRepository;
import com.bingo.office.oppensocial.repositories.UserRepository;
import com.bingo.office.oppensocial.utils.BingoCardUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/bingo-cards")
public class BingoCardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BingoCardRepository bingoCardRepository;
    @PostMapping
    public ResponseEntity<BingoCardResponseDTO> save(@RequestBody @Valid BingoCardRequestDTO bingoCardRequestDTO){

        try {
            int code = bingoCardRequestDTO.getCode();
            if (code >= 1 && code <= 999999) {
                User user = userRepository.findByCode(code).orElse(null);
                if (user == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                            new BingoCardResponseDTO("Usuário não encontrado.", null));
                }
                BingoCard bingoCard = new BingoCard();
                bingoCard.setId(UUID.randomUUID().toString());
                bingoCard.setNumbersB(Arrays.toString(bingoCardRequestDTO.getNumbersB()));
                bingoCard.setNumbersI(Arrays.toString(bingoCardRequestDTO.getNumbersI()));
                bingoCard.setNumbersN(Arrays.toString(bingoCardRequestDTO.getNumbersN()));
                bingoCard.setNumbersG(Arrays.toString(bingoCardRequestDTO.getNumbersG()));
                bingoCard.setNumbersO(Arrays.toString(bingoCardRequestDTO.getNumbersO()));
                bingoCard.setUser(user);

                bingoCard = bingoCardRepository.save(bingoCard);
                return ResponseEntity.status(HttpStatus.OK).body(
                        new BingoCardResponseDTO("Cartela salva.", bingoCard));

            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new BingoCardResponseDTO("Código inválido.", null));
            }
        } catch (Exception ex) {
            log.error(HttpStatus.INTERNAL_SERVER_ERROR + ":" + ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new BingoCardResponseDTO("Erro interno, tente novamente mais tarde.", null));
        }
    }

    @GetMapping("/{code}")
    public ResponseEntity<BingoCardResponseDTO> getByCode(@PathVariable("code") int code){

        try {
            if (code >= 1 && code <= 999999) {
                User user = userRepository.findByCode(code).orElse(null);
                if (user == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                            new BingoCardResponseDTO("Usuário não encontrado.", null));
                }
                BingoCard bingoCard = bingoCardRepository.findByUser(user).orElse(null);
                BingoCardDTO bingoCardDTO = new BingoCardDTO();
                assert bingoCard != null;
                bingoCardDTO.setNumbersB(BingoCardUtil.stringToIntArray(bingoCard.getNumbersB()));
                bingoCardDTO.setNumbersI(BingoCardUtil.stringToIntArray(bingoCard.getNumbersI()));
                bingoCardDTO.setNumbersN(BingoCardUtil.stringToIntArray(bingoCard.getNumbersN()));
                bingoCardDTO.setNumbersG(BingoCardUtil.stringToIntArray(bingoCard.getNumbersG()));
                bingoCardDTO.setNumbersO(BingoCardUtil.stringToIntArray(bingoCard.getNumbersO()));
                bingoCardDTO.setCode(user.getCode());

                return ResponseEntity.status(HttpStatus.OK).body(
                        new BingoCardResponseDTO("Sucesso ao carregar cartela.", bingoCardDTO));

            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new BingoCardResponseDTO("Código inválido.", null));
            }
        } catch (Exception ex) {
            log.error(HttpStatus.INTERNAL_SERVER_ERROR + ":" + ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new BingoCardResponseDTO("Erro interno, tente novamente mais tarde.", null));
        }
    }
}
