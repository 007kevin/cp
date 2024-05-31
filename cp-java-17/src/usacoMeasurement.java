
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem    = usacoMeasurement
 * Date       = Sun May 26 21:49:47 PDT 2024
 */
public class usacoMeasurement {

  static class Measure implements Comparable<Measure> {
    int day;
    String name;
    int change;
    Measure(int day, String name, int change){
      this.day=day;
      this.name=name;
      this.change=change;
    }
    @Override
    public int compareTo(Measure that) {
      return Integer.compare(this.day, that.day);
    }
  }

  static class Cow implements Comparable<Cow> {
    String name;
    int milk;
    Cow(String name, int milk){
      this.name=name;
      this.milk=milk;
    }
    @Override
    public int compareTo(Cow that) {
      if (this.milk == that.milk)
        return this.name.compareTo(that.name);
      return this.milk < that.milk ? -1 : 1;
    }
    @Override
    public boolean equals(Object that) {
      return this.name.equals(((Cow) that).name);
    }
    @Override
    protected Cow clone(){
      return new Cow(this.name, this.milk);

    }
    @Override
    public String toString() {
      return String.format("{%s, %d}", this.name, this.milk);
    }
  }

  List<Cow> current = new ArrayList<>(
      List.of(
          new Cow("Bessie", 7),
          new Cow("Elsie", 7),
          new Cow("Mildred", 7)));

  public void run() {
    int n = in.nextInt();
    List<Measure> measures = new ArrayList<>();
    while(n-- > 0){
      Measure m = new Measure(in.nextInt(), in.next(), convert(in.next()));
      measures.add(m);
    }
    Collections.sort(measures);
    int cnt = 0;
    for(Measure m : measures){
      cnt+=update(m);
    }
    out.println(cnt);
  }

  int update(Measure m){
  List<Cow> next = new ArrayList<>(
      List.of(
          current.get(0).clone(),
          current.get(1).clone(),
          current.get(2).clone()));

    Cow cow = next.stream().filter(c -> c.name.equals(m.name)).findFirst().get();
    cow.milk += m.change;
    try {
      List<Cow> best1 = best(current);
      List<Cow> best2 = best(next);
      if (best1.size() != best2.size())
        return 1;
      for(int i = 0; i < best1.size(); i++){
        if (!best1.get(i).equals(best2.get(i))){
          return 1;
        }
      }
      return 0;
    } finally {
      current = next;
    }
  }

  void printCows(){
    for(Cow c : current){
      out.print(c+"\t");
    }
    out.println();
  }

  List<Cow> best(List<Cow> cows) {
    Collections.sort(cows);
    int most = cows.get(2).milk;
    return cows.stream().filter(c -> c.milk == most).collect(Collectors.toList());
  }

  int convert(String s){
    char sign = s.charAt(0);
    int num = Integer.valueOf(s.substring(1, s.length()));
    return sign == '+' ? num : -1*num;
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
  void main(String[]args){usacoMeasurement t=new usacoMeasurement();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file = "measurement";
}
