import java.util.*;
public class toposort
{
	static int v;
	static LinkedList<Integer>[] adjlist;
	@SuppressWarnings("unchecked")
	toposort(int v)
	{
		toposort.v=v;
		adjlist=new LinkedList[v];
		for(int i=0;i<v;i++)
			adjlist[i]=new LinkedList<>();
	}
	static void addedge(int v,int w)
	{
		adjlist[v].add(w);
	}
	static void topoutil(int v,Stack<Integer> stack,boolean[] visited)
	{
		visited[v]=true;
		for(int nei:adjlist[v])
			if(!visited[nei])
				topoutil(nei,stack,visited);
		stack.push(v);
	}
	static void topo()
	{
		Stack<Integer> stack=new Stack<>();
		boolean[] visited=new boolean[v];
		Arrays.fill(visited, false);
		for(int i=0;i<v;i++)
			if(!visited[i])
				topoutil(i,stack,visited);
		System.out.println("Topological Sort:");
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of vertices:");
		int v=sc.nextInt();
		toposort sort=new toposort(v);
		System.out.println("Enter adjacent list:");
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(sc.nextInt()==1)
					adjlist[i].add(j);
			}
		}
		sort.topo();
		sc.close();
	}
}