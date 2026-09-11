#!/bin/bash

find . -maxdepth 1 -type f \
    ! -name "*.sqc" \
    ! -name "*.sql" \
    ! -name "prevodjenje" \
    ! -name "ocisti.sh" \
    -delete