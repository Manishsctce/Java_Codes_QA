package zzJavaObjective;
import java.util.Arrays;

//Remove duplicate element from array
//merge two integer array

public class ArrayQuestion1 {
	public static void main(String args[]){
	 //int a[] = {1,2,5,3,6,4,6,7,8,2,3};
	 //int b[] = {2,6,34,12,5,7,8,38,9,1};
	 
	 //int a[] ={1,2,3,4,5};
		
	int a[] = {1,1,1,1,1,2,2,3,4,5,5,6,6,6,7,8,9,9,9,9,9,9};	
	 int b[] ={5,6,7,8,9};
	 
	 System.out.println("Merge array: ");
	 display(merge(a, b));
	 
	 System.out.println();
	 
	 System.out.println("After removing duplicated");
	 display(removeDuplicate(a));
	}
	static int[] sorting(int a[]){
		int f[] = new int[a.length];
		
		for(int i=0;i<a.length;i++){
			//for()
		}
		
		return f;
	}
	
	static int[] removeDuplicate(int a[]){
		int f[] = new int[1];
		
		boolean flag = false;
		
		for(int i=0, j=0;i<a.length - 1;i++){
			if(a[i]==a[i+1]){
				if(flag == false){
					flag = true;
					f[j] = a[i]; j++;
					f = Arrays.copyOf(f, f.length+1);
				}
			}
			else{
				if(flag==true){
					flag= false;
				}
				else{
					f[j] = a[i]; j++;
					f = Arrays.copyOf(f, f.length+1);
				}
			}
		}
		return f;
	}
	static int[] merge(int a[],int b[]){
		int l1 = a.length;
		int l2 = b.length;
		int f[] = new int[l1+l2];		
		for(int i=0,j=0; i<(l1+l2); i++){			
			if(i<l1 ){
				f[i] = a[i]; 
			}
			else{
				f[i] = b[j];
				j++;
			}				
		}
		return f;
	}
	
	public static void display(int temp[]){
		System.out.println();
		for(int i=0;i<temp.length;i++){
			System.out.print(temp[i]);
		}
	}
}
