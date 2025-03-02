package bonus;

import java.util.*;

import homework.GraphGenerator;

public class GraphChecker {
    private static int n, k;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GraphChecker <k>");
            return;
        }

        int[][] adjacencyMatrix = GraphGenerator.generateGraph(10, 6);
        n = adjacencyMatrix.length;
        k = Integer.parseInt(args[0]);

        if (k > n) {
            System.out.println("The graph does not contain a clique of size " + k);
            System.out.println("The graph does not contain a stable set of size " + k);
            return;
        }

        System.out.println(containsClique(adjacencyMatrix)
                ? "The graph contains a clique of size " + k
                : "The graph does not contain a clique of size " + k);

        int[][] complementMatrix = getGraphComplement(adjacencyMatrix);
        System.out.println(containsClique(complementMatrix)
                ? "The graph contains a stable set of size " + k
                : "The graph does not contain a stable set of size " + k);
    }

    private static boolean containsClique(int[][] adjacencyMatrix) {
        int[] vertices = new int[n];
        for (int i = 0; i < n; i++)
            vertices[i] = i;
        List<List<Integer>> subsets = (combine(vertices));
        for (List<Integer> subset : subsets) {
            boolean clique = true;
            for (int i : subset) {
                for (int j : subset)
                    if (adjacencyMatrix[i][j] == 0 && i != j) {
                        clique = false;
                        break;
                    }
                if (!clique)
                    break;
            }
            if (clique)
                return true;
        }
        return false;
    }


    public static List<List<Integer>> combine(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, k, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int k, int start) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, k, i + 1);
            tempList.removeLast();
        }
    }

    public static int[][] getGraphComplement(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        int[][] complementMatrix = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j)
                    complementMatrix[i][j] = (adjacencyMatrix[i][j] == 1) ? 0 : 1;
                else
                    complementMatrix[i][j] = 0;
        return complementMatrix;
    }
}
