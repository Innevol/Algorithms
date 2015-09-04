/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//Benjamin Byrd
//Justin Patel
//Andrew Tang
//CSC4520 - HW1 

//package array_search;
import java.util.*;
import java.math.*;

/**
 *
 * @author bebyrd
 */
public class Array_search {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random rn = new Random();
        int arraysize = (int) Math.pow(2,20); //get arraysize
        long starttime;
        long endtime;
        long rJ4, rJ3, rJ2; //timeslots for algos
        
        
        //generate an array 
        int[] random_array = new int[arraysize];
        for(int i=0; i<arraysize; i++){
            random_array[i] = rn.nextInt(1000)+1;
        }
        //sort array
        Arrays.sort(random_array);
        
        //for(int i=0; i<arraysize; i++)
        //    System.out.println("Array value at index "+i+": "+ random_array[i]);
       
        //test recJump4
        
        System.out.println("Testing recJump 4: 10000 repetitions");
        starttime = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            //System.out.println("Loop " + i);
            int searchlength = rn.nextInt(arraysize);
            //int searchlength = arraysize-1;
            //System.out.println("Searchlenght: " + searchlength);
            int searchnum = rn.nextInt(1000)+1;
            //System.out.println("Searchnum: "+ searchnum);
            int index = recJump4(random_array, searchnum, 0, searchlength);
            if(index < 0)
                System.out.println("num not found");
            else
                System.out.println("num index: "+index);
        }
        endtime = System.nanoTime();
        rJ4 = endtime-starttime;
        //test recJump3
        
        starttime = System.nanoTime();
        System.out.println("Testing recJump3 - 10000 repetitions");
        for(int i = 0; i < 10000; i++){
            //System.out.println("Loop " + i);
            int searchlength = rn.nextInt(arraysize);
            //int searchlength = arraysize-1;
            //System.out.println("Searchlenght: " + searchlength);
            int searchnum = rn.nextInt(1000)+1;
            //System.out.println("Searchnum: "+ searchnum);
            int index = recJump3(random_array, searchnum, 0, searchlength);
            if(index < 0)
                System.out.println("num not found");
            else
                System.out.println("num index: "+index);
        }
        endtime = System.nanoTime();
        rJ3 = endtime-starttime;
        
        starttime = System.nanoTime();
        //test recJump2
        System.out.println("Testing recJump2 - 10000 repetitions");
        for(int i = 0; i < 10000; i++){
            //System.out.println("Loop " + i);
            int searchlength = rn.nextInt(arraysize);
            //int searchlength = arraysize-1;
            //System.out.println("Searchlenght: " + searchlength);
            int searchnum = rn.nextInt(1000)+1;
            //System.out.println("Searchnum: "+ searchnum);
            int index = recJump4(random_array, searchnum, 0, searchlength);
            if(index < 0)
                System.out.println("num not found");
            else
                System.out.println("num index: "+index);
        }
        endtime = System.nanoTime();
        rJ2 = endtime - starttime;
        
        System.out.println();
        System.out.println("Time for recursive jump, k = 4: " + rJ4 + " ns");
        System.out.println("Time for recursive jump, k = 3: " + rJ3 + " ns");
        System.out.println("Time for recursive jump, k = 2: " + rJ2 + " ns");
                
    }
    
    public static int recJump2(int[] array, int key, int low, int high){
        //index of found number;
        // calculate midpoint to cut set in half
      //System.out.println("Key: " + key);
      //System.out.println("High: " + high);
      //System.out.println("Low: " + low);
      int part2 = low + (high-low)/2;
      if (high < low)
          return -1;
      else{
        //System.out.println(part2);
        // three-way comparison
        if (array[part2] > key)
        // key is in lower subset
           return recJump2(array, key, low+1, part2);
        else if (array[part2] < key)
            // key is in upper part
           return recJump2(array, key, part2, high-1);
        else
           // key has been found
           return part2;
      }
        
    }
    public static int recJump3(int[] array, int key, int low, int high){
        //index of found number;
        // calculate midpoint to cut set in half
      //System.out.println("Key: " + key);
      //System.out.println("High: " + high);
      //System.out.println("Low: " + low);
      int part2 = low + ((high-low)/3);
      int part3 = low + ((high-low)/3)*2;
      //System.out.println("part2: " + part2);
      //System.out.println("part3: " + part3);
      if (high < low)
          return -1;
      else{
        //System.out.println(part2);
        // three-way comparison
        if (array[part2] > key)
        // key is in lower subset
           return recJump3(array, key, low, part2-1);
        else if (array[part3] < key)
            // key is in upper part
           return recJump3(array, key, part3+1, high);
        else if (array[part2] < key && key < array[part3])
            //key is in middle part
           return recJump3(array, key, part2+1, part3-1);
        else if (array[part2] == key)
           // key has been found
           return part2;
        else
           return part3;
      }
        
    }
    public static int recJump4(int[] array, int key, int low, int high){
        //index of found number;
        // calculate midpoint to cut set in half
      //System.out.println("Key: " + key);
      //System.out.println("High: " + high);
      //System.out.println("Low: " + low);
      int part2 = low + ((high-low)/4);
      int part3 = low + ((high-low)/4)*2;
      int part4 = low + ((high-low)/4)*3;
      //System.out.println("part2: " + part2);
      //System.out.println("part3: " + part3);
      //System.out.println("part4: " + part4);
      if (high < low)
          return -1;
      else{
        //System.out.println(part2);
        // three-way comparison
        if (array[part2] > key)
        // key is in lower subset
           return recJump4(array, key, low, part2-1);
        else if (array[part4] < key)
            // key is in upper part
           return recJump4(array, key, part4+1, high);
        else if (array[part3] < key && key < array[part4])
            //key is in middle part
           return recJump4(array, key, part3+1, part4-1);
        else if (array[part2] < key && key < array[part3])
            //key is in middle part
           return recJump4(array, key, part2+1, part3-1);
        else if (array[part2] == key)
           // key has been found
           return part2;
        else if (array[part3] == key)
           // key has been found
           return part2;
        else
           return part4;
      }
        
    }
}

