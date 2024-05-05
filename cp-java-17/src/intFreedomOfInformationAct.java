import java.util.HashMap;
import java.util.Map;

/**
Part I

Write a generic function that consumes a secureMessage and the list of installed templates and renders the `reportTemplate`.

reportTemplate: "{{ person1 }} was seen with {{ person2 }} at {{ location1 }} today at {{ time1 }}"
locationTemplate: "{{ unit }}-{{ number }} {{ street }} {{ direction }} {{ city }} {{ province }}"
installedTemplates: { "report": reportTemplate, "warning": warningTemplate, "locationTemplate": locationTemplate ... }
context: { "person1": "James", "person2": "John", "location1": "London Bridge", "time1": "0900h" }
secureMessage: { templateId: "report", context: context }
rendered: "James was seen with John at London Bridge today at 0900h"

fun render(secureMessage, installedTemplates) => String

Part II
context: { "person1": "Mario", "person2": "George", "time1": "0900h", "unit": "3", "number": "85", "street": "Lawrence Ave", "direction": "S", "city": "Miami", "province": "Florida" }

reportTemplate: "{{ person1 }} was seen with {{ person2 }} at {{> locationTemplate }} today at {{ time1 }}"
locationTemplate: "{{ unit }}-{{ number }} {{ street }} {{ direction }} {{ city }} {{ province }}"
installedTemplates: { "report": reportTemplate, "locationTemplate": locationTemplate ... }

rendered: "Mario was seen with George at 3-85 Lawrence Ave S Miami Florida today at 0900h"

Part III
context: { "firstName": "Lucy", "lastName": "Pepperton", "unit": "300", "number": "105", "street": "West Broadway", "direction": "W", "city": "New York", "province": "NY", "person2": "Veronica", "outpost1": "Tango Foxtrot", "time1": "1930h" }

reportTemplate: "{{> knownPersonTemplate }} was seen with {{ person2 }} at {{ outpost1 }} today at {{ time1 }}"
locationTemplate: "{{ unit }}-{{ number }} {{ street }} {{ direction }} {{ city }} {{ province }}"
knownPersonTemplate: "{{ firstName }} {{ lastName }} who lives at {{> locationTemplate }}"

rendered: "Lucy Pepperton who lives at 300-105 West Broadway W New York NY was seen with Veronica at Tango Foxtrot today at 1930h"

Part IV
context: { person1: { "firstName": "Lucy", "lastName": "Pepperton" }, address1: { "unit": "300", "number": "105", "street": "West Broadway", "direction": "W", "city": "New York", "province": "NY" }, "person2": "Veronica", "outpost1": "Tango Foxtrot", "time1": "1930h" }

reportTemplate: "{{> knownPersonTemplate }} was seen with {{ person2 }} at {{ outpost1 }} today at {{ time1 }}"
locationTemplate: "{{ address1.unit }}-{{ address1.number }} {{ address1.street }} {{ address1.direction }} {{ address1.city }} {{ address1.province }}"
knownPersonTemplate: "{{ person1.firstName }} {{ person1.lastName }} who lives at {{> locationTemplate }}"

rendered: "Lucy Pepperton who lives at 300-105 West Broadway W New York NY was seen with Veronica at Tango Foxtrot today at 1930h"




 */


public class intFreedomOfInformationAct {

    public static class Context {
        private final Map<String, String> map;

        public Context(Object... kv) {
            map = new HashMap<>();
            construct("", kv);
        }

        private void construct(String prefix, Object... kv) {
            assert(kv.length%2==0);
            for(int i = 0; i < kv.length; i+=2){
                String key = prefix + (String) kv[i];
                if (kv[i+1].getClass().isArray()){
                    construct(key + ".", kv[i+1]);
                } else {
                    map.put(key, (String) kv[i+1]);
                }
            }
        }

    }
    public static class Templates {
        private final Map<String, String> templates;

        public Templates(String... kv) {
            assert(kv.length%2==0);
            templates = new HashMap<>();
            for(int i = 0; i < kv.length; i+=2){
                templates.put(kv[i], kv[i+1]);
            }
        }

        public String render(SecureMessage secureMessage){
            return render(templates.get(secureMessage.templateId), secureMessage.context);
        }

        public String render(String msg, Context context) {
            for(var e : templates.entrySet()) {
                String key = "{{> " + e.getKey() + " }}";
                if (msg.contains(key))
                    msg = msg.replace(key, render(e.getValue(), context));
            }
            for(var e : context.map.entrySet()) {
                String key = "{{ " + e.getKey() + " }}";
                if (msg.contains(key))
                    msg = msg.replace(key, e.getValue());
            }
            return msg;
        }
    }

    public static class SecureMessage {

        public final String templateId;
        public final Context context;

        public SecureMessage(String templateId, Context context) {
            this.templateId = templateId;
            this.context = context;
        }

    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        Templates templates = new Templates(
                "reportTemplate", "{{ person1 }} was seen with {{ person2 }} at {{ location1 }} today at {{ time1 }}",
                "locationTemplate", "{{ unit }}-{{ number }} {{ street }} {{ direction }} {{ city }} {{ province }}");

        Context context = new Context(
                "person1", "James",
                "person2", "John",
                "location1", "London Bridge",
                "time1", "0900h");

        SecureMessage secureMessage = new SecureMessage("reportTemplate", context);

        System.out.println("E: " + "James was seen with John at London Bridge today at 0900h");
        System.out.println("A: " + templates.render(secureMessage));
    }

    public static void test2() {
        Templates templates = new Templates(
                "reportTemplate", "{{ person1 }} was seen with {{ person2 }} at {{> locationTemplate }} today at {{ time1 }}",
                "locationTemplate", "{{ unit }}-{{ number }} {{ street }} {{ direction }} {{ city }} {{ province }}");

        Context context = new Context(
                "person1", "Mario",
                "person2", "George",
                "time1", "0900h",
                "unit", "3",
                "number", "85",

                "street", "Lawrence Ave",
                "direction", "S",
                "city", "Miami",
                "province", "Florida");

        SecureMessage secureMessage = new SecureMessage("reportTemplate", context);

        System.out.println("E: " + "Mario was seen with George at 3-85 Lawrence Ave S Miami Florida today at 0900h");
        System.out.println("A: " + templates.render(secureMessage));
    }

    public static void test3() {
        Templates templates = new Templates(
                "reportTemplate", "{{> knownPersonTemplate }} was seen with {{ person2 }} at {{ outpost1 }} today at {{ time1 }}",
                "locationTemplate", "{{ unit }}-{{ number }} {{ street }} {{ direction }} {{ city }} {{ province }}",
                "knownPersonTemplate", "{{ firstName }} {{ lastName }} who lives at {{> locationTemplate }}");

        Context context = new Context(
                "firstName", "Lucy",
                "lastName", "Pepperton",
                "unit", "300",
                "number", "105",
                "street", "West Broadway",
                "direction", "W",
                "city", "New York",
                "province", "NY",
                "person2", "Veronica",
                "outpost1", "Tango Foxtrot",
                "time1", "1930h");

        SecureMessage secureMessage = new SecureMessage("reportTemplate", context);

        System.out.println("E: " + "Lucy Pepperton who lives at 300-105 West Broadway W New York NY was seen with Veronica at Tango Foxtrot today at 1930h");
        System.out.println("A: " + templates.render(secureMessage));
    }

    public static void test4() {
        Templates templates = new Templates(
                "reportTemplate", "{{> knownPersonTemplate }} was seen with {{ person2 }} at {{ outpost1 }} today at {{ time1 }}",
                "locationTemplate", "{{ address1.unit }}-{{ address1.number }} {{ address1.street }} {{ address1.direction }} {{ address1.city }} {{ address1.province }}",
                "knownPersonTemplate", "{{ person1.firstName }} {{ person1.lastName }} who lives at {{> locationTemplate }}");

        Context context = new Context(
                "person1", new Object[] {
                    "firstName", "Lucy",
                    "lastName", "Pepperton"
                },
                "address1", new Object[] {
                    "unit", "300",
                    "number", "105",
                    "street", "West Broadway",
                    "direction", "W",
                    "city", "New York",
                    "province", "NY"
                },
                "person2", "Veronica",
                "outpost1", "Tango Foxtrot",
                "time1", "1930h");

        SecureMessage secureMessage = new SecureMessage("reportTemplate", context);

        System.out.println("E: " + "Lucy Pepperton who lives at 300-105 West Broadway W New York NY was seen with Veronica at Tango Foxtrot today at 1930h");
        System.out.println("A: " + templates.render(secureMessage));
    }
}
