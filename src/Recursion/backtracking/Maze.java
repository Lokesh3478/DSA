package Recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {

    // Bottom to top
    public int pathCountBetweenTwoCorners(int row, int col) {
        if (row == 1 && col == 1) {
            return 1;
        }
        int c1 = 0, c2 = 0, c3 = 0;
        if (row > 1) {
            c1 = pathCountBetweenTwoCorners(row - 1, col);
        }
        if (col > 1) {
            c2 = pathCountBetweenTwoCorners(row, col - 1);
        }
        if (row > 1 && col > 1) {
            c3 = pathCountBetweenTwoCorners(row - 1, col - 1);
        }
        return c1 + c2 + c3;
    }

    public ArrayList<String> pathFromTopToBottom(int row, int col, String s) {
        ArrayList<String> res = new ArrayList<>();
        if (row == 1 && col == 1) {
            res.add(s);
            return res;
        }
        if (row > 1) {
            res.addAll(pathFromTopToBottom(row - 1, col, s + "D "));
        }
        if (col > 1) {
            res.addAll(pathFromTopToBottom(row, col - 1, s + "R "));
        }
        if (row > 1 && col > 1) {
            res.addAll(pathFromTopToBottom(row - 1, col - 1, s + "C "));
        }
        return res;
    }
    public ArrayList<String> blockedMazePath(boolean arr[][], boolean allDirections) {
    	if(!allDirections) {
    		return blockedMazePath(arr, 0, 0, "");
    	}
        return blockedMazePath(arr, 0, 0, "", allDirections);
    }

    public ArrayList<int[][]> blockedMazePathWithPath(boolean arr[][], boolean allDirections) {
        return blockedMazePath(arr, 0, 0, new int[arr.length][arr[0].length], 1, allDirections);
    }

    private  ArrayList<String> blockedMazePath(boolean arr[][], int r, int c, String s) {
        ArrayList<String> res = new ArrayList<>();
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            res.add(s);
            return res;
        }
        if (r < arr.length && c < arr[0].length && arr[r][c]) {
            if (r < arr.length - 1) {
                res.addAll(blockedMazePath(arr, r + 1, c, s + "D"));
            }
            if (c < arr[0].length - 1) {
                res.addAll(blockedMazePath(arr, r, c + 1, s + "R"));
            }
            res.addAll(blockedMazePath(arr, r + 1, c + 1, s + "C"));
        }
        return res;
    }

    private ArrayList<String> blockedMazePath(boolean arr[][], int r, int c, String path, boolean allDirections) {
        ArrayList<String> result = new ArrayList<>();
        if (!allDirections) {
            return blockedMazePath(arr, r, c, path);
        }
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            result.add(path);
            return result;
        }
        if (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && arr[r][c]) {
            arr[r][c] = false;
            if (r < arr.length - 1) {
                result.addAll(blockedMazePath(arr, r + 1, c, path + "D", allDirections));
            }
            if (c < arr[0].length - 1) {
                result.addAll(blockedMazePath(arr, r, c + 1, path + "R", allDirections));
            }
            if (r > 0) {
                result.addAll(blockedMazePath(arr, r - 1, c, path, allDirections));
            }
            if (c > 0) {
                result.addAll(blockedMazePath(arr, r, c - 1, path, allDirections));
            }
            result.addAll(blockedMazePath(arr, r + 1, c + 1, path + "C"));
            arr[r][c] = true;
        }
        return result;
    }

    private ArrayList<int[][]> blockedMazePath(boolean arr[][], int r, int c, int path[][], int level, boolean allDirections) {
        ArrayList<int[][]> result = new ArrayList<>();
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            path[r][c] = level;
            int res[][] = new int[path.length][path[0].length];
            for (int i = 0; i < path.length; i++) {
                res[i] = Arrays.copyOf(path[i], path[i].length);
            }
            path[r][c] = 0;
            result.add(res);
            return result;
        }
        if (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && arr[r][c]) {
            arr[r][c] = false;
            path[r][c] = level;
            if (r < arr.length - 1&&arr[r+1][c]) {
                result.addAll(blockedMazePath(arr, r + 1, c, path, level + 1, allDirections));
            }
            if (c < arr[0].length - 1&&arr[r][c+1]) {
                result.addAll(blockedMazePath(arr, r, c + 1, path, level + 1, allDirections));
            }
            if (r > 0&&arr[r-1][c]) {
                result.addAll(blockedMazePath(arr, r - 1, c, path, level + 1, allDirections));
            }
            if (c > 0&&arr[r][c-1]) {
                result.addAll(blockedMazePath(arr, r, c - 1, path, level + 1, allDirections));
            }
            //result.addAll(blockedMazePath(arr, r + 1, c + 1, path, level + 1, allDirections));
            arr[r][c] = true;
            path[r][c] = 0;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Maze m = new Maze();
        System.out.println(m.pathCountBetweenTwoCorners(3, 4));
        ArrayList<String> paths = m.pathFromTopToBottom(3, 4, "");
        System.out.println(paths + " " + paths.size());

        boolean maze[][] = new boolean[][] {
                { true, true, true, false }, { false, true, true, true }, { true, true, false, true }
        };

        System.out.println(m.blockedMazePath(maze,false));
        System.out.println(m.blockedMazePath(maze, true));

        ArrayList<int[][]> result = m.blockedMazePathWithPath(maze, true);
        for (int arr[][] : result) {
            for (int a[] : arr) {
                System.out.println(Arrays.toString(a));
            }
            System.out.println("::::::::::::");
        }
    }
}
