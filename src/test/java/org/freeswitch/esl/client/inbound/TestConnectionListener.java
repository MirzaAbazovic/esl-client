package org.freeswitch.esl.client.inbound;

public class TestConnectionListener implements IEslConnectionListener {

    private Boolean isAuthOk;
    private Boolean isDisconectedCalled;


    public Boolean getAuthOk() {
        return isAuthOk;
    }

    public Boolean getDisconectedCalled() {
        return isDisconectedCalled;
    }


    @Override
    public void onauth(boolean isok) {
        isAuthOk = isok;
    }

    @Override
    public void ondisconnected() {
        isDisconectedCalled = true;
    }
}
