import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testMainRace() {
        Horse horse1 = new Horse("Champion", 10.0);
        Horse horse2 = new Horse("Challenger", 8.0);
        List<Horse> horses = Arrays.asList(horse1, horse2);

        Hippodrome hippodrome = new Hippodrome(horses);

        for (int i = 0; i < 5; i++) {
            hippodrome.move();
        }

        Horse winner = hippodrome.getWinner();
        assertEquals(horse1, winner);
    }

    @Test
    public void testMainWithZeroSpeed() {
        Horse slowHorse = new Horse("Slowpoke", 0.0);
        List<Horse> horses = Arrays.asList(slowHorse);

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        assertEquals(0.0, slowHorse.getDistance(), 0.001);
    }

    @Test
    public void testMainWithEmptyHippodrome() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(new ArrayList<>());
        });
    }
}
