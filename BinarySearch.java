package sorting;

public class BinarySearch {
public static int binarysearch(int[]arr,int data) {
	int low =0;
	int high=arr.length-1;
	while(low<=high) {
		int mid=(high+low)/2;
		if(data==arr[mid]) {
			return mid;
			
		}
		else if(data<arr[mid]) {
			high =mid-1;
		}
		else {
			low=mid+1;
		}
	}
	return -1;
}
	public static void main(String[] args) {
		
int[] arr= {1,2,3,4,5,6,7,8};
System.out.println(binarysearch(arr,8));
	}

}
