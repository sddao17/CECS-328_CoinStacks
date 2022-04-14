class StudentSolver2 {

    public static int solve(int[][] grid) {
        int minCoins = 0;
        int n = grid[0].length;
        int[][] maxArr;

        for (int repeat = 2; repeat > 0; repeat--) {
            maxArr = new int[n][4];
            /*
            max[0] = first max index (start)
            max[1] = second max index (end)

            max[2] = first max value
            max[3] = second max value
             */

            // rows
            for (int i = 0; i < n; i++) {

                while (maxArr[i][0] < n) {
                    maxArr[i][3] = -1;

                    for (int j = maxArr[i][0]; j < n; j++) {
                        if (grid[i][j] >= maxArr[i][3]) {
                            maxArr[i][1] = j;
                            maxArr[i][3] = grid[i][j];
                        }
                    }

                    for (int j = maxArr[i][0]; j <= maxArr[i][1]; j++) {
                        if (maxArr[i][2] == maxArr[i][3]) {
                            minCoins = minCoins + (maxArr[i][2] - grid[i][j]);
                            grid[i][j] = maxArr[i][2];
                        } else if (maxArr[i][0] == 0)
                            if (grid[i][j] > maxArr[i][2])
                                maxArr[i][2] = grid[i][j];
                            else {
                                minCoins = minCoins + (maxArr[i][2] - grid[i][j]);
                                grid[i][j] = maxArr[i][2];
                            }
                        else {
                            minCoins = minCoins + (maxArr[i][3] - grid[i][j]);
                            grid[i][j] = maxArr[i][3];
                        }
                    }

                    maxArr[i][2] = maxArr[i][3];
                    maxArr[i][0] = maxArr[i][1] + 1;
                }
            }

            // columns
            maxArr = new int[n][4];
            for (int j = 0; j < n; j++) {

                while (maxArr[j][0] < n) {
                    maxArr[j][3] = -1;
                    for (int i = maxArr[j][0]; i < n; i++) {
                        if (grid[i][j] >= maxArr[j][3]) {
                            maxArr[j][1] = i;
                            maxArr[j][3] = grid[i][j];
                        }
                    }

                    for (int i = maxArr[j][0]; i <= maxArr[j][1]; i++) {
                        if (maxArr[j][2] == maxArr[j][3]) {
                            minCoins = minCoins + (maxArr[j][2] - grid[i][j]);
                            grid[i][j] = maxArr[j][2];
                        } else if (maxArr[j][0] == 0)
                            if (grid[i][j] > maxArr[j][2])
                                maxArr[j][2] = grid[i][j];
                            else {
                                minCoins = minCoins + (maxArr[j][2] - grid[i][j]);
                                grid[i][j] = maxArr[j][2];
                            }
                        else {
                            minCoins = minCoins + (maxArr[j][3] - grid[i][j]);
                            grid[i][j] = maxArr[j][3];
                        }

                    }

                    maxArr[j][2] = maxArr[j][3];
                    maxArr[j][0] = maxArr[j][1] + 1;
                }
            }
        }

        return minCoins;
    }
}