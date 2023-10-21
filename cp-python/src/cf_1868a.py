#!/usr/bin/env python3
for _ in range(int(input())):
    n,m=map(int,input().split())
    g=[[0]*m for _ in range(n)]
    mx = [0]*m
    for i in range(min(n,m)-1):
        for j in range(m):
            g[i][j] = (j+i+1)%m
    for i in range(n-1, min(n,m)-2, -1):
        for j in range(m):
            g[i][j] = (j+1)%m
    if n == 1:
        print(2)
    elif m == 1:
        print(0)
    else:
        print(min(n,m))
    for i in range(n):
        for j in range(m):
            print(g[i][j], end=" ")
        print()
