package com.bingo.office.oppensocial.controllers;

import com.bingo.office.oppensocial.dtos.UserResponseDTO;
import com.bingo.office.oppensocial.entities.User;
import com.bingo.office.oppensocial.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{code}")
    public ResponseEntity<UserResponseDTO> getByCode(@PathVariable("code") int code) {
        try {
            if (code >= 1 && code <= 999999) {
                User user = userRepository.findByCode(code).orElse(null);
                if (user == null) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                            new UserResponseDTO("Usuário não encontrado.", null));
                }
                return ResponseEntity.status(HttpStatus.OK).body(
                        new UserResponseDTO("Usuário encontrado.", user));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new UserResponseDTO("Código inválido.", null));
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new UserResponseDTO("Erro interno, tente novamente mais tarde.", null));
        }
    }
}
