
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoDrought
 * Date       = Tue Sep 10 21:52:45 PDT 2024
 */
public class usacoDrought {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt() + 2;
      long[] h = new long[n];
      for(int i = 1; i < n-1; ++i)
        h[i]=in.nextInt();
      out.println(solve(n,h));
    }
  }

  long solve(int n, long[] h){
    long feed = 0;
    // print(h);
    // out.println("-----------");
    for(int i = 1; i < n-2; ++i){
      if (h[i] < h[i+1]){
        long diff =h[i+1]-h[i];
        h[i+1]-=diff;
        h[i+2]-=diff;
        feed+=2L*diff;
      }
      //print(h);
    }
    //out.println("-----------");
    for(int i = n-2; i > 1; --i){
      if (h[i-1] > h[i]){
        long diff = h[i-1]-h[i];
        h[i-1]-=diff;
        h[i-2]-=diff;
        feed+=2L*diff;
      }
      //print(h);
    }
    return anyNeg(h) ? -1 : feed;
  }

  boolean anyNeg(long[] h){
    for(long v : h)
      if (v < 0)
        return true;
    return false;
  }

  void print(int[] h){
    for(int v : h)
      out.print(v + " ");
    out.println();
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
  void main(String[]args){usacoDrought t=new usacoDrought();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
