import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<V, V> edgeTo;
    private Set<V> marked;
    private V source;

    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
        this.source = source;
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);

        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (Vertex<V> neighbor : graph.getVertex(v).getAdjacentVertices().keySet()) {
                if (!marked.contains(neighbor.getData())) {
                    edgeTo.put(neighbor.getData(), v);
                    marked.add(neighbor.getData());
                    queue.add(neighbor.getData());
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(V destination) {
        return marked.contains(destination);
    }

    @Override
    public List<V> pathTo(V destination) {
        if (!hasPathTo(destination)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V x = destination; !x.equals(source); x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(source);
        return path;
    }
}
