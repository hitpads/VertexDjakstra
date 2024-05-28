import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private final Map<V, V> edgeTo;
    private final Map<V, Double> distTo;
    private final PriorityQueue<VertexDistance<V>> pq;
    private final V source;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        this.edgeTo = new HashMap<>();
        this.distTo = new HashMap<>();
        this.pq = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));
        this.source = source;
        for (Vertex<V> vertex : graph.getVertices()) {
            distTo.put(vertex.getData(), Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);
        pq.add(new VertexDistance<>(source, 0.0));
        dijkstra(graph);
    }

    private void dijkstra(WeightedGraph<V> graph) {
        while (!pq.isEmpty()) {
            V v = pq.poll().getVertex();
            for (Map.Entry<Vertex<V>, Double> entry : graph.getVertex(v).getAdjacentVertices().entrySet()) {
                relax(entry.getKey().getData(), v, entry.getValue());
            }
        }
    }

    private void relax(V neighbor, V vertex, double weight) {
        if (distTo.get(neighbor) > distTo.get(vertex) + weight) {
            distTo.put(neighbor, distTo.get(vertex) + weight);
            edgeTo.put(neighbor, vertex);
            pq.add(new VertexDistance<>(neighbor, distTo.get(neighbor)));
        }
    }

    @Override
    public boolean hasPathTo(V destination) {
        return distTo.get(destination) < Double.POSITIVE_INFINITY;
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

    private static class VertexDistance<V> {
        private final V vertex;
        private final double distance;

        public VertexDistance(V vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public V getVertex() {
            return vertex;
        }

        public double getDistance() {
            return distance;
        }
    }
}
