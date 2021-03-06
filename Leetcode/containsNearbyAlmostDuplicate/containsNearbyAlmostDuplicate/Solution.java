package containsNearbyAlmostDuplicate;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i =0; i < nums.length; i ++)
            for(int j = i+1; j < nums.length && j <= i+k+1; j++)
                if(isDone(nums, k, t, i, j))
                    return true;
        return false;
    }
    boolean isDone(int[] nums, int k, int t, int i, int j){
        if(abs((double)nums[i]-nums[j]) <= t && abs((double)i-j) <= k)
            return true;
        return false;
    }
    double abs(double a){
    	return a > 0 ? a : -a;
    }
    public static void main(String[] args){
    	System.out.println(Integer.MAX_VALUE);
    	System.out.println(Integer.MIN_VALUE);
    	//int[] a= {-1,2147483647};
    	int[] a= {2147483647,-2147483647};
    	int k = 1;
    	int t = 2147483647;
    	Solution sol = new Solution();
    	System.out.println(sol.containsNearbyAlmostDuplicate(a, k, t));
    }
}
