
esl-client
==============================================================================


**esl-client** is a Java-based Event Socket Library for the
[FreeSWITCH](https://freeswitch.org/) project.

This project is a fork of the unmaintained, original project at
<https://freeswitch.org/stash/projects/FS/repos/freeswitch-contrib/browse/dvarnes/java/esl-client>

Status: In Progress...


Example
------------------------------------------------------------------------------

```java
package com.ecovate.freeswitch.lb;

import com.google.common.base.Throwables;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.inbound.IEslEventListener;
import org.freeswitch.esl.client.internal.IModEslApi.EventFormat;
import org.freeswitch.esl.client.outbound.Context;
import org.freeswitch.esl.client.outbound.IClientHandler;
import org.freeswitch.esl.client.outbound.IClientHandlerFactory;
import org.freeswitch.esl.client.outbound.SocketClient;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class FreeSwitchEventListener {

  private static Logger logger = LoggerFactory.getLogger(FreeSwitchEventListener.class);

  public static void main(String[] args) {
    try {

      final Client inboudClient = new Client();
      inboudClient.connect(new InetSocketAddress("localhost", 8021), "ClueCon", 10);
      inboudClient.addEventListener(new IEslEventListener() {
        @Override
        public void onEslEvent(EslEvent eslEvent) {

        }
      });
      inboudClient.setEventSubscriptions(EventFormat.PLAIN, "all");

      final SocketClient outboundServer = new SocketClient(
        new InetSocketAddress("localhost", 8084),
        new IClientHandlerFactory() {
          @Override
          public IClientHandler createClientHandler() {
            return new IClientHandler() {
              @Override
              public void handleEslEvent(Context context, EslEvent eslEvent) {
              }

              @Override
              public void onConnect(Context context, EslEvent eslEvent) {
              }
            };
          }
        });


    } catch (Throwable t) {
      Throwables.propagate(t);
    }
  }

}
```

Authors
------------------------------------------------------------------------------

- [Dan Cunningham](mailto:dan.cunningham@readytalk.com)
- [Dave Rusek](mailto:dave.rusek@readytalk.com)
- [David Varnes](mailto:david.varnes@gmail.com) (original author)
- [Tobias Bieniek](https://github.com/Turbo87)

License
------------------------------------------------------------------------------

**esl-client** is licensed under the [Apache License, version 2](LICENSE).

