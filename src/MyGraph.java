import java.util.*;

public class MyGraph<V> {
    private final boolean directed;
    private final Map<V, Set<V>> adjacencyList;

    public MyGraph(boolean directed) {
        this.directed = directed;
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(V data) {
        adjacencyList.putIfAbsent(data, new HashSet<>());
    }

    public void addEdge(V source, V destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        if (!directed) {
            adjacencyList.get(destination).add(source);
        }
    }

    public Set<V> getAdjacentVertices(V data) {
        return adjacencyList.get(data);
    }

    public Collection<V> getVertices() {
        return adjacencyList.keySet();
    }
}
