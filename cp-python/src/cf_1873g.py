#!/usr/bin/env python3

for _ in range(int(input())):
    s = input()
    a = [0]
    b = 0
    for c in s:
        if c == 'B':
            b += 1;
            a.append(0)
        else: a[-1] += 1
    a.sort(reverse=True)
    coins = 0;
    for i in range(min(b, len(a))):
        coins += a[i]
    print(coins)
