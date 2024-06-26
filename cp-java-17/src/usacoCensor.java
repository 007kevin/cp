
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoCensor
 * Date       = Sat May 18 13:17:08 PDT 2024
 */
public class usacoCensor {

  public void run() {
    char[] s = in.next().toCharArray();
    char[] t = in.next().toCharArray();
    char[] f = new char[s.length];
    int n = 0;
    for(int i = 0; i < s.length; ++i){
      f[n++]=s[i];
      int j = 0;
      while(n-t.length+j>=0 && j < t.length && f[n-t.length+j] == t[j])
        j++;
      if (j==t.length)
        n=n-t.length;
    }
    out.println(new String(f,0,n));
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
  void main(String[]args){usacoCensor t=new usacoCensor();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "censor";
}
