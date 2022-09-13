# micro-services 
Sample repo for microservices implementation based on spring cloud

1. Feign 
2. Api Gateway
3. Resilience4j
4. Eureka
5. Zipkin
6. Rabbitmq


# How to run the project

1. makes sure you have docker installed in your local machine.
2. executes docker-compose up 


# URLS
Currency Exchange Service

http://localhost:8000/currency-exchange/from/USD/to/INR

Currency Conversion Service

http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10

Eureka

http://localhost:8761/

Zipkin

http://localhost:9411/

API GATEWAY

http://localhost:8765/currency-exchange/from/USD/to/INR

http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10

http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10

http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10


