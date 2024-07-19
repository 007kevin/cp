
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoBalancing
 * Date       = Sat Jun 15 21:35:07 PDT 2024
 */
public class usacoBalancing {

  public void run() {
    int n = in.nextInt();
    int b = in.nextInt();
    int[][] c = new int[n][2];
    for(int i = 0; i < n; ++i){
      c[i][0]=in.nextInt();
      c[i][1]=in.nextInt();
    }
    Arrays.sort(c, (c1, c2) -> {return c1[1] - c2[1];});
    int ans = n;
    for(int i = 0; i <= b; i+=2){
      int q1 = 0;
      int q2 = 0;
      int q3 = 0;
      int q4 = 0;
      for(int j = 0; j < n; ++j){
        if (c[j][0] < i) q1++;
        if (c[j][0] > i) q2++;
      }
      for(int j = 0; j < n;){
        int y = c[j][1];
        while(j < n && c[j][1]==y){
          if (c[j][0] < i){q1--; q3++;}
          if (c[j][0] > i){q2--; q4++;}
          j++;
        }
        ans = Math.min(ans, max(q1,q2,q3,q4));
      }
    }
    out.println(ans);
  }

  int max(int... a){
    int m = 0;
    for(int n : a)
      m = Math.max(m,n);
    return m;
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
  void main(String[]args){usacoBalancing t=new usacoBalancing();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "balancing";
}
