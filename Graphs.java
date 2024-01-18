import java.util.*;

public class Graphs {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }


    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++) {
            if(!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[], boolean vis[]) { //O(V+E)
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0); //source = 0;

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) { //visit curr
                System.out.print(curr + " ");
                vis[curr] = true;
                for(int i = 0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
        }
    }


    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i  = 0; i<graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }
    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        //visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
        if(src == dest) {
            return true;
        }
        vis[src] = true;
        for(int i = 0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            //e.dest = neighbour
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        // //GIVEN GRAPH IN NOTION HAS TOTAL 5 VERTICES FROM ZERO TO FOUR.
        // int V = 5;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // //now the above array created has null value and we have to
        // //initialize an empty arraylist at its each index
        // for(int i = 0; i<V; i++) {
        //     graph[i] = new ArrayList<>();
        // }

        // //now to store the data vertex 
        // //0-vertex
        // graph[0].add(new Edge(0, 1, 5));

        // //1-vertex
        // graph[1].add(new Edge(1, 0, 5));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 3));

        // //2-vertex
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge(2, 4, 2));

        // //3-vertex
        // graph[3].add(new Edge(3, 2, 1));
        // graph[3].add(new Edge(3, 1, 3));

        // //4-vertex
        // graph[4].add(new Edge(4, 2, 2));

        // //to get the neighours of a vertex
        // //to get 2's neighbours
        // for(int i = 0; i<graph[2].size(); i++) {
        //     Edge e = graph[2].get(i); //src, dest, wt
        //     System.out.println(e.dest); //2's neighbours
        // }



/////////////////////////////////////////////////////////////////////////
            // BFS //
            // int V = 7;
            // @SuppressWarnings("unchecked")
            // ArrayList<Edge> graph[] = new ArrayList[V];
            // createGraph(graph);   
            // bfs(graph);         
////////////////////////////////////////////////////////////////
            // /// DFS //
            // int V = 7;
            // @SuppressWarnings("unchecked")
            // ArrayList<Edge> graph[] = new ArrayList[V];
            // createGraph(graph);   
            // dfs(graph, 0, new boolean[V]);   
/////////////////////////////////////////////////////////////////////////
            // HAS PATH //
            int V = 7;
            @SuppressWarnings("unchecked")
            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph);   
            System.out.println(hasPath(graph, 0, 7, new boolean[V]));



        
    }
}
