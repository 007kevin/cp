
import java.io.*;
import java.util.*;

/**
 * Problem    = cf268a
 * Date       = Sun Jan 19 22:57:00 PST 2025
 */
public class cf268a {

  public void run() {
    int n = in.nextInt();
    int t[][] = new int[n][2];
    for(int i = 0; i < n; ++i) {
      t[i][0] = in.nextInt();
      t[i][1] = in.nextInt();
    }
    int a = 0;
    for(int i = 0; i < n; ++i){
      for(int j = 0; j < n; ++j){
        if (i==j) continue;
        if (t[i][0] == t[j][1])
          a++;
      }
    }
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
  void main(String[]args){cf268a t=new cf268a();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
