package sorting;
/* MERGE SORT 
 * it merge two sorted array into a sorted array
 */

public class MergeSortDemo1 {
	public static int[] mergeSort(int a[],int b[]){
		int length1 = a.length;
		int length2 = b.length;
		int length3 = length1+length2;
		int c[] = new int[length3];
		int i=0,j=0,k=0;
		
		while(i<length1 && j<length2){
			if(a[i]<b[j]){
				c[k] = a[i];
				i++;
			}
			else{
				c[k] = b[j];
				j++;
			}
			k++;
		}
		//add the remaining element of a
		while(i<length1){
			c[k] = a[i];
			k++;i++;
		}
		//add the remaining element of b
		while(j<length2){
			c[k]= b[j];
			k++;j++;
		}
		return c;
	}
	public static void main(String[] args) {
		int a[] = {12,23,34,45,56,65};
		int b[] = {13,24,25,34,54,66,67,89,97};
		System.out.print("\nSorted Array1: ");
		display(a);
		System.out.print("\n\nSorted Array2: ");
		display(b);
		System.out.print("\n\nAfter merge of sorted arrays: ");
		int c[] = mergeSort(a, b);
		display(c);

	}
	public static void display(int a[]){		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}
