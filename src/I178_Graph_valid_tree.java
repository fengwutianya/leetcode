/**
 * Created by xuan on 2017/7/13 0013.
 */
public class I178_Graph_valid_tree {
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        int len = edges.length;
        if (len != n - 1) return false;
        boolean[] visited = new boolean[n];
        boolean[][] connected = new boolean[n][n];

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            connected[from][to] = true;
            connected[to][from] = true;
        }

        dfs(0, visited, connected);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    private void dfs(int start, boolean[] visited, boolean[][] connected) {
        int n = visited.length;
        if (!visited[start]) {
            visited[start] = true;
            for (int i = 0; i < n; i++) {
                if (connected[start][i] && !visited[i])
                    dfs(i, visited, connected);
            }
        }
    }
}
