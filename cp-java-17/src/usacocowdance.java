
import java.io.*;
import java.util.*;

/**
 * Problem    = usacocowdance
 * Date       = Sat Oct 26 13:29:56 PDT 2024
 */
public class usacocowdance {

  public void run() {
    int N = in.nextInt();
    int T = in.nextInt();
    int[] d = new int[N];
    for(int i = 0; i < N; ++i){
      d[i]=in.nextInt();
    }
    int left = 1;
    int right = N;
    int ans = 0;
    while(left <= right){
      int k = (left+right)/2;
      var pq = new PriorityQueue<Integer>(k);
      for(int i = 0; i < k; ++i)
        pq.add(d[i]);
      int t = 0;
      for(int i = k; i < N; ++i){
        int a = pq.poll();
        t+=(a-t);
        pq.add(d[i]+t);
      }
      int total = max(pq);
      if (total <= T){
        ans = k;
        right = k-1;
      } else
        left = k+1;
      //out.println(String.format("with %d size, time is %d", k, total));
    }
    out.println(ans);
  }

  static int max(PriorityQueue<Integer> pq){
    int m = 0;
    while(!pq.isEmpty())
      m = pq.poll();
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
  void main(String[]args){usacocowdance t=new usacocowdance();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "cowdance";
}
