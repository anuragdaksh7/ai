import java.util.*; 
 
class BestNode implements Comparable<BestNode> { 
    String name; 
    int heuristic; 
    List<String> path; 
 
    BestNode(String name, int heuristic, List<String> path) { 
        this.name = name; 
        this.heuristic = heuristic; 
        this.path = new ArrayList<>(path); 
        this.path.add(name); 
    } 
 
    public int compareTo(BestNode other) { 
        return Integer.compare(this.heuristic, other.heuristic); 
    } 
} 
 
public class BestFirstSearch { 
    public static void bestFirst(Map<String, List<String>> graph, Map<String, Integer> 
heuristics, String start, String goal) { 
        PriorityQueue<BestNode> pq = new PriorityQueue<>(); 
        Set<String> visited = new HashSet<>(); 
        pq.add(new BestNode(start, heuristics.get(start), new ArrayList<>())); 
 
        while (!pq.isEmpty()) { 
            BestNode current = pq.poll(); 
            if (!visited.contains(current.name)) { 
                visited.add(current.name); 
                if (current.name.equals(goal)) { 
                    System.out.println("Best First Search Path: " + current.path); 
                    return; 
                } 
                for (String neighbor : graph.getOrDefault(current.name, new ArrayList<>())) { 
                    if (!visited.contains(neighbor)) { 
                        pq.add(new BestNode(neighbor, heuristics.get(neighbor), current.path)); 
                    } 
                } 
            } 
        } 
    } 
 
    public static void main(String[] args) { 
        Map<String, List<String>> graph = new HashMap<>(); 
        graph.put("A", Arrays.asList("B", "C")); 
        graph.put("B", Arrays.asList("D", "E")); 
        graph.put("C", Arrays.asList("F")); 
        graph.put("D", new ArrayList<>()); 
        graph.put("E", Arrays.asList("F")); 
        graph.put("F", new ArrayList<>()); 
 
        Map<String, Integer> heuristics = new HashMap<>(); 
        heuristics.put("A", 5); 
        heuristics.put("B", 3); 
        heuristics.put("C", 2); 
        heuristics.put("D", 6); 
        heuristics.put("E", 4); 
        heuristics.put("F", 0); 
 
        bestFirst(graph, heuristics, "A", "F"); 
    } 
