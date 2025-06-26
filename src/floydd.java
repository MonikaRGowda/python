import java.util.*;
public class floydd
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no. of vertices:");
		int n=sc.nextInt();
		int[][] graph=new int[n][n];
		System.out.println("Enter elements:");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				graph[i][j]=sc.nextInt();
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					graph[i][j]=Math.min(graph[i][j],(graph[i][k]+graph[k][j]));
		System.out.println("Floydd algorithm:");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(graph[i][j]+" ");
			System.out.println();
		}
		sc.close();
	}
}