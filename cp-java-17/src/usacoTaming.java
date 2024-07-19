
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoTaming
 * Date       = Thu Jul 11 10:33:53 KST 2024
 */
public class usacoTaming {

  public void run() {
    int n = in.nextInt();
    int[] logs = new int[n];
    for(int i = 0; i < n; ++i)
      logs[i]=in.nextInt();
    for(int i = n-2; i >= 0; --i){
      if (logs[i+1] > 0){
        if (logs[i]!=-1&&logs[i]!=logs[i+1]-1){
          out.println(-1);
          return;
        }
        logs[i]=logs[i+1]-1;
      }
    }
    logs[0]=0;
    int min=0;
    int max=0;
    for(int i = 0; i < n; ++i){
      if (logs[i]==0){
        min++;
        max++;
      }
      if (logs[i]==-1)
        max++;
    }
    out.println(min + " " + max);
  }

  void print(int[] e){
    StringJoiner joiner = new StringJoiner(",", "{", "}");
    for(Integer x : e)
      joiner.add(String.valueOf(x));
    System.out.println(joiner);
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
  void main(String[]args){usacoTaming t=new usacoTaming();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "taming";
}
