import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HippodromeTest {
    private Hippodrome hippodrome;
    private List<Horse> horses;

    @BeforeEach
    void setUp() {
        horses = new ArrayList<>();
        horses.add(new Horse("Horse1", 3.0));
        horses.add(new Horse("Horse2", 3.0));
        hippodrome = new Hippodrome(horses);
    }

    @Test
    void testValidConstruction() {
        assertNotNull(hippodrome);
        assertEquals(2, hippodrome.getHorses().size());
    }

    @Test
    void testInvalidConstruction() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    }

    @Test
    void testMovement() {
        double initialDistance = horses.get(0).getDistance();
        hippodrome.move();
        assertTrue(horses.get(0).getDistance() > initialDistance);
    }

    @Test
    void testWinnerDetermination() {
        Horse fastHorse = new Horse("Fast", 10.0);
        Horse slowHorse = new Horse("Slow", 5.0);
        List<Horse> raceHorses = Arrays.asList(fastHorse, slowHorse);
        Hippodrome race = new Hippodrome(raceHorses);

        for(int i = 0; i < 10; i++) {
            race.move();
        }

        assertEquals(fastHorse, race.getWinner());
    }
}
