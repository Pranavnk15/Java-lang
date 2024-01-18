import java.util.*;

public class stronglyConnectedComponents {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // for(int i = 0; i<graph.length; i++) {
        //     graph[i] = new ArrayList<Edge>();
        // }

        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));   

        // graph[1].add(new Edge(1, 0));

        // graph[2].add(new Edge(2, 1));

        // graph[3].add(new Edge(3, 4));


        for(int i = 0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    // public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
    //     vis[curr] = true;

    //     for(int i = 0; i<graph[curr].size(); i++) {
    //         Edge e = graph[curr].get(i);
    //         if(!vis[e.dest]) {
    //             topSort(graph, e.dest, vis, s);
    //         }
    //     }
    //     s.push(curr);
    // }

    // public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
    //     vis[curr] = true;
    //     System.out.println(curr + " ");

    //     for(int i = 0; i<graph[curr].size(); i++) {
    //         Edge e = graph[curr].get(i);
    //         if(!vis[e.dest]) {
    //             dfs(graph, e.dest, vis);
    //         }
    //     }
    // }

    // public static void kosaraju(ArrayList<Edge> graph[], int V) {
    //      //step1 topological sort
    //      Stack<Integer> s = new Stack<>();
    //      boolean vis[] = new boolean[V];

    //      for(int i = 0; i<V; i++) {
    //         if(!vis[i]) {
    //             topSort(graph, i, vis, s);
    //         }
    //     }

    //     //step2
    //     @SuppressWarnings("unchecked")
    //     ArrayList<Edge> transpose[] = new ArrayList[V];
    //     for(int i = 0; i<graph.length; i++) {
    //         vis[i] = false;
    //         transpose[i] = new ArrayList<Edge>();
    //     }

    //     for(int i = 0; i<V; i++) {
    //         for(int j = 0; j<graph[i].size(); j++) {
    //             Edge e = graph[i].get(j); //e.src -> e.dest
    //             transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse edge
    //         }
    //     }

    //     //step 3
    //     while(!s.isEmpty()) {
    //         int curr = s.pop();
    //         if(!vis[curr]) {
    //             System.err.print("SCC -> ");
    //             dfs(transpose, curr, vis); //strongly connected components
    //             System.out.println();
    //         }
    //     }
    // }

    ////////////////////////////////////////////////////////
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int  time, boolean vis[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i = 0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i); //e.src -> e.dest
            int neigh = e.dest;
            if(neigh == par) {
                continue;
            } else if(!vis[neigh]) {
                dfs(graph, neigh, curr, dt, low, time, vis);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr] < low[curr]) {
                    System.out.println("Bridge: "+ curr+" ---- "+neigh);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }
    public static void tarjanBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for(int i = 0; i<V; i++) { // called a loop for all the connectedd components
            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, time, vis);
            }

        }
    }


    public static void main(String[] args) {
    //     int V = 5;
    //     @SuppressWarnings("unchecked")
    //     ArrayList<Edge> graph[] = new ArrayList[V];
    //     createGraph(graph);

    //     kosaraju(graph, V);


    /////////////////////////////////////////

        int V = 6;
       @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjanBridge(graph, V);
    }
}
