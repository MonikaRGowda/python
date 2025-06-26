import java.util.*;
public class bfs
{
	static LinkedList<Integer>[] adjlist;
	int v;
	@SuppressWarnings("unchecked")
	public bfs(int v)
	{
		this.v=v;
		adjlist=new LinkedList[v];
		for(int i=0;i<v;i++)
			adjlist[i]=new LinkedList<>();
	}
	void addedge(int v,int w)
	{
		adjlist[v].add(w);
	}
	void printbfs(int start)
	{
		LinkedList<Integer> queue=new LinkedList<>();
		boolean visited[]=new boolean[v];
		Arrays.fill(visited, false);
		queue.add(start);
		visited[start]=true;
		while(!queue.isEmpty())
		{
			start=queue.poll();
			System.out.print(start+" ");
			Iterator<Integer> iterator=adjlist[start].listIterator();
			while(iterator.hasNext())
			{
				int next=iterator.next();
				if(!visited[next])
				{
					visited[next]=true;
					queue.add(next);
				}
			}
		}
	}
	public static void main(String[] args)
	{
		bfs graph=new bfs(5);
		graph.addedge(0, 3);
		graph.addedge(0, 1);
		graph.addedge(1, 2);
		graph.addedge(4, 2);
		graph.addedge(3, 4);
		graph.printbfs(0);
	}
}