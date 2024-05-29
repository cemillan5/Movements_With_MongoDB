package com.bancolombia.bank.controllers;

import com.bancolombia.bank.model.Movement;
import com.bancolombia.bank.services.MovementService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/movements")
public class MovementController {

    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping("/{cardId}")
    public Flux<Movement> getMovement(@PathVariable String cardId){
        return this.movementService.getMovementsByCard(cardId);
    }

    @PostMapping()
    public Flux<Movement> consolidatedMovements(@RequestBody Flux<String> cardIds){
        return this.movementService.consolidatedMovements(cardIds);
    }


}
