import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmitterKTest {
    @Test
    public void Acme_message_emits_AcmeEvent() {
        TrackingReceiver receiver = new TrackingReceiver();
        EmitterK e = new EmitterK();
        e.handleMessage(
            receiver,
            new Message("345")
                .forCustomer("Acme")
                .withTo("012")
        );

        assertThat(
            receiver.lastEvent,
            instanceOf(EmitterK.AcmeEvent.class)
        );
    }

    private class TrackingReceiver implements EmitterK.Receiver {
        private EmitterK.Event lastEvent = null;

        @Override
        public void sendEvent(EmitterK.Event event) {
            this.lastEvent = event;
        }
    }
}
