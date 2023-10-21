#!/usr/bin/env python3

for _ in range(int(input())):
    n,m,d=map(int,input().split())
    s = [int(x) for x in input().split()]
    l,r = [0]*m, [0]*m
    last = 1
    for i in range(m):
        l[i]=last
        last=s[i]
    last = n+1
    for i in range(m-1,-1,-1):
        r[i]=last
        last=s[i]
    cook = 1 + (n-s[-1])//d
    for i in range(m):
        cook += (s[i]-l[i]-1)//d
        cook += 1
    can = False
    cnt = 0
    for i in range(m):
        if (r[i]-l[i]-1)//d < (s[i]-l[i]-1)//d + (r[i]-s[i]-1)//d + 1:
            can = True
            cnt += 1
    # for i in range(m):
    #     print(f"l={l[i]} s={s[i]} r={r[i]}")
    if can:
        print(f"{cook-1} {cnt}")
    else:
        print(f"{cook} {m}")
