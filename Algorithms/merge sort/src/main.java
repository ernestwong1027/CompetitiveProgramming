import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = {2,9,6,4,3,2};
		mergeSort(a,0,5);
		for(int i =0; i<a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	static void merge(int[] a, int start, int mid, int end)
	{
		int p = start;
		int q = mid+1;
		int[] arr = new int[end-start+1];
		int k = 0;
		for(int i = start; i <=end; i++)
		{
			if(p>mid)
			{
				arr[k++] = a[q++];
			}
			else if(q>end)
			{
				arr[k++] = a[p++];
			}
			else if(a[p] < a[q])
			{
				arr[k++] = a[p++];
			}
			else
			{
				arr[k++] = a[q++];
			}
		}
		for(int i =0; i < k; i++)
		{
			a[start++] = arr[i];
		}
	}
	
	static void mergeSort(int[] a, int start, int end)
	{
		int mid = (start+end)/2;
		if(start<end)
		{
			
			mergeSort(a,start,mid);
			mergeSort(a,mid+1,end);
		}
		merge(a,start,mid,end);
	}

}
