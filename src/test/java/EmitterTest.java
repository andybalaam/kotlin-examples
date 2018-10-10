import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmitterTest {
    @Test
    public void Acme_message_emits_AcmeEvent() {
        TrackingReceiver receiver = new TrackingReceiver();
        Emitter e = new Emitter();
        e.handleMessage(
            receiver,
            new Message("345")
                .forCustomer("Acme")
                .withTo("012")
        );

        assertThat(
            receiver.lastEvent,
            instanceOf(Emitter.AcmeEvent.class)
        );
    }

    private class TrackingReceiver implements Emitter.Receiver {
        private Emitter.Event lastEvent = null;

        @Override
        public void sendEvent(Emitter.Event event) {
            this.lastEvent = event;
        }
    }
}
