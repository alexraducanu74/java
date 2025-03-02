package homework;

import java.util.*;

public class GraphGenerator {
    private static int[][] adjacencyMatrix;
    private static int n, k;
    private static final Random random = new Random();

    public static int[][] generateGraph(int n, int k) {
        GraphGenerator.n = n;
        GraphGenerator.k = k;
        adjacencyMatrix = new int[n][n];
        generateGraph();
        return adjacencyMatrix;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java GraphGenerator <n> <k>");
            return;
        }

        n = Integer.parseInt(args[0]);
        k = Integer.parseInt(args[1]);

        if (k > n) {
            System.out.println("k must be <= n.");
            return;
        }

        long startTime = System.currentTimeMillis();
        adjacencyMatrix = new int[n][n];
        generateGraph();

        displayGraphProperties();
        long endTime = System.currentTimeMillis();

        if (n > 30000)
            System.out.println("Execution time: " + (endTime - startTime) + " ms");
        else
            displayMatrix();
    }

    private static void generateGraph() {
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = random.nextBoolean() ? 1 : 0;

        for (int i = 0; i < k; i++)
            for (int j = i + 1; j < k; j++)
                adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = 1;

        for (int i = k; i < k * 2 && i < n; i++)
            for (int j = i + 1; j < k * 2 && j < n; j++)
                adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = 0;
    }

    private static void displayMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(adjacencyMatrix[i][j] == 1 ? "■ " : "□ ");
            System.out.println();
        }
    }

    public static void displayMatrix(int[][] adjMatrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(adjMatrix[i][j] == 1 ? "■ " : "□ ");
            System.out.println();
        }
    }

    private static void displayGraphProperties() {
        int edges = 0;
        int[] degrees = new int[n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (adjacencyMatrix[i][j] == 1) {
                    degrees[i]++;
                    if (i < j)
                        edges++;
                }

        int maxDegree = Arrays.stream(degrees).max().orElse(0);
        int minDegree = Arrays.stream(degrees).min().orElse(0);

        System.out.println("Number of edges (m): " + edges);
        System.out.println("Maximum degree (ΔG): " + maxDegree);
        System.out.println("Minimum degree (δG): " + minDegree);
        System.out.println("Sum of degrees: " + Arrays.stream(degrees).sum());
        System.out.println("2*m: " + (2 * edges));
        System.out.print("Sum of the degrees equals the value 2 * m: ");
        System.out.println(Arrays.stream(degrees).sum() == (2 * edges) ? "Yes" : "No");
    }
}
