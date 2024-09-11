
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoEvolution
 * Date       = Tue Aug 13 13:00:53 KST 2024
 */
public class usacoEvolution {

  public void run() {
    var n = in.nextInt();
    var map = new HashMap<String,Integer>();
    var next = 0;
    for(int i = 0; i < n; ++i){
      var m = in.nextInt();
      var arr = new int[m];
      var list = new String[m];
      var can = -1;
      for(int j = 0; j < m; ++j){
        list[j]=in.next();
        arr[j]=map.getOrDefault(list[j],-1);
        can = Math.max(can, arr[j]);
      }
      for(int j = 0; j < m; ++j){
        if (arr[j] != -1 && arr[j] != can){
          out.println("no");
        }
      }
      for(int j = 0; j < m; ++j)
        map.put(list[j],next);
      next++;
//      out.println(map);
    }
    out.println("yes");
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
  void main(String[]args){usacoEvolution t=new usacoEvolution();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "evolution";
}
