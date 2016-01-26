package webSockets;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by AndriiUSER on 06.12.2015.
 */
@ServerEndpoint("/hello")
public class HelloWebSocket {

    @OnOpen
    public void greetTheClient (Session session){
        try {
            session.getBasicRemote().sendText("Hello stranger");
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
