import java.util.*;
public class prims
{
	public static void main(String[] args)
	{
		int u = 0,v = 0,sum=0,min;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no. of vertices:");
		int n=sc.nextInt();
		int graph[][]=new int[n][n];
		System.out.println("Enter weighted graph:");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				graph[i][j]=sc.nextInt();
		int sol[]=new int[n];
		for(int i=0;i<n;i++)
			sol[i]=0;
		System.out.println("Enter source vertice:");
		int s=sc.nextInt();
		sol[s]=1;
		int k=1;
		while(k<n)
		{
			min=Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(sol[i]==1&&sol[j]==0&&i!=j&&graph[i][j]<min)
					{
						min=graph[i][j];
						u=i;
						v=j;
					}
				}
			}
			sol[v]=1;
			sum+=min;
			System.out.println(u+"->"+v+"="+min);
			k++;
		}
		System.out.println("Cost of minimum spanning tree:"+sum);
		sc.close();
	}
}