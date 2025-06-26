import java.util.*;
public class dfs
{
	static int v;
	static LinkedList<Integer> adjlist[];
	@SuppressWarnings("unchecked")
	dfs(int v)
	{
		dfs.v=v;
		adjlist=new LinkedList[v];
		for(int i=0;i<v;i++)
			adjlist[i]=new LinkedList<>();
	}
	void addedge(int v,int w)
	{
		adjlist[v].add(w);
		adjlist[w].add(v);
	}
	void dfscheck(int i,boolean[] visited)
	{
		visited[i]=true;
		for(int nei:adjlist[i])
			if(!visited[nei])
				dfscheck(nei,visited);
	}
	public static void main(String[] args)
	{
		dfs graph=new dfs(5);
		graph.addedge(0,2);
		graph.addedge(1, 0);
		graph.addedge(1, 3);
		graph.addedge(3, 4);
		boolean[] visited=new boolean[v];
		graph.dfscheck(0, visited);
		boolean check=true;
		for(int i=0;i<v;i++)
			if(!visited[i])
				check=false;
		System.out.print("Graph connected:"+check);
	}
}