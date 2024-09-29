
import java.io.*;
import java.util.*;

/**
 * Problem    = at_abc125c
 * Date       = Thu Sep 19 17:23:47 PDT 2024
 */
public class at_abc125c {

  public void run() {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n];
    for(int i = 0; i < n; ++i){
      a[i]=in.nextInt();
      b[i]=a[i];
      c[i]=a[i];
    }
    for(int i = 1; i < n; ++i){
      b[i]=gcd(b[i],b[i-1]);
    }
    for(int i = n-2; i >= 0; --i){
      c[i]=gcd(c[i], c[i+1]);
    }
    int ans = 0;
    for(int i = 0; i < n; ++i){
      if (i==0){
        ans=Math.max(ans,c[i+1]);
      } else if (i==n-1){
        ans=Math.max(ans,b[i-1]);
      } else {
        ans=Math.max(ans, gcd(b[i-1], c[i+1]));
      }
    }
    out.println(ans);
  }

  int gcd(int x, int y){
    return (y == 0) ? x : gcd(y, x % y);
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
  void main(String[]args){at_abc125c t=new at_abc125c();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
