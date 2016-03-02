package shouty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maf on 26.02.2016.
 */
public class Network {
    private final List<Person> listeners = new ArrayList<>();

    
    public void subscribe(Person person) {
        listeners.add(person);
    }

    public void broadcast(String message) {
        for (Person listener:listeners){
            listener.hear(message);
        }
    }
}
