public class travel
{
	static int[][] graph= {{0,5,2,8},
					{5,0,7,3},
					{2,7,0,1},
					{8,3,1,0}};
	static int n=4;
	static int memo[][]=new int[n][1<<n];
	static int tsp(int i,int mask)
	{
		if(mask==(1<<n)-1)
			return graph[i][0];
		if(memo[i][mask]!=0)
			return memo[i][mask];
		int min=Integer.MAX_VALUE;
		for(int j=0;j<n;j++)
		{
			if((mask&(1<<j))==0)
				min=Math.min(min, tsp(j,mask|(1<<j))+graph[i][j]);
		}
		return memo[i][mask]=min;
	}
	public static void main(String[] args)
	{
		System.out.println("Tsp cost:"+tsp(0,1));
	}
}