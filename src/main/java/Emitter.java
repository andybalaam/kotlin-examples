import java.util.HashMap;
import java.util.Map;

public class Emitter {
    private static final Map<String, String> urls = buildUrls();
    private static Map<String,String> buildUrls() {
        Map<String, String> ret = new HashMap<>();
        ret.put("012", "http://example.com");
        return ret;
    }

    public void handleMessage(
        Receiver receiver,
        Message m
    ) {
        long start, end;

        // ...

        start = System.currentTimeMillis();
        String url = urls.get(m.to);

        if (url == null) {
            System.out.println("No url!");
            return;
        }

        for(start = 0; start < 3; start++) {
            // ...
        }

        // ...

        end = System.currentTimeMillis();
        System.out.println(m.id + ": " + (end-start));

        // ...

        Event event;
        if (m.customer.contains("Acme")) {
            event = new AcmeEvent(m);
        }
        else {
            event = new NormalEvent(m);
        }
        receiver.sendEvent(event);

        // ...
    }

    public static class Event {
    }

    public class AcmeEvent extends Event {
        public AcmeEvent(Message m) {
        }
    }

    private class NormalEvent extends Event {
        public NormalEvent(Message m) {
        }
    }

    public interface Receiver {
        void sendEvent(Event event);
    }
}
