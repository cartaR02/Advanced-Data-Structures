package Module_3;

// 11/04/2024
// Carter Struck

import java.util.Scanner;

public class CMSC401_A3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coursesNumber = scanner.nextInt();
        int lectureHalls = scanner.nextInt();
    
        // agacencies array is used to store the thing it can go to
        int size = coursesNumber + lectureHalls + 2;
        int[][] agacencies = new int[size][size]; 
    
        scanner.nextLine();
    
        // adding courses to the grid
        // start 1 for S is 0 and size - 1 is E
        for (int i = 1; i <= coursesNumber; i++) { 
            String courseString = scanner.nextLine();
            String[] courseNumbers = courseString.split(" ");

            // converting string to integer array
            int[] intArray = new int[courseNumbers.length];
            for (int j = 0; j < courseNumbers.length; j++) {
                intArray[j] = Integer.parseInt(courseNumbers[j]);
            }
            // connecting starting node to courses
            agacencies[0][intArray[0]] = 1;

            for (int j = 1; j < intArray.length; j++) {
                agacencies[i][intArray[j] + lectureHalls] = 1;
                // connecting halls to end node
                agacencies[i + coursesNumber][size - 1] = 1;
            }
        }
        // matrix is now setup
        // 0 is starting node
        // last slot is end node
        System.out.println(maxFlow(agacencies, size, 0, size - 1));

        //printGrid(agacencies, size);
        scanner.close();   
    }

    static boolean bfs(int[][] residualgraph, int source, int sink, int parent[], int V) {
        boolean visited[] = new boolean[V];
        java.util.LinkedList<Integer> queue = new java.util.LinkedList<>();

        visited[source] = true;
        queue.add(source);
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && residualgraph[u][v] > 0) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.add(v);

                    if (v == sink){
                        return true; // path found
                    }
                }
            }
        }

        return false; // no path found
    }

    static int maxFlow(int[][] graph, int V, int source, int sink) {
        int u, v;

        // create the proper residual graph for the flow

        int residualGraph[][] = new int[V][V];
        // copy the original graph into the residual graph
        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                residualGraph[u][v] = graph[u][v];
            }
        }

        int parent[] = new int[V];
        int maxFlow = 0; // current max flow 

        while (bfs(residualGraph, source, sink, parent, V)) {
            int pathFlow = 1;
            for (v = sink; v!= source; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            // update residual graph and max flow
            for (v = sink; v!= source; v = parent[v]) {
                u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
        }


        return maxFlow;
    }
    public static void printGrid(int[][] agacencies, int size) {
        System.out.println("\nAgacencies Grid:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(agacencies[i][j] + " ");
            }
            System.out.println();
        }
    }

}