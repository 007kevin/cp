
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoAngry
 * Date       = Sat Jul  6 09:37:23 KST 2024
 */
public class usacoAngry {

  public void run() {
    int n = in.nextInt();
    long[] b = new long[n];
    for(int i = 0; i < n; ++i)
      b[i]=in.nextLong();
    Arrays.sort(b);
    int max = 0;
    for(int i = 0; i < n; ++i){
      long[] r = new long[n];
      r[i]=1;
      max=Math.max(max,1 + simulate(b,r,1));
//      print(r);
    }
    out.println(max);
  }

  int simulate(long[] b, long[] r, long t){
    int cnt = 0;
    boolean cont = false;
    for(int i = 0; i < b.length; ++i){
      if (r[i] == t){
        for(int j = 0; j < b.length; ++j){
          if (r[j] == 0 && b[i] - t <= b[j] && b[j] <= b[i] + t){
            cont = true;
            cnt++;
            r[j]=t+1;
          }
        }
      }
    }
    if (cont){
      return cnt + simulate(b,r,t+1);
    }
    return cnt;
  }

  void print(long[] r){
    out.print("{");
    for(int i = 0; i < r.length; ++i){
      out.print(r[i] + ",");
    }
    out.println("}");
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
  void main(String[]args){usacoAngry t=new usacoAngry();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "angry";
}
