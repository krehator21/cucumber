package shouty;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.verification.VerificationMode;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PersonTest {
    private final Network network = mock(Network.class);

    @Test
    public void it_subscribes_to_the_network() {
        Person person = new Person(network, 100);
        verify(network).subscribe(person);
    }

    @Test
    public void it_has_a_location() {
        Person person = new Person(network, 100);
        assertEquals(100, person.getLocation());
    }

    @Test
    public void broadcasts_shouts_to_the_network() {
        String message = "Free bagels!";
        Person sean = new Person(network, 0);
        sean.shout(message);
        verify(network).broadcast(message, sean);
    }

    @Test
    public void remembers_messages_heard() {
        String message = "Free bagels!";
        Person lucy = new Person(network, 100);
        lucy.hear(message);
        assertEquals(asList(message), lucy.getMessagesHeard());
    }

    // Charging for shouts
    @Test
    public void deducts_5_credits_when_the_shouter_mentions_the_word_buy (){
        Person sean = new Person(network, 0);
        sean.setCredits(100);
        sean.shout("here is the messagecontaining the word buy");
        assertEquals (95, sean.getCredits());
    }

    @Test
    public void deducts_2_credits_when_shouters_message_is_over_180_chars (){
        Person sean = new Person(network, 0);
        sean.setCredits(100);
        String overLongMessage = String.join("", Collections.nCopies(181, "x"));
        assertTrue(overLongMessage.length() > 180);
        sean.shout(overLongMessage);
        assertEquals(98, sean.getCredits());
    }

    @Test
    public void does_not_broadcast_messages_over_180_chars_when_shouter_has_insufficient_credits(){
        Person sean = new Person(network, 0);
        sean.setCredits(1);
        String overLongMessage = String.join("", Collections.nCopies(181, "x"));
        sean.shout(overLongMessage);
        verify(network, never()).broadcast(overLongMessage, sean);
    }

    @Test
    public void only_charge_once_per_shout_for_multiple_mentions_of_buy (){
        Person sean = new Person(network, 0);
        sean.setCredits(100);
        sean.shout("buy, buy, buy");

        assertEquals(95, sean.getCredits());
    }
}
