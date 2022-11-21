package draft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pop_Test {

    Stack testStack = new Stack();

    @BeforeEach
    void setUp() throws Exception
    {
        testStack = MethodsForTest.genStack(10);
    }

    @Test
    @DisplayName("1) Извлечение по очереди, непустой стек")
    void pop() throws Exception
    {
        Assertions.assertTrue(testStack.pop().equals(9));
        Assertions.assertTrue(testStack.pop().equals(8));
        Assertions.assertTrue(testStack.pop().equals(7));
    }

    @Test
    @DisplayName("2) Извлечение из пустого стека")
    void pop_EmptyStack() throws Exception
    {
        Stack emptyStack = new Stack();
        Assertions.assertTrue(emptyStack.pop() == null);
    }

    @Test
    @DisplayName("3) Извлечение из большого стека")
    void pop_BigStack() throws Exception
    {
        Stack BigStack = MethodsForTest.genStack(100000);
        Assertions.assertTrue(BigStack.pop().equals(99999));
    }

}