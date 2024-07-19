
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoHerding
 * Date       = Tue Jul  9 21:46:43 KST 2024
 */
public class usacoHerding {

  public void run() {
    int[] c = new int[3];
    c[0] = in.nextInt();
    c[1] = in.nextInt();
    c[2] = in.nextInt();
    Arrays.sort(c);
    out.println(min(c));
    out.println(max(c));
  }

  int min(int[] c){
    int a = c[1]-c[0];
    int b = c[2]-c[1];
    if(a==1&&b==1) return 0;
    if(a==2||b==2) return 1;
    return 2;
  }

  int max(int[] c){
    int a = c[1]-c[0];
    int b = c[2]-c[1];
    return Math.max(a,b)-1;
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
  void main(String[]args){usacoHerding t=new usacoHerding();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "herding";
}
