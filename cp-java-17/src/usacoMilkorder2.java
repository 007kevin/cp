
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoMilkorder
 * Date       = Sun Jul  7 22:35:46 KST 2024
 */
public class usacoMilkorder2 {

  public void run() {
    int N = in.nextInt();
    int M = in.nextInt();
    int K = in.nextInt();
    int[] o = new int[N+1];
    int[] m = new int[M];
    boolean[] d = new boolean[M];
    for(int i = 0; i < M; ++i)
      m[i]=in.nextInt();
    for(int i = 0; i < K; ++i){
      int c = in.nextInt();
      int p = in.nextInt();
      o[p]=c;
      for(int j = 0; j < M; ++j)
        if(m[j]==c){
          d[j]=true;
          break;
        }
    }
    for(int i = 1; i <= N; ++i){
      if (possible(Arrays.copyOf(o,N+1),m,d,i)){
        out.println(i);
        return;
      }
    }
  }

  boolean possible(int[] o, int[] m, boolean[] d, int c1){
    if (o[c1] != 0)
      return false;
    int N = o.length-1;
    int M = m.length;
    o[c1]=1;
    for(int i = 0; i < M; ++i){
      if (d[i])
        continue;
      if(i==0){
        int p = 1;
        int z = M==1?-1:m[i+1];
        while(p<=N&&o[p]!=0&&o[p]!=z) p++;
        if (p>N||p==z) return false;
        o[p]=m[i];
        continue;
      }
      if(i==M-1){
        int p = 1;
        while(p<=N&&o[p]!=m[i-1]) p++;
        if (p>N) return false;
        while(p<=N&&o[p]!=0) p++;
        if (p>N) return false;
        o[p]=m[i];
        continue;
      }

      int p = 1;
      while(p<=N&&o[p]!=m[i-1]) p++;
      if (p>N) return false;
      while(p<=N&&o[p]!=m[i+1]&&o[p]!=0) p++;
      if (p>N||o[p]==m[i+1]) return false;
      o[p]=m[i];

    }
//    print(o);
    return true;
  }

  void print(int[] o){
    out.print('{');
    for (int x:o){
      out.print(x + ", ");
    }
    out.println('}');
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
                                                                                                                                                                     void main(String[]args){usacoMilkorder2 t=new usacoMilkorder2();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "milkorder";
}
