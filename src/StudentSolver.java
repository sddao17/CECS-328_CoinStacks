
/**
 * @author Steven Dao
 * @version 1.0
 *
 * Date: August 24, 2021
 * Purpose: To create the class StudentSolver that, given a grid of coin heights, determines the minimum
 *          number of coins that must be added to certain piles of coins in order to ensure that the piles
 *          leading adjacently outward from the King of the Hill are in decreasing order.
 *          The grid must also be modified to show how tall the coin stacks should be afterwards.
 */
public class StudentSolver {

    /**
     * Returns the minimum number of coins needed to satisfy the grid restrictions.
     *
     * @param grid the input grid of the coin stacks
     * @return the minimum number of coins needed to satisfy the grid restrictions
     */
    public static int solve(int[][] grid) {

        int minNumOfCoins = 0;

        // get the dimensions of the 2D array
        int xGridLength = grid[0].length;
        int yGridLength = grid.length;

        // traverse the 2D array thrice to account for possible changes in piles previously checked
        for (int count = 3; count > 0; --count) {
            // traverse the 2D array
            for (int i = 0; i < yGridLength; ++i) {
                for (int j = 0; j < xGridLength; ++j) {
                    int currentStack = grid[i][j];

                    // find the highest values in all directions relative to the currentStack
                    int upperMax = findUpperMax(grid, i, j);
                    int rightMax = findRightMax(grid, i, j);
                    int lowerMax = findLowerMax(grid, i, j);
                    int leftMax = findLeftMax(grid, i, j);

                    // find the lowest possible bound of the maxes in both horizontal and vertical directions
                    int xMax = Math.min(leftMax, rightMax);
                    int yMax = Math.min(upperMax, lowerMax);

                    // find the highest possible value of the two lower bounds (the minimum highest)
                    int updatedStack = Math.max(xMax, yMax);

                    // update the stack to reflect the number of coins added
                    grid[i][j] = updatedStack;
                    // add to the minimum number of coins needed to satisfy the requirements
                    minNumOfCoins += updatedStack - currentStack;
                }
            }
        }

        return minNumOfCoins;
    }

    /**
     * Returns the maximum value to the top of the current integer within the grid.
     *
     * @param inputGrid the input grid of the coin stacks
     * @param y the integer's vertical location within the grid
     * @param x the integer's horizontal location within the grid
     * @return the upper maximum value
     */
    private static int findUpperMax(int[][] inputGrid, int y, int x) {

        int upperMax = inputGrid[y][x];

        for (int i = y - 1; i >= 0; --i) {
            if (upperMax < inputGrid[i][x])
                upperMax = inputGrid[i][x];
        }

        return upperMax;
    }

    /**
     * Returns the maximum value to the right of the current integer within the grid.
     *
     * @param inputGrid the input grid of the coin stacks
     * @param y the integer's vertical location within the grid
     * @param x the integer's horizontal location within the grid
     * @return the right maximum value
     */
    private static int findRightMax(int[][] inputGrid, int y, int x) {

        int rightMax = inputGrid[y][x];
        int xGridLength = inputGrid[0].length;

        for (int i = x + 1; i < xGridLength; ++i) {
            if (rightMax < inputGrid[y][i])
                rightMax = inputGrid[y][i];
        }

        return rightMax;
    }

    /**
     * Returns the maximum value to the bottom of the current integer within the grid.
     *
     * @param inputGrid the input grid of the coin stacks
     * @param y the integer's vertical location within the grid
     * @param x the integer's horizontal location within the grid
     * @return the lower maximum value
     */
    private static int findLowerMax(int[][] inputGrid, int y, int x) {

        int lowerMax = inputGrid[y][x];
        int yGridLength = inputGrid.length;

        for (int i = y + 1; i < yGridLength; ++i) {
            if (lowerMax < inputGrid[i][x])
                lowerMax = inputGrid[i][x];
        }

        return lowerMax;
    }

    /**
     * Returns the maximum value to the left of the current integer within the grid.
     *
     * @param inputGrid the input grid of the coin stacks
     * @param y the integer's vertical location within the grid
     * @param x the integer's horizontal location within the grid
     * @return the left maximum value
     */
    private static int findLeftMax(int[][] inputGrid, int y, int x) {

        int leftMax = inputGrid[y][x];

        for (int i = x - 1; i >= 0; --i) {
            if (leftMax < inputGrid[y][i])
                leftMax = inputGrid[y][i];
        }

        return leftMax;
    }
}
