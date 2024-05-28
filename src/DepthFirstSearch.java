import java.util.*;

public class DepthFirstSearch<V> implements Search<V> {
    private final Map<V, V> edgeTo;
    private final Set<V> marked;
    private final V source;

    public DepthFirstSearch(MyGraph<V> graph, V source) {
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
        this.source = source;
        dfs(graph, source);
    }

    private void dfs(MyGraph<V> graph, V v) {
        marked.add(v);
        for (V neighbor : graph.getAdjacentVertices(v)) {
            if (!marked.contains(neighbor)) {
                edgeTo.put(neighbor, v);
                dfs(graph, neighbor);
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
