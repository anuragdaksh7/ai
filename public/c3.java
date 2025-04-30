import java.util.*; 
 
class Node implements Comparable<Node> { 
    String name; 
    int cost; 
    List<String> path; 
 
    Node(String name, int cost, List<String> path) { 
        this.name = name; 
        this.cost = cost; 
        this.path = new ArrayList<>(path); 
        this.path.add(name); 
    } 
 
    public int compareTo(Node other) { 
        return Integer.compare(this.cost, other.cost); 
    } 
} 
 
public class UCS { 
    public static void ucs(Map<String, List<Node>> graph, String start, String goal) { 
        PriorityQueue<Node> pq = new PriorityQueue<>(); 
        Set<String> visited = new HashSet<>(); 
        pq.add(new Node(start, 0, new ArrayList<>())); 
 
        while (!pq.isEmpty()) { 
            Node current = pq.poll(); 
            if (!visited.contains(current.name)) { 
                visited.add(current.name); 
                if (current.name.equals(goal)) { 
                    System.out.println("UCS Path: " + current.path); 
                    System.out.println("Total Cost: " + current.cost); 
                    return; 
                } 
 
                for (Node neighbor : graph.getOrDefault(current.name, new ArrayList<>())) { 
                    if (!visited.contains(neighbor.name)) { 
                        pq.add(new Node(neighbor.name, current.cost + neighbor.cost, 
current.path)); 
                    } 
                } 
            } 
        } 
    } 
 
    public static void main(String[] args) { 
        Map<String, List<Node>> graph = new HashMap<>(); 
        graph.put("A", Arrays.asList(new Node("B", 1, new ArrayList<>()), new Node("C", 4, 
new ArrayList<>()))); 
        graph.put("B", Arrays.asList(new Node("D", 2, new ArrayList<>()), new Node("E", 5, 
new ArrayList<>()))); 
        graph.put("C", Arrays.asList(new Node("F", 3, new ArrayList<>()))); 
        graph.put("D", new ArrayList<>()); 
        graph.put("E", Arrays.asList(new Node("F", 1, new ArrayList<>()))); 
        graph.put("F", new ArrayList<>()); 
 
        ucs(graph, "A", "F"); 
    } 
} 
