import java.util.LinkedList;

public class MyGraph {
    private int numOfVertices;
    private LinkedList<Integer>[] adjList;

    public MyGraph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.adjList = new LinkedList[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        validateVertex(source);
        validateVertex(destination);
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    public boolean hasEdge(int source, int destination) {
        validateVertex(source);
        validateVertex(destination);
        return adjList[source].contains(destination);
    }

    private void validateVertex(int index) {
        if (index < 0 || index >= numOfVertices)
            throw new IndexOutOfBoundsException("Vertex does not exist");
    }

    public void removeEdge(int source, int destination){
        validateVertex(source);
        validateVertex(destination);
        adjList[source].remove(adjList[source].indexOf(destination));
        adjList[destination].remove(adjList[destination].indexOf(source));
    }

    public LinkedList<Integer> getNeighbors(int vertex) {
        validateVertex(vertex);
        return adjList[vertex];
    }

    public void printGraph() {
        for (int i = 0; i < numOfVertices; i++) {
            System.out.print("Vertex " + i + " connected to " );
            for (int neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

