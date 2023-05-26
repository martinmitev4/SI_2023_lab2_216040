package mk.ukim.finki;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private final User user1 = new User("user1", "pass", "email1@gmail.com" ) ;
    private final User user2 = new User("user2", "pass", "email2@gmail.com" ) ;
    private final User user3 = new User("user3", "pass12345", "email3@gmail.com" ) ;
    private final List<User> users = new ArrayList<>();

    @Test
    void EveryBranch() {
        RuntimeException ex;
        users.add(user1);
        users.add(user2);
        users.add(user3);

        ex = assertThrows(RuntimeException.class, ()->SILab2.function(null, users ));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        assertEquals(false, SILab2.function(new User("user", "pass12345", "emailtest@gmail.com"), users ));

        assertEquals(false, SILab2.function(new User(null, "pass", "emai"), users ));

        assertEquals(false, SILab2.function(new User("user1", "pass 12345", "email1@gmail.com"), users ));

        assertEquals(false, SILab2.function(new User("user1", "pass12345#", "email1@gmail.com"), users ));

        assertEquals(true, SILab2.function(new User("user4", "pass12345#", "email4@gmail.com"), users ));
    }


    @Test
    void MultipleConditions() {
        RuntimeException ex;
        users.add(user1);
        users.add(user2);
        users.add(user3);

        ex = assertThrows(RuntimeException.class, ()->SILab2.function(null, users ));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function(new User("user", null, "emai"), users ));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function(new User("user", "pass", null), users ));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        assertEquals(false, SILab2.function(new User(null, "pass", "emai"), users ));

    }

}