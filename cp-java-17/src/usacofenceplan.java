
import java.io.*;
import java.util.*;

/**
 * Problem    = usacofenceplan
 * Date       = Sat Nov  2 13:15:24 PDT 2024
 */
public class usacofenceplan {

  int N;
  int M;
  List<Boolean> visited;
  List<Integer> x;
  List<Integer> y;
  Map<Integer, Set<Integer>> graph;

  public void run() {
    N = in.nextInt();
    M = in.nextInt();
    visited = new ArrayList<>(N+1);
    x = new ArrayList<>(N+1);
    y = new ArrayList<>(N+1);
    graph = new HashMap<>();
    for(int i = 0; i <= N; ++i){
      visited.add(false);
      x.add(0);
      y.add(0);
    }
    for(int i = 1; i <= N; ++i){
      x.set(i,in.nextInt());
      y.set(i,in.nextInt());
    }
    for(int i = 1; i <= M; ++i){
      int a = in.nextInt();
      int b = in.nextInt();
      graph.computeIfAbsent(a, key -> new HashSet<>()).add(b);
      graph.computeIfAbsent(b, key -> new HashSet<>()).add(a);
    }
//    out.println(graph);
    int perim = Integer.MAX_VALUE;
    for(int i = 1; i <= N; ++i){
      if (!visited.get(i)){
        int output = calc(i);
        perim = Math.min(perim, output);
      }
    }
    out.println(perim);
  }

  int calc(int i){
    int minx = Integer.MAX_VALUE;
    int miny = Integer.MAX_VALUE;
    int maxx = Integer.MIN_VALUE;
    int maxy = Integer.MIN_VALUE;
    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    while(!q.isEmpty()){
      int a = q.poll();
      if (visited.get(a)) continue;
      visited.set(a, true);
      minx = Math.min(minx, x.get(a));
      miny = Math.min(miny, y.get(a));
      maxx = Math.max(maxx, x.get(a));
      maxy = Math.max(maxy, y.get(a));
      for(int b : graph.getOrDefault(a, Collections.emptySet())){
        if (!visited.get(b))
          q.add(b);
      }
    }
    return ((maxx - minx) + (maxy - miny)) * 2;
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
  void main(String[]args){usacofenceplan t=new usacofenceplan();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "fenceplan";
}
