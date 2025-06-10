
import java.io.*;
import java.util.*;

/**
 * Problem    = csesArrayDivision
 * Date       = Wed Oct 23 14:43:56 PDT 2024
 */
public class csesArrayDivision {

  public void run() {
    int n = in.nextInt();
    int k = in.nextInt();
    long[] x = new long[n];
    long sum = 0;
    for(int i = 0; i < n; ++i){
      x[i]=in.nextInt();
      sum+=x[i];
    }
//s    out.println(yes(x,k,8));

    long l = 1;
    long r = sum;
    long ans = 0;
    while(l <= r){
      long m = (l+r)/2;
      if(yes(x,k,m)){
        ans=m;
        r = m-1;
      } else
        l = m+1;
    }
    out.println(ans);
  }

  boolean yes(long[] x, int k, long m){
    long cur = 0;
    for(int i = 0; i < x.length; ++i){
      if (cur + x[i] > m){
        cur = x[i];
        k--;
      } else
        cur+=x[i];
      if (cur > m) return false;
//      out.println(cur + " " + k);
    }
    return k >= 1 && cur <= m;
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
  void main(String[]args){csesArrayDivision t=new csesArrayDivision();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
