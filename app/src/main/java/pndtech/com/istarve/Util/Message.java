package pndtech.com.istarve.Util;
/*
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;*/

public class Message {
    private final String HOST = "localhost";
    private final int PORT = 5672;
    private final String USERNAME = "istarve";
    private final String PASSWORD = "07092302";
    private final String VIRTUAL_HOST = "";
    private static Message instance;

   /* private String uri ;

    private Message() {
        this(null);
    }

    private Message(String uri) {
        this.uri = uri;
        if (this.uri == null || this.uri.isEmpty()) {

            this.uri = String.format("amqp://%s:%s@%s:%s", USERNAME, PASSWORD, HOST, PORT);
        }
    }

    public static Message getInstance(String URI) {
        return (instance == null) ? new Message(URI) : instance;
    }

    public static Message getInstance() {
        return getInstance("");
    }

    protected Connection getConnect() throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(this.uri);
        return factory.newConnection();
    }

    public void sendMsg(String msg, String queueRota) {
        try (Connection conn = getConnect()) {

            Channel channel = conn.createChannel();
            channel.queueDeclare(queueRota, false, false, true, null);
            channel.basicPublish("", queueRota, null, msg.getBytes());
        } catch (IOException e) {
            System.out.print("Erro-01");
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.print("Erro-02");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public void setUri(String uri) {
        this.uri = uri;
    }*/
}
