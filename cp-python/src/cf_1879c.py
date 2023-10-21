#!/usr/bin/env python3

mod=998244353

class Data:
    def __init__(self, c, f):
        self.c=c
        self.f=f

def fact(n):
    a = 1;
    for i in range(1, n+1):
        a = (a * i) % mod
    return a

def solve(strn):
    l = []
    for c in strn:
        if (not l or l[-1].c != c):
            l.append(Data(c,1))
        else:
            l[-1].f += 1
    k = 0
    m = 1;
    for d in l:
        k += d.f - 11
        m = (m * d.f) % mod
    return str(k) + " " + str((m * fact(k)) % mod)

for _ in range(int(input())): print(solve(input()));
