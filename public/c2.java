import java.util.*; 
public class DFS { 
    public static void dfs(Map<String, List<String>> graph, String start) { 
        Stack<String> stack = new Stack<>(); 
        Set<String> visited = new HashSet<>(); 
        stack.push(start); 
        while (!stack.isEmpty()) { 
            String node = stack.pop(); 
            if (!visited.contains(node)) { 
                visited.add(node); 
                System.out.print(node + " "); 
                List<String> neighbors = graph.getOrDefault(node, new ArrayList<>()); 
                Collections.reverse(neighbors); 
                for (String neighbor : neighbors) { 
                    if (!visited.contains(neighbor)) { 
                        stack.push(neighbor); 
                    } 
                } 
            } 
        }} 
       public static void main(String[] args) { 
        Map<String, List<String>> graph = new HashMap<>(); 
        graph.put("A", Arrays.asList("B", "C")); 
        graph.put("B", Arrays.asList("D", "E")); 
        graph.put("C", Arrays.asList("F")); 
        graph.put("D", new ArrayList<>()); 
        graph.put("E", Arrays.asList("F")); 
        graph.put("F", new ArrayList<>()); 
        System.out.print("DFS: "); 
        dfs(graph, "A"); 
    } 
} 
