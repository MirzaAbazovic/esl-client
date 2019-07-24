package org.freeswitch.esl.client.inbound;

import org.freeswitch.esl.client.internal.IModEslApi;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ClientTest {

    public static final String FS_IP = "127.0.0.1";
    public static final int FS_PORT = 8021;
    public static final String FS_PASS = "ClueCon";
    public static final int TIMEOUT_SECONDS = 1;


    @Test
    public void addEventListener() throws InboundConnectionFailure {
        Client client = new Client();
        TestEventListener listener = new TestEventListener();
        client.addEventListener(listener);
        client.connect(new InetSocketAddress(FS_IP, FS_PORT), FS_PASS, TIMEOUT_SECONDS);
        client.setEventSubscriptions(IModEslApi.EventFormat.PLAIN, "all");
        CompletableFuture<EslEvent> status = client.sendBackgroundApiCommand("status", "");
        await().atMost(300, MILLISECONDS).until(() -> listener.getEslEvent() != null);
        client.close();
    }

    @Test
    public void addConnectionListener() throws InboundConnectionFailure {
        Client client = new Client();
        TestConnectionListener listener = new TestConnectionListener();
        client.addConnectionListener(listener);
        client.connect(new InetSocketAddress(FS_IP, FS_PORT), FS_PASS, TIMEOUT_SECONDS);
        assertThat(listener.getAuthOk(), equalTo(true));
        client.close();
        await().atMost(200, MILLISECONDS).until(() -> listener.getDisconectedCalled().equals(true));
    }


    @Test
    public void setCallbackExecutor() {
        //TODO
    }

    @Test
    public void connect() throws InboundConnectionFailure {
        Client client = new Client();
        client.connect(new InetSocketAddress(FS_IP, FS_PORT), FS_PASS, TIMEOUT_SECONDS);
        assertThat(client.canSend(), equalTo(true));
    }

    @Test
    public void sendApiCommand() {
        //TODO
    }

    @Test
    public void sendBackgroundApiCommand() {
        //TODO
    }

    @Test
    public void setEventSubscriptions() {
        //TODO
    }

    @Test
    public void setEventNoSubscriptions() {
        //TODO
    }

    @Test
    public void cancelEventSubscriptions() {
        //TODO
    }

    @Test
    public void addEventFilter() {
        //TODO
    }

    @Test
    public void deleteEventFilter() {
        //TODO
    }

    @Test
    public void sendMessage() {
        //TODO
    }

    @Test
    public void sendAsyncMessage() {
        //TODO
    }

    @Test
    public void setLoggingLevel() {
        //TODO
    }

    @Test
    public void cancelLogging() {
        //TODO
    }

    @Test
    public void close() throws InboundConnectionFailure {
        Client client = new Client();
        client.connect(new InetSocketAddress(FS_IP, FS_PORT), FS_PASS, TIMEOUT_SECONDS);
        assertThat(client.canSend(), equalTo(true));
        client.close();
        await().atMost(200, MILLISECONDS).until(() -> client.canSend() == false);
    }
}