public class Main {

    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph(5);
        myGraph.addEdge(0,1);
        myGraph.addEdge(1,2);
        myGraph.addEdge(2,4);
        myGraph.addEdge(3,4);
        myGraph.addEdge(3,1);

        System.out.println(myGraph.hasEdge(2, 3));
        System.out.println(myGraph.hasEdge(2, 4));
        myGraph.removeEdge(2, 4);
        System.out.println(myGraph.hasEdge(2,4));

        System.out.println(myGraph.getNeighbors(1));

        myGraph.printGraph();

    }
}

