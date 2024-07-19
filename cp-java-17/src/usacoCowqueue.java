
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoCowqueue
 * Date       = Sat Jul  6 09:08:58 KST 2024
 */
public class usacoCowqueue {

  public void run() {
    int n = in.nextInt();
    int[][] c = new int[n][2];
    for(int i = 0; i < n ; ++i){
      c[i][0]=in.nextInt();
      c[i][1]=in.nextInt();
    }
    Arrays.sort(c, Arrays::compare);
    int t = 0;
    for(var a : c){
      t = Math.max(t,a[0]);
      t+=a[1];
    }
    out.println(t);
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
  void main(String[]args){usacoCowqueue t=new usacoCowqueue();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "cowqueue";
}
