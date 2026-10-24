class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] ==2){
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1){
                    fresh++;
                }           
            }
        }
        int [] dr = {-1, 1,0, 0};
        int [] dc = {0, 0, -1, 1};

        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();

            for(int i=0; i<size; i++){
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for(int d=0; d<4; d++){
                    int nr = r + dr[d];
                    int nc = c+ dc[d];

                    if(nr >= 0 && nr < m &&
                       nc >= 0 && nc < n &&
                       grid[nr][nc] == 1){

                        grid[nr][nc] =2;
                        fresh--;
                        queue.offer(new int[]{nr, nc});
                       }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;

        
    }
}