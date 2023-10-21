
import java.io.*;
import java.util.*;

/**
   Contact Tracing
   ---------------

   ====================================
   Part 1-1 (Find who is inside a room)
   ====================================

   Given
   room entry exit log
   and a time
   Then return list of all people present in that room at that time

   #### input:
   10,Alex,ENTER
   11,Bob,ENTER
   12,Alex,EXIT
   13,Bob,EXIT

   10

   #### output:
   ["Alex"]

   =============================
   Part 2 (Find direct contacts)
   =============================

   Given
   room entry exit log
   and a name (infected)
   Then return list of people who were in the same room at the same time with that person
   (a. k. a. "Direct Contacts")

   #### input: (DIFFERENT FROM PREVIOUS LOG)
   10,Alex,ENTER
   11,Bob,ENTER
   12,Alex,EXIT
   13,Carol,ENTER
   14,Bob,EXIT
   15,Carol,EXIT

   "Bob"

   #### output:
   ["Alex", "Carol"]
 */
public class intContactTracing {

    static class Entry {
        int time;
        String name;
        String type;
        public Entry(int time, String name, String type) {
            this.time = time;
            this.name = name;
            this.type = type;
        }

        public boolean isEnter(){
            return type == "ENTER";
        }

        public boolean isExit(){
            return !isEnter();
        }
    }

    static class ContactTracer1 {
        List<Entry> logs;

        public ContactTracer1(List<Entry> logs) {
            this.logs = logs;
        }

        public List<String> presentAt(int time){
            Set<String> room = new HashSet<>();
            for (Entry entry : logs){
                if (entry.isEnter()){
                    room.add(entry.name);
                }
                if (entry.time == time){
                    return new ArrayList<>(room);
                }
                if (entry.isExit()){
                    room.remove(entry.name);
                }
            }
            return Collections.emptyList();
        }

        public List<String> directContacts(String name){
            List<String> contacts = new ArrayList<>();
            Set<String> room = new HashSet<>();
            for (Entry entry : logs){
                if (entry.isEnter()){
                    room.add(entry.name);
                }
                if (room.contains(name) && entry.name != name) {
                    contacts.add(entry.name);
                }
                if (entry.isExit()){
                    room.remove(entry.name);
                }
            }
            return contacts;
        }

        public List<String> transitiveContacts(String name){
            Set<String> contacts = new HashSet<>();
            Set<String> room = new HashSet<>();
            boolean spreading = false;
            for (Entry entry : logs){
                if (entry.isEnter()){
                    room.add(entry.name);
                }
                if (name == entry.name) {
                    contacts.add(entry.name);
                }
                spreading = isSpreading(room, contacts);
                if (spreading && entry.name != name) {
                    contacts.add(entry.name);
                }
                if (entry.isExit()){
                    room.remove(entry.name);
                }
            }
            contacts.remove(name);
            return new ArrayList<>(contacts);
        }

        private boolean isSpreading(Set<String> room, Set<String> contacts){
            for (String person : room) {
                if (contacts.contains(person))
                    return true;
            }
            return false;
        }
    }

    public void run() {
        List<Entry> logs =
            List.of(new Entry(10,"Alex","ENTER"),
                    new Entry(11,"Bob","ENTER"),
                    new Entry(12,"Alex","EXIT"),
                    new Entry(13,"Carol","ENTER"),
                    new Entry(15,"Bob","EXIT"),
                    new Entry(16,"David","ENTER"),
                    new Entry(17,"Carol","EXIT"),
                    new Entry(18,"David","EXIT"));
        ContactTracer1 ct1 = new ContactTracer1(logs);
        // out.println(ct1.presentAt(10));
        // out.println(ct1.presentAt(12));
        // out.println(ct1.presentAt(14));
        out.println(ct1.transitiveContacts("Alex"));
        out.println(ct1.transitiveContacts("David"));
    }

    /////////////////////////////////////////////////////////////////////////////
    IR in=new IR(System.in);PrintWriter out=new PrintWriter(System.out);void c(){
    out.close();}static class IR {BufferedReader r; StringTokenizer t= null; IR (
    InputStream s){r=new BufferedReader(new InputStreamReader(s), 32768);}boolean
    p(){while(t==null||!t.hasMoreTokens()){try{String l=r. readLine();if(l==null)
    return false; t = new StringTokenizer(l); } catch (IOException e) { throw new
    RuntimeException(e);}}return true;}boolean hasNext(){return p();}String next(
    ){ p();return t.nextToken();}int nextInt() {return Integer.parseInt(next());}
    long nextLong() { return Long.parseLong(next());} double nextDouble(){ return
    Double.parseDouble( next() ); } } public static void main ( String[ ]args ) {
    intContactTracing t=new intContactTracing();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
