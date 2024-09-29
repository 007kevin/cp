
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoRental
 * Date       = Mon Sep 23 23:03:43 PDT 2024
 */
public class usacoRental {

  static class Cow {
    int milk;
    Cow(int milk){
      this.milk=milk;
    }
  }

  static class Buyer {
    int needs;
    int price;
    Buyer(int needs, int price){
      this.needs=needs;
      this.price=price;
    }
  }

  static class Renter {
    int price;
    Renter(int price){
      this.price=price;
    }
  }

  public void run() {
    int N = in.nextInt();
    int M = in.nextInt();
    int R = in.nextInt();
    int[] cows = new int[N];
    for(int i = 0; i < N; ++i)
      cows[i]=in.nextInt();
    var buyers = new ArrayList<Buyer>();
    for(int i = 0; i < M; ++i)
      buyers.add(new Buyer(in.nextInt(), in.nextInt()));
    int[] renters = new int[R];
    for(int i = 0; i < R; ++i)
      renters[i]=in.nextInt();
    sortPrimitiveRev(cows);
    Collections.sort(buyers, (a,b) -> b.price - a.price);
    sortPrimitiveRev(renters);
    long[] milkSum = new long[N];
    milkSum[0] = cows[0];
    for(int i = 1; i < N; ++i)
      milkSum[i]+=milkSum[i-1]+cows[i];
    long[][] buyerSum = new long[M][2];
    buyerSum[0][0]=buyers.get(0).needs;
    buyerSum[0][1]=buyers.get(0).price*buyers.get(0).needs;
    for(int i = 1; i < M; ++i){
      buyerSum[i][0]+=buyerSum[i-1][0]+buyers.get(i).needs;
      buyerSum[i][1]+=buyerSum[i-1][1]+(buyers.get(i).price*buyers.get(i).needs);
    }
    long[] rentSum = new long[R];
    rentSum[0]=renters[0];
    for(int i = 1; i < R; ++i)
      rentSum[i]+=rentSum[i-1]+renters[i];
    long ans = 0;
    for(int i = -1; i <= N; ++i){
      long profit = 0;
      long totalMilk = 0;
      if (0<=i && i < N) totalMilk=milkSum[i];

      int b = -1;
      int left = 0, right = M-1;
      while(left <= right){
        int mid = (left+right)/2;
        if (buyerSum[mid][0] <= totalMilk){
          b = mid;
          left=mid+1;
        } else {
          right = mid-1;
        }
      }
      if (b!=-1){
        profit+=buyerSum[b][1];
        if (buyerSum[b][0] < totalMilk && b < M-1){
          long subMilk = totalMilk - buyerSum[b][0];
          profit+=subMilk * buyers.get(b+1).price;
        }
      }

      // b = 0;
      // while(b < M && totalMilk != 0){
      //   if (buyers.get(b).needs < totalMilk){
      //     profit+=buyers.get(b).needs * buyers.get(b).price;
      //     totalMilk-=buyers.get(b).needs;
      //   } else {
      //     profit+=totalMilk * buyers.get(b).price;
      //     totalMilk = 0;
      //   }
      //   b++;
      // }

      if (i < N-1) profit+=rentSum[Math.min(R-1, N-i-2)];
      ans = Math.max(ans,profit);
    }
    out.println(ans);
  }

  void sortPrimitiveRev(int[] a){
    Arrays.sort(a);
    int i = 0, j = a.length-1;
    while(i<j){
      int tmp = a[i];
      a[i]=a[j];
      a[j]=tmp;
      i++;
      j--;
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
  void main(String[]args){usacoRental t=new usacoRental();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "rental";
}
