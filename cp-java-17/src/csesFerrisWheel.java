
import java.io.*;
import java.util.*;

/**
 * Problem    = csesFerrisWheel
 * Date       = Thu Oct 17 22:16:07 PDT 2024
 */
public class csesFerrisWheel {

  public void run() {
    int n = in.nextInt();
    int x = in.nextInt();
    int[] p = new int[n];
    for(int i = 0; i < n; ++i) p[i]=in.nextInt();
    Arrays.sort(p);
    int g = n;
    int ptr = n-1;
    for(int i = 0; i < ptr; i++){
      while(ptr > i && p[i] + p[ptr] > x) ptr--;
      if (ptr > i && p[i] + p[ptr] <= x){
        g--;
        ptr--;
      }
    }
    out.println(g);
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
  void main(String[]args){csesFerrisWheel t=new csesFerrisWheel();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
