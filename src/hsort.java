import java.util.*;
public class hsort
{
	static void heapsort(int[] arr)
	{
		int n=arr.length;
		for(int i=n/2-1;i>=0;i--)
			heapify(i,n,arr);
		for(int i=n-1;i>=0;i--)
		{
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(0,i,arr);
		}
	}
	static void heapify(int i,int n,int[] arr)
	{
		int large=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n&&arr[left]>arr[large])
			large=left;
		if(right<n&&arr[right]>arr[large])
			large=right;
		if(large!=i)
		{
			int temp=arr[large];
			arr[large]=arr[i];
			arr[i]=temp;
			heapify(large,n,arr);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		System.out.print("Enter no. of elements:");
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=rand.nextInt(100);
		System.out.println("Array:"+Arrays.toString(arr));
		double start=System.nanoTime();
		heapsort(arr);
		double end=System.nanoTime();
		System.out.println("Sorted Array:"+Arrays.toString(arr));
		System.out.println("Execution Time:"+(end-start)+"ns");
		sc.close();
	}
}