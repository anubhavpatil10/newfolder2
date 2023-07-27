package sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void seletionSort(int []arr)
	{
		int temp;
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i; j<arr.length; j++)
			{
				if(arr[i]>arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {

		int [] arr = {2,5,4,6,1,3};
		System.out.println("Array Before sort : ");
		System.out.println(Arrays.toString(arr));
		seletionSort(arr);
		System.out.println("Array After sort : ");
		System.out.println(Arrays.toString(arr));


	}

}
