
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoMowing
 * Date       = Sun May 12 09:04:18 PDT 2024
 */
public class usacoMowing {

  Map<Integer,Map<Integer,List<Integer>>> map = new HashMap<>();
  int time = 0;

  void mark(int x, int y){
    map.computeIfAbsent(x, k -> new HashMap<>())
        .computeIfAbsent(y, k -> new LinkedList<>())
        .add(time++);
  }

  int compute() {
    int x = Integer.MAX_VALUE;
    for(var a : map.values()){
      for(var b : a.values()){
        for(int i = 1; i < b.size(); ++i)
          x = Math.min(x,b.get(i)-b.get(i-1));
      }
    }
    return x == Integer.MAX_VALUE ? -1 : x;
  }

  public void run() {
    int n = in.nextInt();
    int x = 0;
    int y = 0;
    mark(x,y);
    while(n-->0){
      String d = in.next();
      int s = in.nextInt();
      switch(d){
        case "N":
          for(int i = 0; i < s; ++i) mark(++x,y);
          break;
        case "E":
          for(int i = 0; i < s; ++i) mark(x,++y);
          break;
        case "S":
          for(int i = 0; i < s; ++i) mark(--x,y);
          break;
        case "W":
          for(int i = 0; i < s; ++i) mark(x,--y);
          break;
      }
    }
    out.println(compute());
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
  void main(String[]args){usacoMowing t=new usacoMowing();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "mowing";
}
