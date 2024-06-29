package com.bingo.office.oppensocial.repositories;

import com.bingo.office.oppensocial.entities.BingoCard;
import com.bingo.office.oppensocial.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BingoCardRepository extends JpaRepository<BingoCard,String> {

    Optional<BingoCard> findByUser(User user);

}
