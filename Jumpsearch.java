package adsf;
// Andrew Tang
// Justin Patel
// Benjamin Byrd
    

import java.util.Arrays;
import java.util.Random;

public class Jumpsearch {



	public static int findIndexOfValue(int num, int i, int n){
		Random ran = new Random(); 
		int index = 0;
//		long starttime;
//		long endtime;
//		long totaltime;
		int[] arr = new int[n];
		int val = arr[index];

		for (int i1=0; i1 <arr.length; i1++){
			arr[i1] = ran.nextInt(n);
		}

		Arrays.sort(arr);

//		starttime = System.nanoTime();


		while(val <= num){
			index += i;
			if((index+i) > n){
				while(index < n){
					if(index == (n-1) && arr[index] != num){
//						endtime = System.nanoTime();
//						totaltime = endtime - starttime;
//						System.out.println("Jumpsearch time = " + totaltime);
						return -1;
					}
					if(arr[index] == num){
//						endtime = System.nanoTime();
//						totaltime = endtime - starttime;
//						System.out.println("Jumpsearch time = " + totaltime);
						return index;
					}
					index++;
				}
			}
			val = arr[index];
		}
		if(val == num) return index;
		index -= i;
		val = arr[index];
		while(val != num){
			if(index == arr.length-1){
//				endtime = System.nanoTime();
//				totaltime = endtime - starttime;
//				System.out.println("Jumpsearch time = " + totaltime);
				return -1;
			}
			index++;
			val = arr[index];
		}
//		endtime = System.nanoTime();
//		totaltime = endtime - starttime;
//		System.out.println("Jumpsearch time = " + totaltime);
//		System.out.println("Value= " + arr[index]);
		return index;
	}

	public static void main(String[]args){
		Random random = new Random();
		long starttime = System.nanoTime();
		for(int i = 0; i < 1000; i++){
			
			findIndexOfValue(random.nextInt((int)Math.pow(2, 15)), 3, (int)Math.pow(2, 15));
		}
		long endtime = System.nanoTime();
		System.out.println("Total time = " + (endtime-starttime));
	}

}
