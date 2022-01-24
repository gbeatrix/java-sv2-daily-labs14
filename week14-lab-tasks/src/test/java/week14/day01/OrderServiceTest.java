package week14.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    void init() {
        orderService = new OrderService();

        Product p1 = new Product("Tv", "IT", 2000);
        Product p2 = new Product("Laptop", "IT", 2400);
        Product p3 = new Product("Phone", "IT", 400);
        Product p4 = new Product("Lord of The Rings", "Book", 20);
        Product p5 = new Product("Harry Potter Collection", "Book", 120);

        Order o1 = new Order("pending", LocalDate.of(2021, 06, 07));
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p5);

        Order o2 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o2.addProduct(p3);
        o2.addProduct(p1);
        o2.addProduct(p2);

        Order o3 = new Order("pending", LocalDate.of(2021, 06, 07));
        o3.addProduct(p1);
        o3.addProduct(p2);
        o3.addProduct(p5);

        Order o4 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o4.addProduct(p3);
        o4.addProduct(p1);
        o4.addProduct(p2);

        Order o5 = new Order("pending", LocalDate.of(2021, 06, 07));
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p5);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void testGetNumberOfOrders() {
        assertEquals(3L, orderService.getNumberOfOrders("pending"));
        assertEquals(2L, orderService.getNumberOfOrders("on delivery"));
        assertEquals(0L, orderService.getNumberOfOrders("cancelled"));
    }

    @Test
    void testGetOrdersBetweenDates() {
        assertEquals(3, orderService.getOrdersBetweenDates(LocalDate.of(2021, 6, 2), LocalDate.of(2021, 6, 8)).size());
        assertEquals(2, orderService.getOrdersBetweenDates(LocalDate.of(2021, 5, 2), LocalDate.of(2021, 6, 2)).size());
    }

    @Test
    void testExistsAnyOrderWithLessProductsThan() {
        assertTrue(orderService.existsAnyOrderWithLessProductsThan(4));
        assertFalse(orderService.existsAnyOrderWithLessProductsThan(3));

        Order o6 = new Order("pending", LocalDate.now());
        o6.addProduct(new Product("Lord of The Rings", "Book", 20));
        orderService.saveOrder(o6);
        assertTrue(orderService.existsAnyOrderWithLessProductsThan(3));
        assertFalse(orderService.existsAnyOrderWithLessProductsThan(1));
    }

    @Test
    void testGetOrderWithMostProducts() {
        assertEquals(3, orderService.getOrderWithMostProducts().getProducts().size());

        orderService.getOrders().get(3).addProduct(new Product("Lord of The Rings", "Book", 20));
        assertEquals(4, orderService.getOrderWithMostProducts().getProducts().size());
    }

    @Test
    void testGetOrdersByCategory() {
        assertEquals(3, orderService.getOrdersByCategory("Book").size());

        orderService.getOrders().get(3).addProduct(new Product("Lord of The Rings", "Book", 20));
        assertEquals(4, orderService.getOrdersByCategory("Book").size());
    }
}
