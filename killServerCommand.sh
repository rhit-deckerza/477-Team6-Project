#!/bin/bash

# Fetch the PID of the pyftpdlib server process
PID=$(ps aux | grep "pyftpdlib" | grep -v "grep" | awk '{print $2}')

# If the PID is found, kill it
if [ ! -z "$PID" ]; then
    kill -9 $PID
    echo "Killed pyftpdlib server with PID $PID."
else
    echo "No pyftpdlib server found."
fi
