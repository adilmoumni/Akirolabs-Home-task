#!/bin/bash

# Find the process id using a specific port and kill it
kill_process_on_port() {
    lsof -ti tcp:$1 | xargs kill
}

# Stop GeneratorService running on port 8082
kill_process_on_port 8082

# Stop ValidatorService running on port 8081
kill_process_on_port 8081

# If your React app runs on port 3000 and you also want to stop it:
# kill_process_on_port 3000

echo "All services stopped."
