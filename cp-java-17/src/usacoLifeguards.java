
import java.io.*;
import java.util.*;

/**
 * Problem    = usacoLifeguards
 * Date       = Sun Sep 22 16:58:07 PDT 2024
 */
public class usacoLifeguards {

  static class Cow implements Comparable<Cow> {
    int alone = 0;
    @Override
    public int compareTo(Cow that) {
      return this.alone - that.alone;
    }
  }

  public void run() {
    int n = in.nextInt();
    List<Cow> list = new ArrayList<>(n);
    Map<Integer,Cow> map = new TreeMap<>();
    for(int i = 0; i < n; ++i){
      int s = in.nextInt();
      int e = in.nextInt();
      Cow c = new Cow();
      map.put(s,c);
      map.put(e,c);
      list.add(c);
    }
    var set = new HashSet<Cow>();
    int total = 0;
    var entries = new ArrayList<>(map.entrySet());
    for(int i = 0; i < entries.size()-1; ++i){
      var a = entries.get(i);
      Cow cowA = a.getValue();
      Integer pointA = a.getKey();

      var b = entries.get(i+1);
      Cow cowB = b.getValue();
      Integer pointB = b.getKey();

      if (!set.contains(cowA)){
        set.add(cowA);
      } else {
        set.remove(cowA);
      }
      if (set.size()>0){
        total+=pointB-pointA;
      }
      if (set.size()==1){
        set.forEach(c -> c.alone+=pointB-pointA);
      }
    }
    Collections.sort(list);
    out.println(total - list.get(0).alone);
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
  void main(String[]args){usacoLifeguards t=new usacoLifeguards();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "lifeguards";
}
