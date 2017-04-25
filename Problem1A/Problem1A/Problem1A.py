'''
Created on 20 abr. 2017

@author: Rubn
'''
import sys
def cut(matrix):
    i = 0
    j = 0
    while matrix[i][j] == '?':
        if j == len(matrix[i])-1:
            i += 1
            j = 0
        else:
            j += 1
    char = matrix[i][j]
    charI = i
    if j == len(matrix[i])-1:
        i += 1
        j = 0
    else:
        j += 1
    while i < len(matrix) and matrix[i][j] == '?':
        if j == len(matrix[i])-1:
            i += 1
            j = 0
        else:
            j += 1
    if i < len(matrix):
        if charI == i:
            tempMatrix = [[0 for x in range(len(matrix))] for y in range(len(matrix[i]))]
            for x in range(len(matrix)):
                for y in range(len(matrix[x])):
                    tempMatrix[y][x] = matrix[x][y]
            cut(tempMatrix[0:j])
            cut(tempMatrix[j:])
            for x in range(len(matrix)):
                for y in range(len(matrix[x])):
                    matrix[x][y] = tempMatrix[y][x]
        else:
            cut(matrix[0:i])
            cut(matrix[i:])
    else:#base case
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                matrix[i][j] = char
    return

def printMatrix(matrix):
    for i in range(len(matrix)):
        print(''.join(matrix[i]))
    return


f = open('A.in')
savein = sys.stdin
saveout = sys.stdout
sys.stdin = f
sys.stdout = open('A.out', 'w')
t = int(input())

for tc in range(1, t + 1):
    print("Case #" + str(tc) + ": ")
    r,c = input().split()
    r = int(r)
    c = int(c)
    matrix = [[0 for x in range(c)] for y in range(r)]
    for i in range(r):
        line = input()
        for j in range(c):
            matrix[i][j] = line[j]
    cut(matrix)
    printMatrix(matrix)
sys.stdin = savein
sys.stdout = saveout