import java.util.*; 
 
class AStarNode implements Comparable<AStarNode> { 
    String name; 
    int g, h; 
    List<String> path; 
 
    AStarNode(String name, int g, int h, List<String> path) { 
        this.name = name; 
        this.g = g; 
        this.h = h; 
        this.path = new ArrayList<>(path); 
        this.path.add(name); 
    } 
 
    public int f() { 
        return g + h; 
    } 
 
    public int compareTo(AStarNode other) { 
        return Integer.compare(this.f(), other.f()); 
    } 
} 
 
public class AStar { 
    public static void aStar(Map<String, List<AStarNode>> graph, Map<String, Integer> 
heuristics, String start, String goal) { 
        PriorityQueue<AStarNode> pq = new PriorityQueue<>(); 
        Set<String> visited = new HashSet<>(); 
        pq.add(new AStarNode(start, 0, heuristics.get(start), new ArrayList<>())); 
 
        while (!pq.isEmpty()) { 
            AStarNode current = pq.poll(); 
            if (!visited.contains(current.name)) { 
                visited.add(current.name); 
                if (current.name.equals(goal)) { 
                    System.out.println("A* Path: " + current.path); 
                    System.out.println("Total Cost: " + current.g); 
                    return; 
                } 
 
                for (AStarNode neighbor : graph.getOrDefault(current.name, new ArrayList<>())) 
{ 
                    if (!visited.contains(neighbor.name)) { 
                        pq.add(new AStarNode( 
                            neighbor.name, 
                            current.g + neighbor.g,  // g = cost so far + edge cost 
                            heuristics.get(neighbor.name), 
                            current.path 
                        )); 
                    } 
                } 
            } 
        } 
    } 
 
    public static void main(String[] args) { 
        Map<String, List<AStarNode>> graph = new HashMap<>(); 
        graph.put("A", Arrays.asList(new AStarNode("B", 1, 0, new ArrayList<>()), new 
AStarNode("C", 4, 0, new ArrayList<>()))); 
        graph.put("B", Arrays.asList(new AStarNode("D", 2, 0, new ArrayList<>()), new 
AStarNode("E", 5, 0, new ArrayList<>()))); 
        graph.put("C", Arrays.asList(new AStarNode("F", 3, 0, new ArrayList<>()))); 
        graph.put("D", new ArrayList<>()); 
        graph.put("E", Arrays.asList(new AStarNode("F", 1, 0, new ArrayList<>()))); 
        graph.put("F", new ArrayList<>()); 
 
        Map<String, Integer> heuristics = new HashMap<>(); 
        heuristics.put("A", 6); 
        heuristics.put("B", 4); 
        heuristics.put("C", 2); 
        heuristics.put("D", 6); 
        heuristics.put("E", 2); 
        heuristics.put("F", 0); 
        aStar(graph, heuristics, "A", "F"); 
    } 
} 
