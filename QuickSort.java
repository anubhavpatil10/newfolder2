package sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static void swap(int[] arr, int n1, int n2)
	{
		int temp = arr[n1];
		arr[n1]=arr[n2];
		arr[n2]=temp;
	}
	
	public static void quickSort(int[] arr, int left, int right)
	{
		//if partition having only one element or invalid partition
		if(left>=right)
			return;
		//consider left element is pivot element
		
		int i=left, j=right;
		
		while(i<j) 
		{
			while (i<right && arr[left] >= arr[i]) {
				i++;
			}

			while (arr[left] < arr[j]) {
				j--;
			}

			if (i < j)
				swap(arr, i, j);
		
		}
		swap(arr, left, j);
		quickSort(arr, left, j-1);
		quickSort(arr, j+1, right);
	}

	public static void main(String[] args) {

		int[] arr = {5,3,9,1,8,7,2,6,4};
		//int[] arr = {4,3,2,1};
		
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

}
