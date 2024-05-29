package com.bancolombia.bank.services;

import com.bancolombia.bank.model.Movement;
import com.bancolombia.bank.repository.MovementRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MovementService {

    private final MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Flux<Movement> getMovementsByCard(String cardId){
        return movementRepository.findByCardId(cardId);
    }

    public Flux<Movement> consolidatedMovements(Flux<String> cardIds){
        return cardIds.flatMap(this::getMovementsByCard);
    }


}
