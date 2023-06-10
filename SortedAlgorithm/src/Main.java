import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void insertion_sort(int arr[], String words[][])
	{
		int n = arr.length;
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
              
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
        /*for (int i = 0; i < arr.length; i++) {
        	for (int j = 0; j < words.length; j++) {
				if(arr[i]== Integer.parseInt(words[j][2])) {
					for (int k = 0; k < 3; k++) {
						System.out.print(words[j][k] + " ");
					}
					System.out.println();
				}
			}
		}*/
	}
	
	public static void merge_sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            merge_sort(arr, l, m); 
            merge_sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        }
        
        
    }
	
	public static void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }



	public static void main(String[] args) throws IOException {
		
		
		int count=0;
		
		Scanner file1 = new Scanner(new File("student.txt"));//read file
		while (file1.hasNextLine()) {
			if(file1.nextLine()!=null) {
				count++;
			}
			
		}
		file1.close();
		
		String[] line=new String[count];
		String[][] words = new String[count-1][3];
		int[] numbers=new int[count-1];
		int n=0;
		
		Scanner file2 = new Scanner(new File("student.txt"));//read file
		while (file2.hasNextLine()) {
			line[n] = file2.nextLine();
			n++;
			}
			//System.out.println(line[25]);
		
			file2.close();
			
			for(int i=0;i<line.length-1;i++) {
				words[i] =line[i+1].split(",");
			}
			
			
			for(int i=0;i<line.length-1;i++) {
				numbers[i]=Integer.parseInt(words[i][2]);
			}
			
			
			insertion_sort(numbers,words);
			
			//merge_sort(numbers,0,numbers.length-1);
			
			
			for (int i = 0; i < numbers.length; i++) {
	        	for (int j = 0; j < words.length; j++) {
					if(numbers[i]== Integer.parseInt(words[j][2])) {
						for (int k = 0; k < 3; k++) {
							System.out.print(words[j][k] + " ");
						}
						System.out.println();
					}
				}
			}
	}

}
