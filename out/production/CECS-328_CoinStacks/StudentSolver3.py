def solve(grid):
    # for r in grid:
    #     print(r)
    t = len(grid)
    b = [list(r) for r in grid]
    for repetition in range(2):
        for i in range(t):
            s = 0
            beginIndex = 0
        
            while s < t:
                hill = -1
                for j in range(s, t):
                    if grid[i][j] >= hill:
                        hill = grid[i][j]
                        s = j

                if beginIndex == 0:
                    hill = -1
                
                for j in range(beginIndex, s):
                    if grid[i][j] < hill:
                        grid[i][j] = hill
                    else:
                        hill = grid[i][j]
                s += 1
                beginIndex = s
                        

            s = 0
            beginIndex = 0

            while s < t:
                hill = -1
                for j in range(s, t):
                    if grid[j][i] >= hill:
                        hill = grid[j][i]
                        s = j
                        
                if beginIndex == 0:
                    hill = -1
                
                for j in range(beginIndex, s):
                    if grid[j][i] < hill:
                        grid[j][i] = hill
                    else:
                        hill = grid[j][i]
                s += 1
                beginIndex = s

    # for r in grid:
    #     print(*r)
    w = 0
    for i in range(t):
        for j in range(t):
            w += grid[i][j] - b[i][j]
    return w




inputGrid = [
    [4, 9, 3, 3, 5, 4, 6, 6, 10, 1],
    [1, 3, 6, 3, 3, 6, 3, 8, 4, 4],
    [2, 9, 3, 6, 10, 7, 8, 3, 10, 5],
    [6, 1, 3, 4, 9, 3, 1, 1, 9, 5],
    [10, 9, 9, 8, 3, 5, 7, 7, 10, 8],
    [2, 7, 8, 7, 4, 6, 8, 3, 1, 9],
    [8, 1, 6, 2, 3, 4, 2, 5, 1, 7],
    [8, 6, 4, 7, 6, 1, 7, 2, 9, 6],
    [8, 3, 8, 6, 9, 6, 10, 10, 8, 3],
    [10, 7, 9, 1, 6, 2, 2, 1, 2, 6]
]

expectedGrid = [
    [4, 9, 9, 9, 9, 9, 9, 9, 10, 1],
    [4, 9, 9, 9, 9, 9, 9, 9, 10, 4],
    [4, 9, 9, 9, 10, 10, 10, 10, 10, 5],
    [6, 9, 9, 9, 10, 10, 10, 10, 10, 5],
    [10, 10, 10, 10, 10, 10, 10, 10, 10, 8],
    [10, 10, 10, 10, 10, 10, 10, 10, 9, 9],
    [10, 10, 10, 10, 10, 10, 10, 10, 9, 7],
    [10, 10, 10, 10, 10, 10, 10, 10, 9, 6],
    [10, 10, 10, 10, 10, 10, 10, 10, 8, 6],
    [10, 9, 9, 6, 6, 6, 6, 6, 6, 6]
]

solve(inputGrid)

for i in range(len(inputGrid)):
    print(str(inputGrid[i]) + "\n")

print(inputGrid == expectedGrid)
    
    
