import java.util.*;
public class quicksort
{
	static void qsort(int low,int high,int[] arr)
	{
		if(low<high)
		{
			int pi=partition( low,high, arr);
			qsort(low,pi-1,arr);
			qsort(pi+1,high,arr);
		}
	}
	static int partition(int low,int high,int[] arr)
	{
		int i=low-1;
		int pivot=arr[high];
		for(int j=low;j<high;j++)
		{
			if(arr[j]<pivot)
			{
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[high];
		arr[high]=arr[i+1];
		arr[i+1]=temp;
		return i+1;
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
		qsort(0,arr.length-1,arr);
		double end=System.nanoTime();
		System.out.println("Sorted Array:"+Arrays.toString(arr));
		System.out.println("Execution time:"+(end-start)+"ns");
		sc.close();
	}
}