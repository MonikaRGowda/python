import java.util.*;
public class kruskalmst
{
	static int n;
	static int[] parent;
	static int find(int m)
	{
		int p=m;
		while(parent[p]!=0)
			p=parent[p];
		return p;
	}
	static void union(int i,int j)
	{
		if(i!=j)
			parent[j]=i;
	}
	@SuppressWarnings("unused")
	static void kruskal(int[][] w)
	{
		int i,j,u,v,min;
		int k=1,sum=0;
		while(k<n)
		{
			u=-1;
			v=-1;
			min=Integer.MAX_VALUE;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					if(find(i)!=find(j)&&i!=j&&w[i][j]<min)
					{
						min=w[i][j];
						u=i;
						v=j;
					}
				}
			}
			int rootu=find(u);
			int rootv=find(v);
			if(rootu!=rootv)
			{
				union(rootu,rootv);
				sum += w[u][v];
				System.out.println("("+u+","+v+")="+w[u][v]);
				k++;
			}
			w[u][v]=w[v][u]=Integer.MAX_VALUE;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no. of vertices:");
		n=sc.nextInt();
		int graph[][]=new int[n][n];
		System.out.println("Enter weighted graph:");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				graph[i][j]=sc.nextInt();
		parent=new int[n];
		kruskal(graph);
		sc.close();
	}
}