class Solution {
  public:
    int shortestPath(vector<vector<int>> &mat) {
        int n = mat.size();
        int m = mat[0].size();

        vector<vector<int>> unsafe(n, vector<int>(m, 0));

        int dr[4] = {-1, 1, 0, 0};

        int dc[4] = {0, 0, -1, 1};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] == 0) {
                    unsafe[r][c] = 1;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                            unsafe[nr][nc] = 1;
                        }
                    }
                }
            }
        }

        vector<vector<int>> visited(n, vector<int>(m, 0));

        queue<tuple<int, int, int>> q;

        for (int r = 0; r < n; r++) {
            if (mat[r][0] == 1 && !unsafe[r][0]) {
                q.push({r, 0, 1});

                visited[r][0] = 1;
            }
        }

        while (!q.empty()) {
            auto [r, c, dist] = q.front();
            q.pop();

            if (c == m - 1) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    mat[nr][nc] == 1 &&
                    !unsafe[nr][nc] &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = 1;

                    q.push({nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
};