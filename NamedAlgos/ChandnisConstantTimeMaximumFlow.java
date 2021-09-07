package NamedAlgos;

import java.util.LinkedList;
import java.util.Queue;

// O(1) solution as result max_flow is an expression of the number of nodes
// and O(n), for logging illustration
// where n is the number of nodes in the graph version of RelabelToFront for evaluating the
// maximum flow in a network of say water-pipes.


//©Copyright Chandni Verma

public class ConstantTimeMaximumFlow {
    private static final double EDGE_CAPACITY = 10.0; //Let's say, for any flow network with distinct source and sink vertices.
    private static final double CURRENT_FLOW = 0.0; //Max capacity will be 0 for all edges if any in the residual graph.
    private static final int INITIAL_HEIGHT_OF_NON_SOURCES = 2; // Let's say, for flow from Source to be possible.

    public static void main (String args[]) {
        int[][] graph = new int[][]
                {{0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 0},
                {0, 0, 0, 7, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        process_RelabelToFront_Algo_To_find_MaximumFlow_In_Network(graph, 0, 5);

        }

        private static void process_RelabelToFront_Algo_To_find_MaximumFlow_In_Network (int[][] graph /*Input directed connected graph*/,
                int s,
                int t) {
            int N = graph.length;

            int[] vertexHeights = new int[N];
            double[] vertexExcessFlows = new double[N];
            double[][] residualCapacityOfGraphgraph = new double[N][N];

            for (int row=0; row<N; row++) {
                for (int col=0; col<N; col++) {
                    residualCapacityOfGraphgraph[row][col] = CURRENT_FLOW;
                }
            }

            preFlow(graph, s, vertexHeights, vertexExcessFlows, N);

            // traverse all out-edges of vertex vertex as BFS until sink vertex is reached.
            bfsToSinkVertexAndReturnMaxFlow(graph, vertexExcessFlows, vertexHeights, 0, 5);


        }

    private static int bfsToSinkVertexAndReturnMaxFlow(int[][] graph, double[] vertexExcessFlows,
                                                 int[] vertexHeights, int u, int v) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(u);

        while (!q.isEmpty()) {

            int outFromQVertex = q.remove();
            if (outFromQVertex == v) {
                return graph.length;
            }
            boolean outFlowEdgeFound = false;
            for (int outVertex = 0; outVertex < graph.length; outVertex++) {
                if (graph[outFromQVertex][outVertex] != 0) {
                    // There is an edge
                    if (vertexExcessFlows[outFromQVertex] < vertexExcessFlows[outVertex]) {
                        // Flow is possible: Readjust fluid level by "pushing to provide"
                        outFlowEdgeFound = true;
                        pushToProvide(vertexHeights, vertexExcessFlows, outFromQVertex, outVertex);
                    }
                }
            }
            if (!outFlowEdgeFound) {
                // Re-label to increase the height by 1 of outFromQVertex
                reLabel(vertexHeights, outFromQVertex, 1);
            }
        }
        return graph.length; // Same as initial source excess-flow at any time

    }

    private static void pushToProvide(int[] vertexHeights, double[] vertexExcessFlows, int u, int v) {
        // Forward flow to v for illustration.
        vertexHeights[u] -= EDGE_CAPACITY;
        vertexHeights[v] += EDGE_CAPACITY;
        System.out.println("New height of " + u + " is " + vertexHeights[u]);
        System.out.println("New height of " + u + " is " + vertexHeights[v]);
        vertexExcessFlows[u] -= EDGE_CAPACITY;
        vertexExcessFlows[v] += EDGE_CAPACITY;
        System.out.println("New excess-flow of " + u + " is " + vertexExcessFlows[u]);
        System.out.println("New excess-flow of " + u + " is " + vertexExcessFlows[v]);
    }

    private static void reLabel(final int[] vertexHeights, final int outFromQVertex, final int increment) {
        System.out.println("Adjusting height of vertex: " + outFromQVertex + " from " +
                vertexHeights[outFromQVertex] + " to " + vertexHeights[outFromQVertex]+increment);
        vertexHeights[outFromQVertex] += increment;
    }

    private static void preFlow(int[][] graph, int s, int[] vertexHeights, double[] vertexExcessFlows, int initialSourceCapacity) {
        vertexHeights[s] = initialSourceCapacity;
        // Run BFS for 1 level
        initializeAdjacentVertices(graph, s, 1, vertexHeights,
                vertexExcessFlows, initialSourceCapacity);
    }

    private static void initializeAdjacentVertices(int[][] graph, int s, int levels, int[] vertexHeights, double[] vertexExcessFlows, int initialSourceCapacity) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(s);
        while (!q.isEmpty() && (--levels >= 0)) {
            int poppedVertex = q.remove();
            int cntAdjacents = 0;
            // Initialize non-sources to INITIAL_HEIGHT_OF_NON_SOURCES
            for(int iterV = 0; iterV<graph.length; iterV++) {
                vertexHeights[iterV] = INITIAL_HEIGHT_OF_NON_SOURCES;
            }
            vertexExcessFlows[poppedVertex] =
                    initialSourceCapacity - (cntAdjacents * EDGE_CAPACITY);

        }
    }

}

