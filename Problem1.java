/***************Sum of two elements equal to target**********/

// Time Complexity : 0(n) n=length of array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


//Intuition is to store all the seen index of elements in a hashmap and calculate the
//target - nums[index] at every index and get it from hashmap

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //base case
        if(nums.length==0|| nums==null){
            return new int[]{-1,-1};
        }

        HashMap<Integer,Integer> index=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer value=target-nums[i];
            if(index.containsKey(value)){
                return new int[]{index.get(value),i};
            }else{
                index.put(nums[i],i);
            }
        }

        return new int[]{-1,-1};
    }
}

/*******************************PROBLEM-2**************************/
// Time Complexity : exponential - 2^n
// Space Complexity : O(1)

/* recursive implementation of 0-1 Knapsack problem */
class Solution {

    // Returns the maximum value that can be put in a knapsack of capacity W
    public int knapsack(int[] weight, int index, int[] profit, int W) {
        // Base Case stop when index is out of bounds
        if (index == weight.length) {
            return 0;
        }
        //base case if the Weight exceeds the max Weight return only case 0
        if (weight[index] > W) {
            return knapsack(weight, index + 1, profit, W);
        }
        //logic when both case0 and case1 to be returned
        else {
            return Math.max(knapsack(weight, index + 1, profit, W),
                    knapsack(weight, index + 1, profit, W - weight[index]) + profit[index]);
        }
    }
}

//Implementation using the dp array - 2d
// Time Complexity : 0(m*n) m=lwngth of wt array, n=maxWeight W
// Space Complexity : O(m*n)


class Solution {
    public int knapSack(int W, int wt[], int val[])
        // Rows hold the weight given and columns hold the MaxWeight W
        int[][] dp = new int[wt.length+1][W+1];

        for(int i=1;i<wt.length+1;i++){
            for(int j=1;j<W+1;j++){
                //check the weight at the index 1 corresponding from wt array
                // to total weight in column
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        // Returning the maximum value of knapsack
        return dp[wt.length][W];
    }
}
