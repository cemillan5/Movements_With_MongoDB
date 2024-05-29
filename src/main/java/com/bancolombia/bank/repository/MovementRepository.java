package com.bancolombia.bank.repository;

import com.bancolombia.bank.model.Movement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovementRepository extends ReactiveMongoRepository<Movement, String> {

    Flux<Movement> findByCardId(String cardId);

}
