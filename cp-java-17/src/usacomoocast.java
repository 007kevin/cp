
import java.io.*;
import java.util.*;

/**
 * Problem    = usacomoocast
 * Date       = Sat Nov  2 12:38:17 PDT 2024
 */
public class usacomoocast {

  static class Cow {
    int x,y,p;

    Cow(int x, int y, int p){
      this.x=x;
      this.y=y;
      this.p=p;
    }

    boolean canReach(Cow that){
      int x = this.x - that.x;
      int y = this.y - that.y;
      return p*p >= x*x+y*y;
    }

    @Override
    public String toString() {
      return String.format("{%d,%d,%d}",x,y,p);
    }

  }

  int N;
  List<Cow> cows;
  Map<Cow, Set<Cow>> graph;

  public void run() {
    N = in.nextInt();
    cows = new ArrayList<>(N);
    graph = new HashMap<>();
    for(int i = 0; i < N; ++i)
      cows.add(new Cow(
          in.nextInt(),
          in.nextInt(),
          in.nextInt()));
    for(Cow c : cows){
      int r = 0;
      for(Cow d : cows){
        if (c != d && c.canReach(d))
          graph.computeIfAbsent(c, key -> new HashSet<>()).add(d);
      }
    }
    //out.println(graph);
    int ans = 0;
    for(Cow c : cows){
      ans=Math.max(ans, reach(c));
    }
    out.println(ans);
  }

  int reach(Cow c){
    Queue<Cow> q = new LinkedList<>();
    Set<Cow> visited = new HashSet<>();
    q.add(c);
    while(!q.isEmpty()){
      Cow d = q.poll();
      if (visited.contains(d)) continue;
      visited.add(d);
      for(Cow e : graph.getOrDefault(d, Collections.emptySet())){
        if (!visited.contains(e))
          q.add(e);
      }
    }
    return visited.size();
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
  void main(String[]args){usacomoocast t=new usacomoocast();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "moocast";
}
