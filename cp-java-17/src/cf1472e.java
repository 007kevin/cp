
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1472e
 * Date       = Tue Oct  1 17:08:40 PDT 2024
 */
public class cf1472e {

  public void run() {
    int t = in.nextInt();
    while(t-->0){
      int n = in.nextInt();
      int[] h = new int[n];
      int[] w = new int[n];
      var hsort = new ArrayList<Integer>(n);
      int[] wpref = new int[n];
      var wsort = new ArrayList<Integer>(n);
      int[] hpref = new int[n];
      for(int i = 0; i < n; ++i){
        h[i]=in.nextInt();
        w[i]=in.nextInt();
        hsort.add(i);
        wsort.add(i);
      }
      Collections.sort(hsort, Comparator.comparingInt(i -> h[i]));
      Collections.sort(wsort, Comparator.comparingInt(i -> w[i]));
      wpref[0] = hsort.get(0);
      for(int i = 1; i < n; ++i){
        if (w[wpref[i-1]] > w[hsort.get(i)])
          wpref[i]=hsort.get(i);
        else
          wpref[i]=wpref[i-1];
      }
      hpref[0] = wsort.get(0);
      for(int i = 1; i < n; ++i){
        if (h[hpref[i-1]] > h[wsort.get(i)])
          hpref[i]=wsort.get(i);
        else
          hpref[i]=hpref[i-1];
      }
      for(int i = 0; i < n; ++i){
        int l = 0;
        int r = n-1;
        int a = -1;
        while(l<=r){
          int m = (l+r)/2;
          if (h[hsort.get(m)] < h[i]){
            if (w[wpref[m]] < w[i])
              a = wpref[m] + 1;
            l = m+1;
          } else {
            r = m-1;
          }
        }
        if (a != -1){
          out.print(a + " ");
          continue;
        }
        l = 0;
        r = n-1;
        while(l<=r){
          int m = (l+r)/2;
          if (w[wsort.get(m)] < h[i]){
            if (h[hpref[m]] < w[i])
              a = hpref[m] + 1;
            l = m+1;
          } else {
            r = m-1;
          }
        }
        out.print(a + " ");
      }
      out.println();
      // out.println("hsort");
      // for(int i = 0; i < n; ++i){
      //   out.print(h[hsort.get(i)] + "\t");
      // }
      // out.println();
      // for(int i = 0; i < n; ++i){
      //   out.print(w[wpref[i]] + "\t");
      // }
      // out.println();
      // out.println("wsort");
      // for(int i = 0; i < n; ++i){
      //   out.print(w[wsort.get(i)] + "\t");
      // }
      // out.println();
      // for(int i = 0; i < n; ++i){
      //   out.print(h[hpref[i]] + "\t");
      // }
      // out.println();
    }
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
  void main(String[]args){cf1472e t=new cf1472e();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
