# Kafka Project

This Spring Boot application demonstrates Kafka order and payment events.

## Run the application

Start Docker Desktop, then run these commands from the project directory:

```powershell
docker compose up -d
.\mvnw.cmd spring-boot:run
```

The application starts on `http://localhost:8080` and connects to Kafka on
`localhost:9092`.

## Publish events

In another PowerShell window, publish an order-created event:

```powershell
Invoke-RestMethod -Method Post -Uri 'http://localhost:8080/orders/created?message=Order-123'
```

Publish a payment-created event:

```powershell
Invoke-RestMethod -Method Post -Uri 'http://localhost:8080/payments/created?message=Payment-456'
```

Order events go to the `order-created` topic and are logged by the Order Service
consumer group. Payment events go to the `payment-created` topic and are logged
by the Payment Service consumer group. Kafka topics are created by the broker
when first used.

The Order and Payment producer/consumer components run in the same Spring Boot
application for this demo; they can be split into independently deployed
services later.

The original `POST /send?message=...` endpoint remains available and continues
to use the `my-first-topic` topic.

Stop the application with **Ctrl+C**, then stop Kafka with:

```powershell
docker compose down
```