#!/usr/bin/env python3
for _ in range(int(input())):
    n = int(input())
    ans = 0
    for i in range(1,n+1):
        for j in range(i+1, n+1):
            m = i*j
            for k in range(n, 0, -1):
