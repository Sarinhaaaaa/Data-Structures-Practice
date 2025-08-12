import java.util.*;
public class GraphTraversal {   

    public static void main(String[] args) {
    
        DirectedGraph<Character> network = new DirectedGraph<>(5);


        network.addVertex('A');
        network.addVertex('B');
        network.addVertex('C');
        network.addVertex('D');
        network.addVertex('E');

      
        network.connect(0, 1);
        network.connect(1, 2);
        network.connect(2, 3);
        network.connect(2, 4);
        network.connect(4, 0);
        network.connect(4, 2);

        
        network.displayMatrix();

        
        System.out.println("\nDepth-First Search starting at B:");
        network.depthFirst(1);
    }
}

class DirectedGraph<T> {
    private final List<T> vertices;
    private final boolean[][] edges;

    public DirectedGraph(int capacity) {
        vertices = new ArrayList<>();
        edges = new boolean[capacity][capacity];
    }

    public void addVertex(T value) {
        vertices.add(value);
    }

    public void connect(int from, int to) {
        edges[from][to] = true;
    }

    public boolean isConnected(int from, int to) {
        return edges[from][to];
    }

    public void displayMatrix() {
        System.out.print("  ");
        for (T v : vertices) {
            System.out.print(v + " ");
        }
        System.out.println();

        for (int i = 0; i < edges.length; i++) {
            System.out.print(vertices.get(i) + " ");
            for (boolean link : edges[i]) {
                System.out.print((link ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    public void depthFirst(int startIndex) {
        boolean[] visited = new boolean[vertices.size()];
        exploreDFS(startIndex, visited);
    }

    private void exploreDFS(int index, boolean[] visited) {
        if (visited[index]) return;

        visited[index] = true;
        System.out.println("Visited " + vertices.get(index));

        for (int neighbor = 0; neighbor < edges[index].length; neighbor++) {
            if (edges[index][neighbor]) {
                exploreDFS(neighbor, visited);
            }
        }
    }
}

