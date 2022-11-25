package com.densoft.cards.controller;

import com.densoft.cards.config.CardsConfigService;
import com.densoft.cards.model.Cards;
import com.densoft.cards.model.Customer;
import com.densoft.cards.model.Properties;
import com.densoft.cards.repository.CardsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private CardsConfigService cardsConfigService;

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestHeader("eazybank-correlation-id") String correlationId, @RequestBody Customer customer) {
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        if (cards != null) {
            return cards;
        } else {
            return null;
        }

    }

    @GetMapping("/cards/properties")
    public String getProperties() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardsConfigService.getMsg(), cardsConfigService.getBuildVersion(), cardsConfigService.getMailDetails(), cardsConfigService.getActiveBranches());
        return objectWriter.writeValueAsString(properties);
    }
}
