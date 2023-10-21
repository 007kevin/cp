#!/usr/bin/env python3

for _ in range(int(input())):
    n,k=map(int,input().split())
    a=[int(x) for x in input().split()]
    s=set(a)
    l,r=0,n-1
    for i in range(1,k+1):
        if i not in s:
            print(0, end=" ")
        else:
            while(a[l]<i): l += 1
            while(a[r]<i): r -= 1
            print((r-l+1)*2, end=" ")
    print()
