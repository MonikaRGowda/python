import java.util.*;
public class warshall
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of vertices:");
		int v=sc.nextInt();
		int[][] graph=new int[v][v];
		System.out.println("Enter adjacent list(in 1 and 0):");
		for(int i=0;i<v;i++)
			for(int j=0;j<v;j++)
				graph[i][j]=sc.nextInt();
		for(int k=0;k<v;k++)
			for(int i=0;i<v;i++)
				for(int j=0;j<v;j++)
					graph[i][j]=graph[i][j]|(graph[i][k]&graph[k][j]);
		System.out.println("Transitive closure:");
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
				System.out.print(graph[i][j]+" ");
			System.out.println();
		}
		sc.close();
	}
}