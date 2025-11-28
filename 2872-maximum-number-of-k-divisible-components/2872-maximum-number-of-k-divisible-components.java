class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int[] result = new int[1]; 

        dfs(0, -1, graph, values, k, result, visited);
        return result[0];
    }

    private long dfs(int node, int parent,
                     List<List<Integer>> graph,
                     int[] values, int k,
                     int[] result, boolean[] visited) {

        visited[node] = true;
        long sum = values[node];

        for (int nei : graph.get(node)) {
            if (nei == parent) continue;
            if (!visited[nei]) {
                sum += dfs(nei, node, graph, values, k, result, visited);
            }
        }

        if (sum % k == 0) {
            result[0]++;
            return 0; 
        }

        return sum;
    }
}
