#!/bin/bash

password="ooshoh9U"
command_to_run="python3 -m pyftpdlib -w -p 11111 --username zd --password 123"
plink -ssh csse@477-06.csse.rose-hulman.edu -pw $password "$command_to_run"
