package sorting;
/* BUBBLE SORT
 * It behave differently in best or worst case. Best Case = O(n) and worst case = O(n2)
 * 
 */
public class BubbleSortDemo1 {
	public static int[] bubbleSort(int a[]){
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length-1;j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		int arr[] = {2365, 324,345, 234, 643,245};
		System.out.print("\nUnsorted arry: ");
		display(arr);
		System.out.print("\nAfter Bubble sort: ");
		int a[] = bubbleSort(arr);
		display(a);
	}
	public static void display(int a[]){		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}
