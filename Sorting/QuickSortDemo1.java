package sorting;

public class QuickSortDemo1 {
	public static int[] quickSort(int a[]){
		quick(a,0,a.length-1);
		return a;
	}
	
	protected static void quick(int a[],int low,int up){
		int left = low;
		int right = up;
		int piv = low;//at beginning pivot is a[0]
		boolean pivot_placed=false;
		if(low>=up)
			return;
		
		while(pivot_placed==false){
			/*Right to left i.e toward pivot*/
			while(a[piv]<=a[right] && piv!=right){
				right = right-1;
			}
			if(piv==right)
				pivot_placed = true;
			
			if(a[piv]>a[right]){
				int temp = a[piv];
				a[piv]=a[right];
				a[right] = temp;
				piv = right;
			}
			
			while(a[piv]>=a[left]&&left!=piv)
				left = left+1;
			
			if(piv==left)
				pivot_placed = true;
			
			if(a[piv]<a[left]){
				int temp = a[piv];
				a[piv] = a[left];
				a[left] = temp;
				piv = left;
			}
		}
		
		quick(a,low,piv-1);
		quick(a,piv+1,up);
		
	}
	
	public static void main(String[] args) {
		int arr[] = {23, 324,345, 234, 643,245};
		System.out.print("\nUnsorted arry: ");
		display(arr);
		int a[] = QuickSortDemo1.quickSort(arr);
		System.out.print("\nSorted Array using Quick sort: ");
		display(a);
		//Integer ;
		
	}
	public static void display(int a[]){
		System.out.println();
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}	
}
