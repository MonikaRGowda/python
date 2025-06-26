import java.util.*;
public class subset
{
	static int[] a;
	static boolean dp[][];
	static ArrayList<Integer> list;
	static boolean hasset(int sum,int n)
	{
		dp=new boolean[n+1][sum+1];
		for(int i=0;i<=n;i++)
			dp[i][0]=true;
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(j>=a[i-1])
					dp[i][j]=dp[i-1][j]||dp[i-1][j-a[i-1]];
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		if(dp[n][sum])
		{
			list=new ArrayList<>();
			int i=n;
			int j=sum;
			while(i>0&&j>0)
			{
				if(dp[i][j]!=dp[i-1][j])
				{
					list.add(a[i-1]);
					j-=a[i-1];
				}
				i--;
			}
			return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no. of elements:");
		int n=sc.nextInt();
		System.out.println("Enter elements:");
		a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		System.out.print("Enter sum:");
		int sum=sc.nextInt();
		boolean subset=hasset(sum,n);
		if(subset)
		{
			System.out.println("Subset present");
			System.out.println("Subset:"+list);
		}
		else
			System.out.println("Subset not present");
		sc.close();
	}
}