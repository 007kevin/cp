
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoSleepy
 * Date       = Wed Jul 10 22:23:17 KST 2024
 */
public class usacoSleepy {

  public void run() {
    int n = in.nextInt();
    int[] p = new int[n];
    for(int i = 0; i < n; ++i)
      p[i]=in.nextInt();
    int a = 0;
    for(int i = 1; i < n; ++i)
      if (p[i-1] > p[i])
        a = i;
    out.println(a);
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
  void main(String[]args){usacoSleepy t=new usacoSleepy();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "sleepy";
}
