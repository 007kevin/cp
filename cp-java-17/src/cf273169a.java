
import java.io.*;
import java.util.*;

/**
 * Problem    = cf273169a
 * Date       = Thu Jan 23 23:21:11 PST 2025
 */
public class cf273169a {

  int[] t = new int[400000];

  public void run() {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; ++i) a[i]=in.nextInt();
    build(a, 1, 0, n-1);
    while(m-->0){
      int op = in.nextInt();
      if (op == 1)
        set(1,0,n-1,in.nextInt(),in.nextInt());
      else
        out.println(sum(1,0,n-1,in.nextInt(),in.nextInt()));
    }
  }

  void build(int[] a, int v, int l, int r){
    if (l==r)
      t[v]=a[l];
    else {
      int m = (l+r)/2;
      build(a, v*2, l, m);
      build(a, v*2+1, m+1, r);
      t[v] = t[v*2] + t[v*2+1];
    }
  }

  void set(int v, int tl, int tr, int p, int nv){
    if (tl==tr)
      t[v] += nv;
    else {
      int m = (tl+tr)/2;
      if (p <= m)
        set(v*2, tl,m,p,nv);
      else
        set(v*2+1, m+1, tr, p, nv);
      t[v] = t[v*2] + t[v*2+1];
    }
  }

  int sum(int v, int tl, int tr, int l, int r){
    if (l > r)
      return 0;
    if (l == tl && r == tr) {
      return t[v];
    }
    int tm = (tl + tr) / 2;
    return sum(v*2, tl, tm, l, Math.min(r, tm))
        + sum(v*2+1, tm+1, tr, Math.max(l, tm+1), r);
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
  void main(String[]args){cf273169a t=new cf273169a();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
