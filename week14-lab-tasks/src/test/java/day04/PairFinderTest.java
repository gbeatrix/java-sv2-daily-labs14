package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {
    @Test
    void testPairFinder() {
        assertEquals(0, PairFinder.findPairs(new int[]{5, 1, 4, 8}));
        assertEquals(1, PairFinder.findPairs(new int[]{5, 1, 4, 5}));
        assertEquals(4, PairFinder.findPairs(new int[]{7, 1, 5, 7, 3, 3, 5, 7, 6, 7}));
    }
}