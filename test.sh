#!/bin/bash

echo "Running tests for the Generator project..."
cd generator
./mvnw test

cd ..

echo "Running tests for the Validator project..."
cd validator
./mvnw test

chmod +x test.sh