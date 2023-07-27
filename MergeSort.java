package sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static void mergeSort(int[] arr, int left, int right)
	{
		//end condition
		if(left>=right)
			return;
		
		//make 2 partition
		int mid = (left + right)/2;
		
		//sort left partition
		mergeSort(arr, left, mid);
		
		//sort right partition
		mergeSort(arr, mid+1, right);
		
		//take temp array
		int [] temp = new int[right - left +1];
		
		//add element in temp array
		int i=left, j=mid+1,k=0;
		while(i<=mid && j<=right)
		{
			if(arr[i]<arr[j])
			{
				temp[k]=arr[i];
				k++;
				i++;
			}
			else
			{
				temp[k]=arr[j];
				k++;
				j++;
			}
		}
		
		while(i<=mid)
		{
			temp[k++]=arr[i++];
		}
		
		while(j<=right)
		{
			temp[k++]=arr[j++];
		}
	
		
		for(i=0 ; i<temp.length ; i++)
		{
			arr[left+i] = temp[i];
			
		}
		
	}

	public static void main(String[] args) {

		int[] arr = {8,3,9,1,5,7,2,6,4};
		System.out.println("array before sorting : ");
		System.out.println(Arrays.toString(arr));
		
		mergeSort(arr, 0, arr.length-1);
		System.out.println("array after sorting : ");
		System.out.println(Arrays.toString(arr));

	}

}
