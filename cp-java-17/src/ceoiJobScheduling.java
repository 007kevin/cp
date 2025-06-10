
import java.io.*;
import java.util.*;

/**
 * Problem    = ceoiJobScheduling
 * Date       = Sun Nov  3 17:02:47 PST 2024
 */
public class ceoiJobScheduling {

  static class Req {
    int id;
    int day;
    Req(int id, int day){
      this.id=id;
      this.day=day;
    }
    @Override
    public String toString() {
      return "{id:" + id + ", day:" + day + "}";
    }
  }

  public void run() {
    int N = in.nextInt();
    int D = in.nextInt();
    int M = in.nextInt();
    List<Deque<Req>> schedule = new ArrayList<>(N+1);
    for(int i = 0; i <= N; ++i)
      schedule.add(new LinkedList<>());
    for(int i = 1; i <= M; ++i){
      Req r = new Req(i, in.nextInt());
      schedule.get(r.day).addFirst(r);
    }

    int left = 1;
    int right = 1000000;
    int ans = 0;
    List<Deque<Req>> answer = Collections.emptyList();
    while(left<=right){
      int machines = (left+right)/2;
      List<Deque<Req>> candidate = copy(schedule);
      for(int i = 1; i < N; ++i){
        var today = candidate.get(i);
        var tmrw = candidate.get(i+1);
        while(today.size() > machines){
          tmrw.addFirst(today.pollLast());
        }
      }
      boolean valid = valid(candidate, machines, D);
      if (valid){
        ans = machines;
        answer = candidate;
        right = machines - 1;
      } else
        left = machines + 1;
      //out.println(machines + " " + valid);
    }
    out.println(ans);
    for(int i = 1; i <= N; ++i){
      var day = answer.get(i);
      for(var r : day)
        out.print(r.id + " ");
      out.println(0);
    }
  }

  boolean valid(List<Deque<Req>> candidate, int machines, int delay){
    int N = candidate.size() - 1;
    for(int i = 1; i <= N; ++i){
      var day = candidate.get(i);
      if (day.size() > machines)
        return false;
      for(var r : day){
        if (i - r.day + 1 > delay)
          return false;
      }
    }
    return true;
  }

  List<Deque<Req>> copy(List<Deque<Req>> schedule){
    List<Deque<Req>> copy = new ArrayList<>(schedule.size());
    for(var day : schedule){
      copy.add(new LinkedList<>(day));
    }
    return copy;
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
  void main(String[]args){ceoiJobScheduling t=new ceoiJobScheduling();t.run();t.c();}
  /////////////////////////////////////////////////////////////////////////////////
  static String file;
}
