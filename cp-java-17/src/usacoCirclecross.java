
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoCirclecross
 * Date       = Fri Jun  7 21:43:04 PDT 2024
 */
public class usacoCirclecross {

  public void run() {
    char[] s = in.next().toCharArray();
    int[][] p = new int[256][2];
    for(int i = 0; i < 256; ++i)
      p[i][0]=p[0][1]=-1;
    for(int i = 0; i < s.length; ++i){
      if (p[s[i]][0]==-1) p[s[i]][0] = i;
      else p[s[i]][1] = i;
    }
    int c=0;
    for(int i = 'A'; i <= 'Z'; ++i){
      for(int j = i+1; j <= 'Z'; ++j){
        if (x(p[i],p[j]))
          c++;
      }
    }
    out.println(c);
  }

  boolean x(int[] a, int[] b){
//    out.println(String.format("[%d,%d] / [%d,%d]", a[0],a[1],b[0],b[1]));
    if (a[0] < b[0] && b[0] < a[1] && a[1] < b[1]) return true;
    if (b[0] < a[0] && a[0] < b[1] && b[1] < a[1]) return true;
    return false;
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
  void main(String[]args){usacoCirclecross t=new usacoCirclecross();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "circlecross";
}
