/**
 * Created by xuan on 2017/7/3 0003.
 */
public class I515_Paint_house {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        // Write your code here
        int[][] minCosts = new int[costs.length][3];
        minCosts[0][0] = costs[0][0];
        minCosts[0][1] = costs[0][1];
        minCosts[0][2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            minCosts[i][0] = Math.min(minCosts[i-1][1], minCosts[i-1][2]) + costs[i][0];
            minCosts[i][1] = Math.min(minCosts[i-1][0], minCosts[i-1][2]) + costs[i][1];
            minCosts[i][2] = Math.min(minCosts[i-1][0], minCosts[i-1][1]) + costs[i][2];
        }
        return Math.min(Math.min(minCosts[costs.length-1][0], minCosts[costs.length-1][1]),
                minCosts[costs.length-1][2]);
    }
}
