package sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class arraysgen {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new FileReader(new File("testcases/arraystosort.in")));
		String line= br.readLine();
		int counter = 1;
		while(line != null) {
			String[] arr = line.split(" ");
			int[] nums= new int[arr.length];
			int[] originalArray = new int[arr.length];
			int[] originalArray2 = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				nums[i] = Integer.parseInt(arr[i]);
				originalArray[i] = Integer.parseInt(arr[i]);
				originalArray2[i] = Integer.parseInt(arr[i]);
			}
			String stepB = "";
			String stepI ="";
			String stepS = "";
			for (int i = 0; i < nums.length; i++) {
				stepB+= nums[i]+" ";
				stepI+= nums[i]+" ";
				stepS+= nums[i]+" ";
			}
			stepB +="\n";
			stepI +="\n";
			stepS +="\n";
			// BUBBLE
			for (int i = 0; i < nums.length-1; i++) {
				for (int j = 0; j < nums.length-1-i; j++) {
					if(nums[j] > nums[j+1]) {
						int temp = nums[j+1];
						nums[j+1]= nums[j];
						nums[j]= temp;
					}
				}
				for (int k = 0; k < nums.length; k++) {
					stepB += nums[k]+" ";
				}
				stepB+= "\n";
			}
			// INSERTION
			nums = originalArray;
			for (int i = 1; i < nums.length; i++) {	
				for (int j = i; j > 0; j--) {
					if(nums[j] < nums[j-1]) {
						int temp = nums[j];
						nums[j] = nums[j-1];
						nums[j-1] = temp;
					}
				}
				for (int k = 0; k < nums.length; k++) {
					stepI += nums[k]+" ";
				}
				stepI+= "\n";
			}
			// SELECTION
			nums = originalArray2;
			for (int i = 0; i < nums.length-1; i++) {
				int min = i;
				for (int j = i+1; j < nums.length; j++) {
					if(nums[j] < nums[min]) {
						min =j;
					}
				}
				int temp = nums[i];
				nums[i] = nums[min];
				nums[min] = temp;
				for (int k = 0; k < nums.length; k++) {
					stepS += nums[k]+" ";
				}
				stepS+= "\n";
			}
			BufferedWriter bwB = new BufferedWriter(new FileWriter("testcases/bubbleA-"+counter+".out"));
			bwB.write(stepB);
			bwB.close();
			
			BufferedWriter bwI = new BufferedWriter(new FileWriter("testcases/insertionA-"+counter+".out"));
			bwI.write(stepI);
			bwI.close();
			
			BufferedWriter bwS = new BufferedWriter(new FileWriter("testcases/selectionA-"+counter+".out"));
			bwS.write(stepS);
			bwS.close();
			
			counter++;
			line = br.readLine();
		}
		br.close();
	}
}
