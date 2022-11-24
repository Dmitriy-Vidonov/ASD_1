import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class tests {

    Deque testDeq = new Deque<>();
    Deque emptyDeq = new Deque<>();

    @BeforeEach
    void setUp() throws Exception
    {
        testDeq.addTail(1);
        testDeq.addTail(2);
        testDeq.addTail(3);
    }

    @Test
    @DisplayName("1) addFront not empty")
    void addFront_NotEmpty() throws Exception
    {
        testDeq.addFront(10);

        Assertions.assertTrue(testDeq.size() == 4);
        Assertions.assertTrue(testDeq.removeFront().equals(10));
    }

    @Test
    @DisplayName("2) addFront empty")
    void addFront_Empty() throws Exception
    {
        emptyDeq.addFront(10);

        Assertions.assertTrue(emptyDeq.size() == 1);
        Assertions.assertTrue(emptyDeq.removeFront().equals(10));
    }

    @Test
    @DisplayName("3) addTail not empty")
    void addTail_NotEmpty() throws Exception
    {
        testDeq.addTail(10);

        Assertions.assertTrue(testDeq.size() == 4);
        Assertions.assertTrue(testDeq.removeTail().equals(10));
    }

    @Test
    @DisplayName("4) addTail empty")
    void addTail_Empty() throws Exception
    {
        emptyDeq.addTail(10);

        Assertions.assertTrue(emptyDeq.size() == 1);
        Assertions.assertTrue(emptyDeq.removeTail().equals(10));
    }

    @Test
    @DisplayName("5) removeFront not empty")
    void removeFront_NotEmpty() throws Exception
    {
        testDeq.removeFront();

        Assertions.assertTrue(testDeq.size() == 2);
        Assertions.assertTrue(testDeq.removeFront().equals(2));
    }

    @Test
    @DisplayName("6) removeFront empty")
    void removeFront_Empty() throws Exception
    {
        Assertions.assertTrue(emptyDeq.removeFront() == null);
    }

    @Test
    @DisplayName("7) removeTail not empty")
    void removeTail_NotEmpty() throws Exception
    {
        testDeq.removeTail();

        Assertions.assertTrue(testDeq.size() == 2);
        Assertions.assertTrue(testDeq.removeTail().equals(2));
    }

    @Test
    @DisplayName("8) removeTail empty")
    void removeTail_Empty() throws Exception
    {
        Assertions.assertTrue(emptyDeq.removeTail() == null);
    }

}