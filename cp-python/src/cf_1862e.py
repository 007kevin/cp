#!/usr/bin/env python3

import heapq

for _ in range(int(input())):
    n,m,d = map(int, input().split())
    a = [int(x) for x in input().split()]
    s = 0
    l = []
    ans = 0
    for i in range(n):
        if a[i] > 0:
            ans = max(ans, s + a[i] - d*(i+1))
            s += a[i]
            if len(l) < m-1:
                heapq.heappush(l,a[i])
            else:
                s -= heapq.heappushpop(l, a[i])
    print(ans)
