
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1668d
 * Date       = Sat Nov  9 13:11:20 PST 2024
 */
public class cf1668d {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      int m = in.nextInt();
      long a = in.nextLong();
      long b = in.nextLong();
      long[] f = new long[m];
      for(int i = 0; i < m; ++i)
        f[i]=in.nextInt();
      Arrays.sort(f);
      int left = 1;
      int right = (int) Math.abs(a-b) - 1;
      int ans = 0;
      while(left <= right){
        int mid = (left+right)/2;
        int len = Math.min(mid, m);
        long[] cand = new long[len];
        for(int i = 0; i < len; ++i)
          cand[i]=f[i];
        long time = 1;
        for(int i = len-1; i >= 0; --i){
          cand[i]+=time;
          time++;
        }
        long total = Math.abs(a-b) - 1 + run(n,a,b);
        boolean possible = true;
        for(int i = 0; i < len; ++i)
          if (cand[i] > total){
            possible = false;
            break;
          }
        if (possible){
          ans = mid;
          left = mid + 1;
        } else
          right = mid-1;

      }
      out.println(ans);
    }
  }

  long run(int n, long a, long b){
    if (a < b)
      return a;
    return n - a+1;
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
  void main(String[]args){cf1668d t=new cf1668d();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
