class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // Directions:
        // Move east (row + 0, col + 1) 
        // Move south (row + 1, col + 0)
        // Move west (row + 0, col - 1) 
        // Move north (row - 1, col + 0)
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 

        // Stores all valid coordinates visited in spiral order
        int[][] traversed = new int[rows*cols][2];

        // Index for inserting into traversed array
        int idx = 0;

        // step = number of cells to move in current direction
        // direction = current direction index
        for(int step = 1, direction = 0; idx<rows*cols;){

            // Every step size is repeated twice:
            // 1 east, 1 south
            // 2 west, 2 north
            // 3 east, 3 south ...
            for(int i = 0; i<2; ++i){

                // Move "step" times in current direction
                for(int j = 0; j<step; ++j){

                    // Store only positions inside matrix boundaries
                    // Spiral may temporarily go outside matrix
                    if(
                        rStart >= 0 &&
                        rStart < rows &&
                        cStart >= 0 &&
                        cStart < cols
                    ){
                        traversed[idx][0] = rStart;
                        traversed[idx][1] = cStart;
                        idx++;
                    }

                    // Move one cell in current direction
                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }

                // Rotate direction:
                // 0 -> 1 -> 2 -> 3 -> 0
                direction = (direction + 1) % 4; // 0 east, 1 south, 2 west, 3 north
            }

            // Increase spiral size after every two directions
            step++; 
        }

        return traversed;
    }
}