package week14.day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Határozd meg a rendelések darabszámát egy paraméterként kapott státusz alapján
    public long getNumberOfOrders(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .count();
    }

    // Add vissza azokat a rendeléseket, amik két dátum között vannak.
    public List<Order> getOrdersBetweenDates(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(order -> order.getOrderDate().isAfter(from) && order.getOrderDate().isBefore(to))
                .toList();
    }

    // Van-e olyan rendelés amiben kevesebb mint paraméternyi termék található.
    public boolean existsAnyOrderWithLessProductsThan(int number){
        return orders.stream()
                .anyMatch(order -> order.getProducts().size() < number);
    }

    // Keresd meg azt a rendelést, amiben a legtöbb termék található.
    public Order getOrderWithMostProducts(){
        return orders.stream()
                .max(Comparator.comparingInt(order -> order.getProducts().size()))
                .orElseThrow();
    }

    // (Nehezebb) Gyűjtsük ki azokat a rendeléseket, amiben van megadott kategóriájú termék.
    public List<Order> getOrdersByCategory(String category){
        return orders.stream()
                .filter(
                        order -> order.getProducts().stream().anyMatch(
                                product -> product.getCategory().equals(category)
                        )
                )
                .toList();
    }
}
