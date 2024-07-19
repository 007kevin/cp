
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoLifeguards
 * Date       = Fri Jun  7 21:33:56 PDT 2024
 */
public class usacoLifeguards {

  public void run() {
    int n = in.nextInt();
    int[][] c = new int[n][2];
    int[] r = new int[1001];
    for(int i = 0; i < n; ++i){
      c[i][0]=in.nextInt();
      c[i][1]=in.nextInt();
      r[c[i][0]+1]++;
      r[c[i][1]+1]--;
    }
    int a = 0;
    for(int i = 0; i < n; ++i){
      r[c[i][0]+1]--;
      r[c[i][1]+1]++;
      int p = 0;
      int s = 0;
      for(int j = 0; j <= 1000; ++j){
        p+=r[j];
        if (p>0) s++;
      }
      a = Math.max(a,s);
      r[c[i][0]+1]++;
      r[c[i][1]+1]--;

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
  void main(String[]args){usacoLifeguards t=new usacoLifeguards();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "lifeguards";
}
