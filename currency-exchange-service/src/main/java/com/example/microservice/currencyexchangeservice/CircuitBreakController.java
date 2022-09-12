package com.example.microservice.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakController {

    private final static Logger logger = LoggerFactory.getLogger(CircuitBreakController.class);

    @GetMapping("/sample-api")

//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse") //    define the retry times in property file.
//    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "default") // limit how many calls can be alloed in a give time
    @Bulkhead(name = "default") // limit the concurrent calls
    public String sampleApi(){
        logger.info("Sample Api call receive");
        ResponseEntity<String> forEntity =
                new RestTemplate().getForEntity("http://localhost:8080/dummy-url", String.class);
        return forEntity.getBody();
    }

    /**
     * fallback method, you also can write different fallback for different expcetion. here's just a sample so catch Exception.
     * @param ex
     * @return
     */
    private String hardcodedResponse(Exception ex){
        return "Hard coded response";
    }
}
