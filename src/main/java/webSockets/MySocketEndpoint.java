package webSockets;


import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by AndriiUSER on 06.12.2015.
 */
@ServerEndpoint("/hello")
public class MySocketEndpoint extends Endpoint{
    @Override
    public void onOpen(Session session, EndpointConfig config) {

    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {

    }

    @Override
    public void onError(Session session, Throwable thr) {

    }

}
