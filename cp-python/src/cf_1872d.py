#!/usr/bin/env python3
from math import gcd

def s(l,r):
    return (l+r)*(r-l+1)/2 if l <= r else 0

def lcm(a, b):
    return a * b // gcd(a, b)

for _ in range(int(input())):
    n, x, y = map(int, input().split())
    z = n // lcm(x,y)
    r = n // x - z
    b = n // y - z
    print(int(s(n-r+1, n) - s(1, b)))
