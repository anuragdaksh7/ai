import java.util.*; 
public class BFS { 
    public static void bfs(Map<String, List<String>> graph, String start) { 
        Queue<String> queue = new LinkedList<>(); 
        Set<String> visited = new HashSet<>(); 
        queue.add(start); 
        while (!queue.isEmpty()) { 
            String node = queue.poll(); 
            if (!visited.contains(node)) { 
                visited.add(node); 
                System.out.print(node + " "); 
                queue.addAll(graph.getOrDefault(node, new ArrayList<>())); 
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
        System.out.print("BFS: "); 
        bfs(graph, "A"); 
    } 
} 
