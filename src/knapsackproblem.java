public class knapsackproblem
{
	static int knapsack(int W,int[] wt,int[] val,int n)
	{
		if(n==0||W==0)
			return 0;
		if(wt[n-1]>W)
			return knapsack( W, wt, val, n-1);
		return Math.max(knapsack( W, wt, val, n-1),(val[n-1]+ knapsack( W-wt[n-1], wt, val, n-1)));
	}
	public static void main(String[] args)
	{
		int[] wt= {10,20,30,50};
		int[] val= {400,700,100,600};
		int W=70;
		System.out.println("Knapsack value:"+knapsack( W, wt, val, val.length));
	}
}