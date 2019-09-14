package pndtech.com.istarve;

import org.junit.Test;

import pndtech.com.istarve.Util.Message;

public class TestMessage {
    @Test
    public void connection(){
        Message message = Message.getInstance();
        message.sendMsg("Phelipp @@","Pedido");
    }
}
