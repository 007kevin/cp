#!/usr/bin/env python3

for _ in range(int(input())):
    m,k,a1,ak=map(int,input().split())
    f1 = m % k
    fk = m // k
    if f1 >= a1:
        f1 -= a1
    else:
        a1 -= f1
        f1 = 0
    fk -= a1//k
    fk = max(fk-ak, 0)
    print(f1 + fk)
