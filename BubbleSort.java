package sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSort(int[] arr)
	{
		int temp;
		for(int i=0 ; i<arr.length-1; i++)
		{
			for(int j=0; j<arr.length-1-i; j++)
			{
				if(arr[j]>arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	
	
	public static void main(String[] args) {

		int [] arr = {2,5,4,6,1,3};
		System.out.println("Array Before sort : ");
		System.out.println(Arrays.toString(arr));
		System.out.println("===================================");
		bubbleSort(arr);
		System.out.println("Array After sort : ");
		System.out.println(Arrays.toString(arr));


	}

}
