package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Streets {
    private Map<String, List<Integer>> streetView = new HashMap<>();

    public Map<String, List<Integer>> getStreetView() {
        return streetView;
    }

    public void readFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String street = parts[0];
                int sold = Integer.parseInt(parts[1]);
                streetView.putIfAbsent(street, new ArrayList<>());
                streetView.get(street).add(lastNumber(sold, street) + 2);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File not found", e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong format", e);
        }
    }

    private int lastNumber(int mod, String street) {
        return streetView.get(street).stream()
                .mapToInt(k -> k)
                .filter(k -> k % 2 == mod)
                .max().orElse(-mod);
    }

    // Utcanév alapján kérdezzük le a páros házszámok darabszámát
    public long numberOfEvenNumbersByStreet(String street) {
        return streetView.get(street).stream()
                .filter(k -> k % 2 == 0)
                .count();
    }
}
