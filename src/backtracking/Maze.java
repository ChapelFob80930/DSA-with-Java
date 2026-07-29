package backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        System.out.println(path("",3,3));
        System.out.println(pathRetDiagonal("",3,3));

        boolean[][] booleanMaze = {
                {true,  true,  true},
                {true,  false, true},
                {true,  true,  true}
        };

        System.out.println(pathWithObstacles("", booleanMaze, 0, 0));
    }

    static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int cnt = 0;

        cnt += count(r - 1, c);
        cnt += count(r, c-1);

        return cnt;
    }

    static ArrayList<String> path(String p, int r, int c){

        ArrayList<String> ans = new ArrayList<>();

        if(r == 1 && c == 1){
            ans.add(p);
            return ans;
        }

        if(r > 1){
            ans.addAll(path(p+"D", r - 1, c));
        }

        if(c > 1){
            ans.addAll(path(p+"R", r, c - 1));
        }

        return ans;
    }

    static ArrayList<String> pathRetDiagonal(String p, int r, int c){

        ArrayList<String> ans = new ArrayList<>();

        if(r == 1 && c == 1){
            ans.add(p);
            return ans;
        }

        if(r > 1 && c > 1){
            ans.addAll(pathRetDiagonal(p+"D", r - 1, c - 1));
        }

        if(r > 1){
            ans.addAll(pathRetDiagonal(p+"V", r - 1, c));
        }

        if(c > 1){
            ans.addAll(pathRetDiagonal(p+"H", r, c - 1));
        }

        return ans;
    }

    static ArrayList<String> pathWithObstacles(String p, boolean[][] maze, int r, int c){

        ArrayList<String> ans = new ArrayList<>();

        if(r == maze.length - 1 && c == maze[0].length - 1){
            ans.add(p);
            return ans;
        }

        if(!maze[r][c]){
            return ans;
        }

        if(r < maze.length - 1){
            ans.addAll(pathWithObstacles(p+"D", maze, r + 1, c));
        }

        if(c < maze[0].length - 1){
            ans.addAll(pathWithObstacles(p+"R", maze,  r, c + 1));
        }

        return ans;
    }


}
