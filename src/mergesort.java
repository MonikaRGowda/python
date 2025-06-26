import java.util.*;
public class mergesort
{
	static void msort(int[] arr)
	{
		if(arr.length<=1)
			return;
		int mid=arr.length/2;
		int[] left=new int[mid];
		int[] right=new int[arr.length-mid];
		for(int i=0;i<mid;i++)
			left[i]=arr[i];
		for(int i=mid;i<arr.length;i++)
			right[i-mid]=arr[i];
		msort(left);
		msort(right);
		merge(left,right,arr);
	}
	static void merge(int[] left,int[] right,int[] arr)
	{
		int i=0,j=0,k=0;
		while(i<left.length&&j<right.length)
		{
			if(left[i]<right[j])
				arr[k++]=left[i++];
			else
				arr[k++]=right[j++];
		}
		while(i<left.length)
			arr[k++]=left[i++];
		while(j<right.length)
			arr[k++]=right[j++];
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
		msort(arr);
		double end=System.nanoTime();
		System.out.println("Sorted Array:"+Arrays.toString(arr));
		System.out.println("Execution Time:"+(end-start)+"ns");
		sc.close();
	}
}