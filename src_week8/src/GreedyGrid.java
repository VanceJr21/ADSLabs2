public class GreedyGrid {

    public static void main(String[] args) {

        // the maze we're using
        int  maze [][] = {
                {1,7,2,1},
                {3,5,6,2},
                {14,8,3,3},
                {48,2,1,5}
        };

        System.out.println("Max reward is: " + calculateMaxReward(maze, 4, 4));
    }

    /**
     * Greedy function to calculate max reward
     * @param maze - The maze array
     * @param m - the number of rows
     * @param n - number of columns
     * @return - max reward
     */
    public static int calculateMaxReward(int maze[][], int m, int n){

        //keep track of the total
        int total = 0;

        // current row and column
        int r = 0, c = 0;

        while(r != m-1 || c != n-1){
            total += maze[r][c];

            System.out.println(r + ", " + c+ ": "+ total);

            // go up if you reach the far right square
            if (r == m-1){
                c++;
            }

            //go right if you reach the top square
            else if (c == n-1){
                r++;
            }

            // decide whether to go right  or up
            else if (maze[r+1][c] > maze[r][c+1]){
                r++;
            } else {
                c++;
            }

        }
        
        System.out.println((m-1) + ", " + (n-1));
        //add the final square
        return total += maze[m-1][n-1];

    }
}
