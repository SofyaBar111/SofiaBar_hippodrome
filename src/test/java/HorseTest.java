import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HorseTest {

    @Test
    public void testValidHorseCreation() {
        Horse horse = new Horse("BlackBeauty", 10.0);
        assertEquals("BlackBeauty", horse.getName());
        assertEquals(10.0, horse.getSpeed(), 0.001);
        assertEquals(0.0, horse.getDistance(), 0.001);
    }

    @Test
    public void testInvalidHorseCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 10.0));
        assertThrows(IllegalArgumentException.class, () -> new Horse("", 10.0));
        assertThrows(IllegalArgumentException.class, () -> new Horse("BlackBeauty", -5.0));
    }

    @Test
    public void testBoundaryConditions() {
        Horse horse = new Horse("ZeroSpeed", 0.0);
        horse.move();
        assertEquals(0.0, horse.getDistance(), 0.001);
    }

    @Test
    public void testHorseMovement() {
        Horse horse = new Horse("FastRunner", 10.0);
        double initialDistance = horse.getDistance();
        horse.move();
        assertTrue(horse.getDistance() > initialDistance);
    }

    @Test
    public void testHorseInteractionWithHippodrome() {
        Horse horse1 = new Horse("FastOne", 12.0);
        Horse horse2 = new Horse("SlowOne", 6.0);
        List<Horse> horses = Arrays.asList(horse1, horse2);

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        assertTrue(horse1.getDistance() > horse2.getDistance());
    }
}
