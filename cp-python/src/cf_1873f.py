#!/usr/bin/env python3

for _ in range(int(input())):
    n, k = map(int, input().split())
    a = [int(x) for x in input().split()]
    h = [int(x) for x in input().split()]
    len, i, j = 0, 0, 0
    while i < n:
        j += 1
        while j < n and h[j-1] % h[j] == 0:
            j += 1
        sum = 0
        left, right = i, i
        while right < j:
            while right < j and sum <= k:
                len = max(len, right - left)
                sum += a[right];
                right += 1
            while left < right and sum > k:
                sum -= a[left]
                left += 1
            len = max(len, right - left)
        i = j
    print(len)
