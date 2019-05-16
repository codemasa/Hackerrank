import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CommonSubstring{

  public static int LCS(String s1, String s2){
    int n = s1.length();
    int m = s2.length();
    // Instantiate Lookup
    int[][] lookup = new int[n+1][m+1];
    // Traverse both strings
    for (int i = 1 ; i < n+1 ; i++ ){
      for (int j = 1 ; j < m+1 ; j++ ){
        if(s1.charAt(i-1) == s2.charAt(j-1)){
          lookup[i][j] = lookup[i-1][j-1] + 1;
        }
        else{
          lookup[i][j] = Math.max(lookup[i-1][j], lookup[i][j-1]);
        }

      }
    }
    return lookup[n][m];

  }

  public static void main(String[] args){
    int length = LCS("asd","asd");
    System.out.println("LCS length is: " + length);
  }
}
