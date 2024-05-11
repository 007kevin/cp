
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoBlist
 * Date       = Tue May  7 22:28:07 PDT 2024
 */
public class usacoBlist {

  public void run() {
    int n = in.nextInt();
    int[] m = new int[1001];
    for(int i = 0; i < n; ++i){
      int s = in.nextInt();
      int t = in.nextInt();
      int b = in.nextInt();
      m[s]+=b;
      m[t]-=b;
    }
    int max = 0;
    for(int i = 1; i <= 1000; ++i){
      m[i] += m[i-1];
      max = Math.max(max,m[i]);
    }
    out.println(max);
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
  void main(String[]args){usacoBlist t=new usacoBlist();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "blist";
}
