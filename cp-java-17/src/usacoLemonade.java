
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoLemonade
 * Date       = Sun Oct 20 12:19:11 PDT 2024
 */
public class usacoLemonade {

  public void run() {
    int n = in.nextInt();
    Integer[] c = new Integer[n];
    for(int i = 0; i < n; ++i)
      c[i]=in.nextInt();
    Arrays.sort(c, Collections.reverseOrder());
    int line = 0;
    for(int i = 0; i < n; ++i){
      if (line <= c[i]){
        line++;
      }
    }
    out.println(line);
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
  void main(String[]args){usacoLemonade t=new usacoLemonade();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "lemonade";
}
