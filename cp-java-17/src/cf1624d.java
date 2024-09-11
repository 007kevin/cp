
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1624d
 * Date       = Sat Sep  7 10:29:32 PDT 2024
 */
public class cf1624d {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int[] c = new int[256];
      int n = in.nextInt();
      int k = in.nextInt();
      var str = in.next();
      for(int i = 0; i < n; ++i){
        c[str.charAt(i)]++;
      }
      int s = 0;
      int e = 0;
      for(int cnt : c){
        s+=cnt%2;
        e+=cnt/2;
      }
      int l = 0, r = n;
      int ans = 1;
//      System.out.println(String.format("evens: %d, singles: %d", e, s));
      while(l <= r){
        int m = (l+r)/2;
        int a = s, b = e;
        int cnt = 0;
        if (m==1){
          cnt = n;
        } else {
          while(cnt < k){
            if (m%2 == 1 && b > 0 && a == 0){
              b--;
              a+=2;
            }
            if (b - m/2 < 0) break;
            if (a - m%2 < 0) break;
            b-=m/2;
            a-=m%2;
            cnt++;
          }
        }
  //      System.out.println(m + "=>" + cnt);
        if (cnt >= k){
          l = m+1;
          ans = Math.max(ans, m);
        } else {
          r = m-1;
        }
      }
      out.println(ans);
    }
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
  void main(String[]args){cf1624d t=new cf1624d();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
