import java.util.*;
public class horspool
{
	static Map<Character,Integer> buildtable(String pattern)
	{
		int m=pattern.length();
		Map<Character,Integer> shifttable=new HashMap<>();
		for(char i=0;i<256;i++)
			shifttable.put(i, m);
		for(int i=0;i<m;i++)
			shifttable.put(pattern.charAt(i), m-i-1);
		return shifttable;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter text:");
		String text=sc.nextLine();
		System.out.print("Enter pattern:");
		String pattern=sc.nextLine();
		int n=text.length();
		int m=pattern.length();
		Map<Character,Integer> shifttable=buildtable(pattern);
		int i=m-1;
		boolean found=false;
		while(i<n)
		{
			int k=0;
			while(k<m&& pattern.charAt(m-1-k)==text.charAt(i-k))
				k++;
			if(k==m)
			{
				found=true;
				break;
			}
			else
			{
				char mis=text.charAt(i);
				int shift=shifttable.getOrDefault(mis, m);
				i+=shift;
			}
		}
		if(found)
			System.out.println("Pattern found at "+(i-m+1));
		else
			System.out.println("Pattern not found");
		sc.close();
	}
}