package org.freeswitch.esl.client.inbound;

import org.freeswitch.esl.client.internal.Context;
import org.freeswitch.esl.client.transport.event.EslEvent;

public class TestEventListener implements IEslEventListener {

    private EslEvent eslEvent;

    public EslEvent getEslEvent() {
        return eslEvent;
    }

    @Override
    public void onEslEvent(Context ctx, EslEvent event) {
        this.eslEvent = event;
    }
}
