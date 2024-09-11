
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoReduce
 * Date       = Fri Sep  6 15:37:03 PDT 2024
 */
public class usacoReduce {

  static class Pos {
    int x,y;
    Pos(int x, int y){this.x=x;this.y=y;}
  }

  public void run() {
    int n = in.nextInt();
    List<Pos> xy = new ArrayList<>();
    List<Pos> yx = new ArrayList<>();
    for(int i = 0; i < n; ++i){
      var p = new Pos(in.nextInt(), in.nextInt());
      xy.add(p);
      yx.add(p);
    }
    Collections.sort(xy, (a,b) -> {
      if (a.x == b.x) return Integer.compare(a.y,b.y);
      else return Integer.compare(a.x,b.x);
    });
    Collections.sort(yx, (a,b) -> {
      if (a.y == b.y) return Integer.compare(a.x,b.x);
      else return Integer.compare(a.y,b.y);
    });
    int area = Integer.MAX_VALUE;
    for(int i = 0; i <= 3; ++i)
      for(int j = 0; j <= 3; ++j)
        for(int k = 0; k <= 3; ++k)
          for(int l = 0; l <= 3; ++l){
            if(i+j+k+l > 3) continue;
            Set<Pos> set = new HashSet<>();

            // side 1
            int cnt=0, idx=0;
            while(cnt < i){
              Pos p = get(xy,idx); if (p == null) break;
              if(!set.contains(p)){
                set.add(p);
                cnt++;
              }
              idx++;
            }

            // side 2
            cnt=0; idx=0;
            while(cnt < j){
              Pos p = get(yx,idx); if (p == null) break;
              if(!set.contains(p)){
                set.add(p);
                cnt++;
              }
              idx++;
            }

            // side 3
            cnt=0; idx=0;
            while(cnt < k){
              Pos p = rev(xy,idx); if (p == null) break;
              if(!set.contains(p)){
                set.add(p);
                cnt++;
              }
              idx++;
            }

            // side 4
            cnt=0; idx=0;
            while(cnt < l){
              Pos p = rev(yx,idx); if (p == null) break;
              if(!set.contains(p)){
                set.add(p);
                cnt++;
              }
              idx++;
            }

            int x1=Integer.MAX_VALUE,y1=Integer.MAX_VALUE,x2=0,y2=0;
            for(Pos p : xy){
              if (!set.contains(p)){
                x1=Math.min(x1,p.x);
                y1=Math.min(y1,p.y);
                x2=Math.max(x2,p.x);
                y2=Math.max(y2,p.y);
              }
            }
            if (set.size() <= 3){
              System.out.println(
                  String.format("%d|(%d,%d)(%d,%d)=%d", set.size(), x1,y1,x2,y2,(x2-x1)*(y2-y1)));
              area = Math.min(area, (x2-x1)*(y2-y1));
            }
          }
    out.println(area);
  }

  Pos get(List<Pos> list, int n){
    if (n>=list.size())
      return null;
    return list.get(n);
  }

  Pos rev(List<Pos> list, int n){
    if (list.size() - 1 - n < 0)
      return null;
    return list.get(list.size() - 1 - n);
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
  void main(String[]args){usacoReduce t=new usacoReduce();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "reduce";
}
