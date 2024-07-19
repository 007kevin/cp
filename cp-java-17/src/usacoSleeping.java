
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoSleeping
 * Date       = Wed Jun 19 14:21:19 PDT 2024
 */
public class usacoSleeping {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      int[] a = new int[n];
      int sum = 0;
      for(int i =0 ;i < n; ++i){
        a[i]=in.nextInt();
        sum+=a[i];
      }
      if (sum == 0){
        out.println(0);
        continue;
      }
      int ans = n;
      for(int i = 1; i <= sum; ++i){
        if (sum%i==0){
          int x = sum/i;
          int cnt = 0;
          int cur = 0;
          boolean y = false;
          for(int j = 0; j < n; ++j){
            if (y)
              cnt++;
            else y = true;
            cur+=a[j];
            if (cur > x){
              cur = -1;
              break;
            }
            if (cur == x){
              y = false;
              cur = 0;
            }
          }
          if (cur == 0){
            ans = Math.min(ans, cnt);
          }
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
  void main(String[]args){usacoSleeping t=new usacoSleeping();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
