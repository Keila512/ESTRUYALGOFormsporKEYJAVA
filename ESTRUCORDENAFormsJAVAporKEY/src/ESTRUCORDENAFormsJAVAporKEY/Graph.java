package ESTRUCORDENAFormsJAVAporKEY;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }
    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(int startVertex, int endVertex) {
        if (adjacencyList.containsKey(startVertex) && adjacencyList.containsKey(endVertex)) {
            adjacencyList.get(startVertex).add(endVertex);
        } else {
            System.out.println("One or both vertices do not exist in the graph.");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            result.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }
}
