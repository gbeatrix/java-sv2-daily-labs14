package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreetsTest {
    @Test
    void testReadFile(){
        Streets streets = new Streets();
        streets.readFile(Path.of("src/main/resources/streets.txt"));
        assertEquals(Map.of("Kossuth", List.of(2,4,1,3,5,7), "Petofi", List.of(1,2,4,3,6)), streets.getStreetView());
    }
}