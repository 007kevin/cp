
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1772d
 * Date       = Sun Sep  8 13:34:40 PDT 2024
 */
public class cf1772d {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      int[] a = new int[n];
      for(int i = 0; i < n; ++i)
        a[i]=in.nextInt();
      if (isSorted(a)){
        out.println(0);
        continue;
      }
      if (isRevSorted(a)){
        out.println(a[0]);
        continue;
      }
      int low=0,high=100000000;
      for(int i = 0; i < n-1; ++i){
        //out.println(low + " " +  high);
        if (a[i] == a[i+1]){
          continue;
        }
        if (a[i] < a[i+1]){
          high = Math.min(high, (a[i] + a[i+1])/2);
        }
        if (a[i] > a[i+1]){
          low = Math.max(low, ceil(a[i] + a[i+1], 2));
//          high = Math.min(high, a[i]);
        }
      }
      if (low > high)
        out.println(-1);
      else
        out.println(low);
    }
  }

  int ceil(int a, int b){
    int r = a/b;
    if (a%b!=0) r++;
    return r;
  }

  boolean isSorted(int[] a){
    for(int i = 0; i < a.length-1; ++i){
      if (a[i] > a[i+1])
        return false;
    }
    return true;
  }

  boolean isRevSorted(int[] a){
    for(int i = 0; i < a.length-1; ++i){
      if (a[i] < a[i+1])
        return false;
    }
    return true;
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
  void main(String[]args){cf1772d t=new cf1772d();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
