
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1223c
 * Date       = Tue Nov  5 21:56:28 PST 2024
 */
public class cf1223c {

  public void run() {
    int q = in.nextInt();
    while(q-->0){
      int n = in.nextInt();
      List<Integer> list = new ArrayList<>(n);
      for(int i = 0; i < n; ++i)
        list.add(in.nextInt());
      Collections.sort(list, Comparator.reverseOrder());
      int x = in.nextInt();
      int a = in.nextInt();
      int y = in.nextInt();
      int b = in.nextInt();
      long k = in.nextLong();

      // int left = 6;
      // int right = 6;

      int left = 1;
      int right = n;

      int ans = Integer.MAX_VALUE;
      while(left <= right){
        int t = (left+right)/2;
        int p = 0;
        long profit = 0;
        for(int i = a*b; i <= t; i+=a*b){
          profit+=list.get(p)/100 * x;
          profit+=list.get(p)/100 * y;
          p++;
//          out.print(i + " ");
        }
//        out.println("\tprofit: " + profit);
        int max = Math.max(a,b);
        int maxP = Math.max(x,y);
        int min = Math.min(a,b);
        int minP = Math.min(x,y);
        for(int i = max; i <= t; i+=max){
          if (i%(a*b) != 0){
            profit+=list.get(p++)/100 * maxP;
//            out.print(i + " ");
          }
        }
//        out.println("\tprofit: " + profit);
        for(int i = min; i <= t; i+=min){
          if (i%(a*b) != 0){
            profit+=list.get(p++)/100 * minP;
//            out.print(i + " ");
          }
        }
//        out.println("\tprofit: " + profit);
//        out.println(String.format("ticket: %d, profit: %d", t, profit));
        if (profit >= k){
          ans = Math.min(ans,t);
          right = t-1;
        } else
          left = t+1;
      }
      out.println(ans == Integer.MAX_VALUE ? -1 : ans);
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
  void main(String[]args){cf1223c t=new cf1223c();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
