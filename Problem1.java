// Time Complexity : O(N), N is grid size
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


// Your code here along with comments explaining your approach

class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int R = grid.length;
        int C = grid[0].length;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j}); //add rotten to queue
            }
        }

        int[] dx = {-1,0,1,0}; //4 directions
        int[] dy = {0,-1,0,1};
        int count = 0;

        while(!queue.isEmpty()){
            int N = queue.size();

            for(int i=0;i<N;i++){ //level order traversal
                int[] curr =  queue.poll();
                int x = curr[0];
                int y = curr[1];
                for(int j=0;j<4;j++){
                    int nx = x+dx[j];
                    int ny = y+dy[j];
                    if(nx>=0 && ny>=0 && nx<R && ny<C && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
            if(!queue.isEmpty()) //only increment when there are fresh oranges for next traversal
                count++;
        }


        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) //return if new fresh oranges encountered
                    return -1;
            }
        }

        return count;
    }
}