import java.util.*;
public class djikstras
{
	static int[] d;
	static int[] p;
	static int[][] a;
	static int[] visited;
	static void djikstra(int s,int n)
	{
		for(int i=0;i<n;i++)
		{
			d[i]=Integer.MAX_VALUE;
			p[i]=-1;
			visited[i]=0;
		}
		d[s]=0;
		int u,v,j,min;
		int k=1;
		while(k<n)
		{
			min=Integer.MAX_VALUE;
			u=-1;
			for(j=0;j<n;j++)
			{
				if(visited[j]==0&&d[j]<min)
				{
					min=d[j];
					u=j;
				}
			}
			if(u==-1)
				break;
			visited[u]=1;
			
			for(v=0;v<n;v++)
			{
				if(a[u][v]!=0&&visited[v]==0)
				{
					if(d[v]>d[u]+a[u][v])
					{
						d[v]=d[u]+a[u][v];
						p[v]=u;
					}
				}
			}
		}
		display(s,n);
	}
	static void path(int s,int v)
	{
		if(p[v]!=-1)
			path(s,p[v]);
		if(v!=s)
			System.out.print("->"+v);
	}
	static void display(int s,int n)
	{
		for(int i=0;i<n;i++)
		{
			if(i!=s)
			{
				System.out.print("Shortest path from "+s+" to "+i+":"+s);
				path(s,i);
				System.out.print(":"+d[i]);
				System.out.println();
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no. of vertices:");
		int n=sc.nextInt();
		a=new int[n][n];
		p=new int[n];
		d=new int[n];
		visited=new int[n];
		System.out.println("Enter weighted graph:");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		System.out.println("Enter source vertice:");
		int s=sc.nextInt();
		djikstra(s,n);
		sc.close();
	}
}