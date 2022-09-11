package com.example.microservice.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/currency-exchange")
public class CureencyExchangeControler {

    private Environment enviroment;

    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CureencyExchangeControler(Environment environment,
                                     CurrencyExchangeRepository currencyExchangeRepository) {
        this.enviroment = environment;
        this.currencyExchangeRepository = currencyExchangeRepository;
    }


    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to) {
        final Optional<CurrencyExchange> optionalCurrencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if (!optionalCurrencyExchange.isPresent()) {
            throw new RuntimeException("Currency exchange not found : from " + from + " to " + to);
        }

        final CurrencyExchange currencyExchange = optionalCurrencyExchange.get();
        //get current server port
        final String property = enviroment.getProperty("local.server.port");
        currencyExchange.setEnvironment(property);
        return currencyExchange;
    }


}
