public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Astana");
        if (djk.pathTo("Pavlodar") != null) {
            outputPath(djk, "Pavlodar");
        } else {
            System.out.println("No path found from Astana to Astana using Djikstra");
        }

        System.out.println("--------------------------------");

        MyGraph graph = new MyGraph(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch(graph, "Astana");
        if (dfs.pathTo("Kyzylorda") != null) {
            outputPath(dfs, "Kyzylorda");
        } else {
            System.out.println("No path found from Astana to Kyzylorda using DFS");
        }

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        WeightedGraph<String> graphForBFS = new WeightedGraph<>(true);
        fillWithWeights(graphForBFS);
        Search<String> bfs = new BreadthFirstSearch<>(graphForBFS, "Almaty");
        if (dfs.pathTo("Kyzylorda") != null) {
            outputPath(bfs, "Kyzylorda");
        } else {
            System.out.println("No path found from Almaty to Kyzylorda using DFS");
        }
    }

    public static void fillWithoutWeights(MyGraph graph) {
        graph.addEdge("Almaty", "Astana");
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
        graph.addEdge("Kostanay", "Pavlodar");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
        graph.addEdge("Kostanay", "Pavlodar", 2.2);
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
        System.out.println();
    }
}