#!/usr/bin/env python3

def mc2(m):
    return m*(m-1)//2

for _ in range(int(input())):
    n = int(input());
    l,r=2,1000000000000000000
    s = 0
    while(l <= r):
        m = (l+r)//2
        b = mc2(m)
        if b <= n:
            s = m
            l = m + 1
        else:
            r = m - 1
    print(s + (n-mc2(s)))
