
import java.io.*;
import java.util.*;

/**
 * Problem    = cfKayaking
 * Date       = Thu Jul  4 06:37:44 JST 2024
 */
public class cfKayaking {

  public void run() {
    int n = in.nextInt();
    int[] w = new int[2*n];
    for(int i = 0; i < w.length; ++i)
      w[i]=in.nextInt();
    Arrays.sort(w);
    int ans = Integer.MAX_VALUE;
    for(int i = 0; i < w.length - 1; ++i){
      for(int j = i+1; j < w.length; ++j){
        int[] s = new int[w.length - 2];
        int p = 0;
        for(int k = 0; k < w.length; ++k)
          if (k!=i && k!=j)
            s[p++]=w[k];
        int d = 0;
        for(int k = 0; k < s.length-1; k+=2)
          d+=s[k+1]-s[k];
        ans=Math.min(ans, d);
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
  void main(String[]args){cfKayaking t=new cfKayaking();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
