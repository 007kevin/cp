
import java.io.*;
import java.util.*;

/**
 * Problem    = cf2051e
 * Date       = Sun Feb  9 10:23:19 PST 2025
 */
public class cf2051e {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      int k = in.nextInt();
      long[] a = new long[n];
      long[] b = new long[n];
      List<Long> c = new ArrayList<>(2*n);
      for(int i = 0; i < n; ++i){
        a[i]=in.nextLong();
        c.add(a[i]);
      }
      for(int i = 0; i < n; ++i) {
        b[i]=in.nextLong();
        c.add(b[i]);
      }
      Arrays.sort(a);
      Arrays.sort(b);
      long ans = 0;
      for(long p : c){
        long bought = bs(b, p);
        long positive = bs(a, p);
        //out.println(String.format("p=%d, bought=%d, positive=%d", p, bought, positive));
        if (bought - positive <= k){
          ans = Math.max(ans, p*bought);
        }
      }
      out.println(ans);
    }
  }

  long bs(long[] a, long p){
    int l = 0;
    int r = a.length - 1;
    int i = a.length;
    while(l<=r){
      int m = (l+r)/2;
      if (p <= a[m]){
        r = m-1;
        i = m;
      } else
        l = m+1;
    }
    return a.length - i;
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
  void main(String[]args){cf2051e t=new cf2051e();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
