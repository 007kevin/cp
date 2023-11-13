#!/usr/bin/env python3
import heapq

for _ in range(int(input())):
    n = int(input())
    a = [int(x) for x in input().split()]
    b = [int(x) for x in input().split()]
    m = max(b) - min(b);
    h = []
