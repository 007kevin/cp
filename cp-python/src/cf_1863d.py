#!/usr/bin/env python3

def solve(n,m,b):
    for i in range(n):
        for j in range(m):
            if b[i][j] == 'L':
                for k in range(i+1, n):
                    if b[k][j] == 'L':
                        b[i][j] = 'W'
                        b[i][j+1] = 'B'
                        b[k][j] = 'B'
                        b[k][j+1] = 'W'
                        break
                else:
                    return -1
            if b[i][j] == 'U':
                for k in range(j+1, m):
                    if b[i][k] == 'U':
                        b[i][j] = 'W'
                        b[i+1][j] = 'B'
                        b[i][k] = 'B'
                        b[i+1][k] = 'W'
                        break
                else:
                    return -1
    for row in b:
        print(''.join(row))
    return 0

for _ in range(int(input())):
    n, m = map(int,input().split())
    b = [list(input()) for _ in range(n)]
    if solve(n,m,b) == -1:
        print(-1)
