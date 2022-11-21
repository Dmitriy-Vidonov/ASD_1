package draft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Peek_Test {

    Stack testStack = new Stack<>();
    Stack emptyStack = new Stack<>();
    Stack BigStack = new Stack<>();

    @BeforeEach
    void setUp() throws Exception
    {
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);

        BigStack = MethodsForTest.genStack(100_000);
    }

    @Test
    @DisplayName("1) Небольшой заполненный стек")
    void peek() throws Exception
    {
        Assertions.assertTrue(testStack.peek().equals(30));
    }

    @Test
    @DisplayName("2) Пустой стек")
    void peek_EmptyStack() throws Exception
    {
        Assertions.assertTrue(emptyStack.peek() == null);
    }

    @Test
    @DisplayName("3) Большой стек")
    void peek_BigStack() throws Exception
    {
        Assertions.assertTrue(BigStack.peek().equals(99_999));
    }

}