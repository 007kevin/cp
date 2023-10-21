#!/usr/bin/env python3

mod = 998244353

def pow(b):
    if b == 0:
        return 1
    if b == 1:
        return 2
    if b%2==1:
        return pow(b-1)%mod
    return (pow(b/2) * pow(b/2))%mod


n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
m = int(input())
c = [int(x) for x in input().split()]
d = [int(x) for x in input().split()]
print(b)
print(d)
s = sum(b) + sum(d)
print(s)
print((pow(s) - 1)%mod)
