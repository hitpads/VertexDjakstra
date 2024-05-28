import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private final boolean directed;
    private final Map<V, Vertex<V>> vertices;

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
    }

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V source, V destination, double weight) {
        addVertex(source);
        addVertex(destination);
        vertices.get(source).addAdjacentVertex(vertices.get(destination), weight);
        if (!directed) {
            vertices.get(destination).addAdjacentVertex(vertices.get(source), weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }
}
