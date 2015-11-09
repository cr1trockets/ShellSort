/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shellsort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Aust1_000
 */
public class Mod4ShellSort {

    static int charCount;
    
    private static char[] data;

      private int len;

      public Mod4ShellSort(int max) {
        data = new char[max];
        len = 0;
      }

     

      public void display(char[] f) {
        System.out.print("Output: ");
        for (int j = 0; j < charCount; j++)
          System.out.print(f[j]);
        
      }

      public void shellSort() {
        int left, right;
        char temp;
        //find initial value of h
        int h = 1;
        while (h <= len / 3)
          h = h * 3 + 1; // increase h to be the proper size compared to the array

        while (h > 0) // decreasing h until h eventually gets to 1
        {
          // h-sort
          for (right = h; right < len; right++) {
            temp = data[right];
            left = right;
            // one pass per increment of h
            while (left > h - 1 && data[left - h] >= temp) {
              data[left] = data[left - h];
              left -= h;
            }
            data[left] = temp;
          }
          h = (h - 1) / 3; // decrease h
        }
      }

      public static void main(String[] args) {
        int size = 100;
        Mod4ShellSort shellArray = new Mod4ShellSort(size);

        data = shellArray.getFileContents("tiny.txt");
        shellArray.len = charCount;

        shellArray.display(data);
        shellArray.shellSort();
        shellArray.display(data);
        }
       
      
      public static char[] getFileContents(String fileName)
  {
        

        // This will reference one line at a time
        String line = null;
        ArrayList<String> stringList = new ArrayList<String>();
        char[] shellArray = new char[100];
         charCount = 0;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            
            int r;  
            
            while ((r = bufferedReader.read()) != -1) {
            shellArray[charCount] = (char) r;
            charCount++;
            
        } 
            
            

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            
        }
      return shellArray;
  }
      }
    