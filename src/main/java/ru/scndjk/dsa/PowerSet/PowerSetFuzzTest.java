package ru.scndjk.dsa.PowerSet;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class PowerSetFuzzTest {
    private static Instant start;
    private static Instant end;

    @BeforeAll
    public static void startTimer() {
        start = Instant.now();
    }

    @Test
    public void testSetOperations() {
        PowerSet powerSet1 = new PowerSet();
        PowerSet powerSet2 = new PowerSet();
        Random random = new Random();

        for (int i = 0; i < 20_000; i += 1) {
            String value = String.valueOf(random.nextInt());
            powerSet1.put(value);
            powerSet2.put(value);
        }

        PowerSet intersection = powerSet1.intersection(powerSet2);
        PowerSet union = powerSet1.union(powerSet2);
        PowerSet difference = powerSet1.difference(powerSet2);
    }

    @AfterAll
    public static void stopTimer() {
        end = Instant.now();
        Duration timeTaken = Duration.between(start, end);
        System.out.println("Test execution time: " + timeTaken.toMillis() + " ms");
    }
}
