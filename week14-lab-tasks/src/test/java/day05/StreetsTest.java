package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreetsTest {
    Streets streets;

    @BeforeEach
    void init(){
        streets = new Streets();
        streets.readFile(Path.of("src/main/resources/streets.txt"));
    }

    @Test
    void testReadFile(){
        assertEquals(Map.of("Kossuth", List.of(2,4,1,3,5,7), "Petofi", List.of(1,2,4,3,6)), streets.getStreetView());
    }

    @Test
    void testNumberOfEvenNumbersByStreet(){
        assertEquals(2L, streets.numberOfEvenNumbersByStreet("Kossuth"));
        assertEquals(3L, streets.numberOfEvenNumbersByStreet("Petofi"));
    }
}