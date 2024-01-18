import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class graphsPart2 {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));

        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));

        // graph[3].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 3));
////////////////////////////////////////////////////////
//  // ///////////// BIPARTITE GRAPH /////////////
//             graph[0].add(new Edge(0, 1));
//             graph[0].add(new Edge(0, 2));

//             graph[1].add(new Edge(1, 0));
//             graph[1].add(new Edge(1, 3));

//             graph[2].add(new Edge(2, 0));
//             graph[2].add(new Edge(2, 4));

//             graph[3].add(new Edge(3, 1));
//             graph[3].add(new Edge(3, 4));

//             graph[4].add(new Edge(4, 2));
//             graph[4].add(new Edge(4, 3));
// //////////////////////////////////////////////////////////////////////
                /// CYCLE DETETCTION DIRECTED GRAPHS
                // TRUE - NO CYCLE 
                graph[0].add(new Edge(0, 2));

                graph[1].add(new Edge(1, 0));

                graph[2].add(new Edge(2, 3));

                graph[3].add(new Edge(3, 0));
///////////////////////////////////////////////////////////////////////
            // TOPOLOGICAL SORTING ///////

            graph[2].add(new Edge(2, 3));

            graph[3].add(new Edge(3, 1));

            graph[4].add(new Edge(4, 0));
            graph[4].add(new Edge(4, 1));

            graph[5].add(new Edge(5, 0));
            graph[5].add(new Edge(5, 2));




    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++) {
            if(!vis[i]) {
                if(detectCycleUtil(graph, vis, 1, -1)) {
                    return true;
                    //cycle exits in oneof the parts
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;

        for(int i = 0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            //case 3: not visited;
            if(!vis[e.dest]) {
                if(detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            //case 1: visited and is not a parent
            else if(vis[e.dest] && e.dest != par) {
                return true;
            }
            //case 2: visited and is parent => do nothing => continue
        }
        return false;
    }
/////////////////////////////////////////////////////////////////////////////
        /// BIPARTITE GRAPH WITH BFS APPROACH /////
    
    public static boolean isBipartite(ArrayList<Edge> graph[]) { // O(V+E)
        int col[] = new int[graph.length];
        for(int i = 0; i<graph.length; i++) {
            col[i] = -1; //asiigning no color to each node
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<graph.length; i++) {
            if(col[i] == -1) {
                // if there is no color assigned we wil performBFS and assign color
                q.add(i);
                col[i] = 0; // Asssigned first node as yellow color
                while(!q.isEmpty()) {
                    int curr = q.remove(); //removing current node from queue
                    for(int j = 0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1) {
                            //if the neighbour does not have any color then we will assign it
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol; //assigning color
                            q.add(e.dest); // adding neighbour to queue
                        } else if(col[e.dest] == col[curr]) {
                            //in this the neighbour color and curr color clashs
                            //hence graph is not a bipartite
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i = 0; i<graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                // if the node already exits true in stack then it has a cycle
                // hence return true
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                // if the node is not visited then again we will call isCycleUtil and if 
                // it return true then we will also return true;
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i<graph.length ; i++) {
            if(!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i = 0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {

        // int V = 5;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);

        // System.out.println(detectCycle(graph));
///////////////////////////////////////////////////////////////////////
        // BIPARTITE GRAPH BFS APPROACH /////
        // int V = 5;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);

        // System.out.println(isBipartite(graph));
//////////////////////////////////////////////////////////////
        //  CYCLE DETECTION IN DIRECTED GRAPHS USING DFS APPROACH//
        // int V = 4;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);

        // System.out.println(isCycle(graph));
///////////////////////////////////////////////////////////////
        //// TOPOLOGICAL SORTING //////
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);

            

    }
}
