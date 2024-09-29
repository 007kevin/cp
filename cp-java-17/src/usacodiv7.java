
import java.io.*;
import java.util.*;

/**
 * Problem    = usacodiv7
 * Date       = Tue Sep 17 20:15:38 PDT 2024
 */
public class usacodiv7 {

  public void run() {
    int n = in.nextInt();
    int[] c = new int[n+1];
    for(int i = 1; i <= n; ++i){
      c[i]=((in.nextInt()%7) + c[i-1])%7;
    }
    int ans = 0;
    for(int i = 1; i <= n; ++i)
      for(int j = i+ans; j <= n; ++j){
        if ((c[j]-c[i-1])%7==0){
          ans=Math.max(ans,j-i+1);
        }
      }
    out.println(ans);
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
  void main(String[]args){usacodiv7 t=new usacodiv7();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "div7";
}
