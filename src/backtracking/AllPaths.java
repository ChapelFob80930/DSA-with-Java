package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] booleanMaze = {
                {true,  true,  true},
                {true,  true, true},
                {true,  true,  true}
        };

        System.out.print("Q.1) Simple boolean maze traversal with a obstacle");
        System.out.print("\n");
        allPath("", booleanMaze, 0, 0);
        System.out.print("\n");
        System.out.print("Q.2) Boolean maze traversal using backtracking");
        System.out.print("\n");
        System.out.println(allPath2("", booleanMaze, 0, 0));
        System.out.print("\n");
        System.out.print("Q.3) Boolean maze traversal using backtracking and printing both the path taken and visualizing it in the matrix");
        System.out.print("\n");
        allPathPrint("", booleanMaze, 0, 0, new int[booleanMaze.length][booleanMaze[0].length], 1);
    }

    static void allPath(String path, boolean[][] maze, int r, int c) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        if (r < maze.length - 1) {
            allPath(path + 'D', maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            allPath(path + 'R', maze, r, c + 1);
        }

        if (r > 0) {
            allPath(path + 'U', maze, r - 1, c);
        }

        if (c > 0) {
            allPath(path + 'L', maze, r, c - 1);
        }

        // this line is where the function gets over
        // so before the function gets returned, remove any changes made by the function that should not be in other function calls
        // this is known as backtracking
        maze[r][c] = true;
    }

    static ArrayList<String> allPath2(String path, boolean[][] maze, int r, int c) {

        ArrayList<String> ans = new ArrayList<>();

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ans.add(path);
            return ans;
        }

        if (!maze[r][c]) {
            return ans;
        }

        maze[r][c] = false;

        if (r < maze.length - 1) {
            ans.addAll(allPath2(path + 'D', maze, r + 1, c));
        }

        if (c < maze[0].length - 1) {
            ans.addAll(allPath2(path + 'R', maze, r, c + 1));
        }

        if (r > 0) {
            ans.addAll(allPath2(path + 'U', maze, r - 1, c));
        }

        if (c > 0) {
            ans.addAll(allPath2(path + 'L', maze, r, c - 1));
        }

        // this line is where the function gets over
        // so before the function gets returned, remove any changes made by the function that should not be in other function calls
        // this is known as backtracking
        maze[r][c] = true;
        return ans;
    }

    static void allPathPrint(String path, boolean[][] maze, int r, int c, int[][] pathArray, int step) {

        if (r == maze.length - 1 && c == maze[0].length - 1) {
            pathArray[r][c] = step;
            for(int[] arr: pathArray){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(path);
            System.out.print("\n");
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        pathArray[r][c] = step;

        if (r < maze.length - 1) {
            allPathPrint(path + 'D', maze, r + 1, c, pathArray, step + 1);
        }

        if (c < maze[0].length - 1) {
            allPathPrint(path + 'R', maze, r, c + 1, pathArray, step + 1);
        }

        if (r > 0) {
            allPathPrint(path + 'U', maze, r - 1, c, pathArray, step + 1);
        }

        if (c > 0) {
            allPathPrint(path + 'L', maze, r, c - 1, pathArray, step + 1);
        }

        // this line is where the function gets over
        // so before the function gets returned, remove any changes made by the function that should not be in other function calls
        // this is known as backtracking
        maze[r][c] = true;
        pathArray[r][c] = 0;
    }

}
