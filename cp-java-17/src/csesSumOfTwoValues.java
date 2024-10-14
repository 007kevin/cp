
import java.io.*;
import java.util.*;

/**
 * Problem    = csesSumOfTwoValues
 * Date       = Sun Oct  6 12:44:12 PDT 2024
 */
public class csesSumOfTwoValues {

  public void run() {
    int n = in.nextInt();
    int x = in.nextInt();
    var map = new HashMap<Integer,Integer>();
    for(int i = 0; i < n; ++i){
      int a = in.nextInt();
      if (a < x && map.containsKey(x-a)){
        out.println((map.get(x-a)+1) + " " + (i+1));
        return;
      }
      map.put(a,i);
    }
    out.println("IMPOSSIBLE");
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
  void main(String[]args){csesSumOfTwoValues t=new csesSumOfTwoValues();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
