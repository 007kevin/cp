
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoPlanting
 * Date       = Fri Jul 26 18:03:50 KST 2024
 */
public class usacoPlanting {

  static class Node {
    int in = 0;
  }

  public void run() {
    int n = in.nextInt();
    Node[] nodes = new Node[n+1];
    for(int i = 1; i <= n; ++i)
      nodes[i] = new Node();
    for(int i = 1; i < n; ++i){
      int a = in.nextInt();
      int b = in.nextInt();
      nodes[a].in++;
      nodes[b].in++;
    }
    int ans = 0;
    for(int i = 1; i <= n; ++i){
      ans = Math.max(ans, nodes[i].in);
    }
    out.println(ans+1);
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
  void main(String[]args){usacoPlanting t=new usacoPlanting();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "planting";
}
