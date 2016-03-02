package shouty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maf on 24.02.2016.
 */
public class Person {
    private final List <String> messagesHeard = new ArrayList<>();
    private final Network network;

    public Person(Network network) {
        this.network = network;
        network.subscribe (this);
    }
    public List<String> getMessagesHeard() {
        return messagesHeard;
    }

    public void shout(String message) {
        network.broadcast(message);
    }

    public void hear(String message){
        messagesHeard.add(message);
    }


}
