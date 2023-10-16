#!/bin/bash

# Navigate to generator service and start it
cd generator
./mvnw spring-boot:run &
cd ..

# Wait for a few seconds to ensure the first service has time to start
sleep 10s

# Navigate to validator service and start it
cd validator
./mvnw spring-boot:run &
cd ..

# Wait for a few seconds to ensure the second service has time to start
sleep 10s

# Navigate to frontend and start it
cd frontend
PORT=8080 npm start &
