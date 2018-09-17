package sorting;
/* SELECTION SORT
 * it move the smallest element in array to the correct place
 * it behave same in best or worst case. its complexity is O(n2)
 * 
 */

public class SelectionSortDemo1 {
	public static int[] selectionSort(int a[]){
		for(int i=0;i<a.length-1;i++){
			int smallest = i;
			//find the smallest element
			for(int j=i+1;j<a.length;j++){
				if(a[smallest]>a[j]){
					smallest = j;
				}
			}
			//if pointer is not same then swap
			if(smallest != i){
				int temp = a[i];
				a[i] = a[smallest];
				a[smallest] = temp;
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		int arr[] = {2365, 324,345, 234, 643,245};
		System.out.print("\nUnsorted arry: ");
		display(arr);
		System.out.print("\nAfter selection sort: ");
		int a[] = selectionSort(arr);
		display(a);
	}
	
	public static void display(int a[]){		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
