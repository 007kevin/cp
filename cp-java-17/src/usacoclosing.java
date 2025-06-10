
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoclosing
 * Date       = Sat Nov  2 12:12:18 PDT 2024
 */
public class usacoclosing {

  int N;
  int M;
  Map<Integer,Set<Integer>> graph = new HashMap<>();
  List<Boolean> closed = new ArrayList<>();

  public void run() {
    N = in.nextInt();
    graph.clear();
    closed.clear();
    for(int i = 0; i <= N; ++i)
      closed.add(false);
    M = in.nextInt();
    for(int i = 0; i < M; ++i){
      int a = in.nextInt();
      int b = in.nextInt();
      graph.computeIfAbsent(a, k -> new HashSet<>()).add(b);
      graph.computeIfAbsent(b, k -> new HashSet<>()).add(a);
    }
    printans();
    for(int i = 1; i < N; ++i){
      int a = in.nextInt();
      closed.set(a, true);
      for(int b : graph.get(a)) graph.get(b).remove(a);
      graph.get(a).clear();
      printans();
    }
  }

  void printans(){
    if (connected()){
      out.println("YES");
    } else
      out.println("NO");
  }

  boolean connected() {
    int start = -1;
    for(int i = 1; i < closed.size(); ++i)
      if (!closed.get(i)){
        start = i;
        break;
      }
    if (start == -1)
      return false;
    List<Boolean> visited = new ArrayList<>(N+1);
    for(int i = 0; i <= N; ++i) visited.add(false);
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    while(!q.isEmpty()){
      int a = q.poll();
      if (visited.get(a))
        continue;
      visited.set(a, true);
      for(int b : graph.get(a)){
        if (!closed.get(b) && !visited.get(b))
          q.add(b);
      }
    }
    for(int i = 1; i <= N; ++i)
      if (!closed.get(i) && !visited.get(i))
        return false;
    return true;
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
  void main(String[]args){usacoclosing t=new usacoclosing();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "closing";
}
