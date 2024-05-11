
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoTraffic
 * Date       = Tue May  7 22:42:38 PDT 2024
 * Comments   = At least one of the highway segments will be designated as "none"...
 */
public class usacoTraffic {

  static final String ON = "on";
  static final String NONE = "none";
  static final String OFF = "off";

  static class Seg {
    String flow;
    int low,high;
    Seg(String flow, int low, int high){
      this.flow=flow;
      this.low=low;
      this.high=high;
    }
    boolean is(String flow){ return this.flow.equals(flow); }
  }

  public void run() {
    int n = in.nextInt();
    var segs = new Seg[n];
    for(int i = 0; i < n; ++i)
      segs[i] = new Seg(in.next(), in.nextInt(), in.nextInt());
    out.println(r(segs));
    out.println(f(segs));
  }

  String f(Seg[] segs){
    int low = 0;
    int high = 100000;
    for(var s : segs){
      if (s.is(ON)){
        low+=s.low;
        high+=s.high;
      }
      if (s.is(OFF)){
        low-=s.high;
        high-=s.low;
        low = Math.max(0, low);
      }
      if (s.is(NONE)){
        low = Math.max(low,s.low);
        high = Math.min(high,s.high);
      }
    }
    return String.format("%d %d", low, high);
  }

  String r(Seg[] segs){
    int n = segs.length;
    int low = 0;
    int high = 100000;
    for(int i = n-1; i >= 0; --i){
      var s = segs[i];
      if (s.is(OFF)){
        low+=s.low;
        high+=s.high;
      }
      if (s.is(ON)){
        low-=s.high;
        high-=s.low;
        low = Math.max(0, low);
      }
      if (s.is(NONE)){
        low = Math.max(low,s.low);
        high = Math.min(high,s.high);
      }
    }
    return String.format("%d %d", low, high);
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
  void main(String[]args){usacoTraffic t=new usacoTraffic();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "traffic";
}
