#!/usr/bin/env python3

def apply(n, a, b):
    for i in range(32):
        if b & 1<<i > 0:
            if a & 1<<i == 0:
                a = a ^ 1<<i if n%2 == 1 else a
            else:
                a = a ^ 1<<i if n%2 == 0 else a
    return a


for _ in range(int(input())):
    n,m=map(int,input().split())
    a = [int(x) for x in input().split()]
    b = [int(x) for x in input().split()]
    xor = 0
    for x in a:
        xor = xor ^ x
    mn, mx = xor,xor
    for x in b:
        mn = min(mn, apply(n, mn, x))
        mx = max(mx, apply(n, mx, x))
    print(f"{mn} {mx}")
