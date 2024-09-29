

import java.io.*;
import java.util.*;

/**
 * Problem    = cf1826d
 * Date       = Fri Sep 20 12:58:31 PDT 2024
 */
public class cf1826d {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      int[] b = new int[n];
      for(int i = 0; i < n; ++i)
        b[i]=in.nextInt();
      out.println(solve(n,b));
    }
  }

  int solve(int n, int[] b){
    int[] left = b.clone();
    int[] right = b.clone();
    int d = 1;
    for(int i = 1; i < n; ++i)
      right[i]-=d++;
    d = 1;
    for(int i = n-2; i >= 0; --i)
      left[i]-=d++;
    // print(left);
    // print(right);
    for(int i = 1; i < n; ++i) left[i]=Math.max(left[i],left[i-1]);
    for(int i = n-2; i >=0; --i) right[i]=Math.max(right[i],right[i+1]);
    // print(left);
    // print(right);
    int ans = 0;
    for(int i = 1; i < n-1; ++i){
      int mid = b[i];
      int maxLeft = left[i-1] + i;
      int maxRight = right[i+1] + (n-i-1);
//      out.println(String.format("%d: {%d,%d,%d} / %d, %d", i, maxLeft,mid,maxRight, i, (n-i-1)));
      ans = Math.max(ans, maxLeft + mid + maxRight);
    }
    return ans;
  }

  void print(int[] a){
    StringJoiner joiner = new StringJoiner(",", "{", "}");
    for(int x : a)
      joiner.add(String.valueOf(x));
    out.println(joiner);
  }

  /////////////////////////////////////////////////////////////////////////////////
  static InputStream in(){try{if(file!=null)return new FileInputStream(file+".in");
  return System.in;}catch(Exception e){throw new RuntimeException(e);}}static
  OutputStream out(){try{if(file!=null)return new FileOutputStream(file+".out");
  return System.out;}catch(Exception e){throw new RuntimeException(e);}}IR in=new
  IR(in());PrintWriter out=new PrintWriter(out());void c(){out.close();}static
  class IR{BufferedReader r;StringTokenizer t=null;IR(InputStream s){r=new
  BufferedReader(new InputStreamReader(s),32768);}boolean p(){while(t==null||
  !t.hasMoreTokens()){try{String l=r.readLine();if(l==null)return false;t=new
  StringTokenizer(l);}catch(IOException e){throw new RuntimeException(e);}}return
  true;}boolean hasNext(){return p();}String next(){p();return t.nextToken();}int
  nextInt(){return Integer.parseInt(next());}long nextLong(){return Long.parseLong(
  next());}double nextDouble(){return Double.parseDouble(next());}}public static
  void main(String[]args){cf1826d t=new cf1826d();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
