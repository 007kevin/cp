
import java.io.*;
import java.util.*;

/**
 * Problem    = csesSubarraySumsI
 * Date       = Sun Oct  6 12:50:00 PDT 2024
 */
public class csesSubarraySumsI {

  public void run() {
    int n = in.nextInt();
    long x = in.nextLong();
    long[] a = new long[n];
    for(int i =0 ; i < n; ++i)
      a[i]=in.nextLong();
    long sum = 0;
    int cnt = 0;
    int i = 0, j = 0;
    while(j < n){
      sum += a[j];
      while (sum > x)
        sum-=a[i++];
      if (sum == x) cnt++;
      j++;
    }
    out.println(cnt);
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
  void main(String[]args){csesSubarraySumsI t=new csesSubarraySumsI();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
