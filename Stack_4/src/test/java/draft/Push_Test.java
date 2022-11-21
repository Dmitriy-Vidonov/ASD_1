package draft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Push_Test {

    Stack emptyStack = new Stack<>();
    Stack testStack = new Stack<>();

    @BeforeEach
    void setUp() throws Exception
    {
        testStack.push(10);
        testStack.push(20);
        testStack.push(30);
    }

    @Test
    @DisplayName("1) push в пустой стек")
    void push() throws Exception
    {
        emptyStack.push(10);

        Assertions.assertTrue(emptyStack.size() == 1);
        Assertions.assertTrue(emptyStack.pop().equals(10));
    }

    @Test
    @DisplayName("2) push в непустой стек")
    void push_NonEmptyStack() throws Exception
    {
        testStack.push(50);

        Assertions.assertTrue(testStack.size() == 4);
        Assertions.assertTrue(testStack.pop().equals(50));
    }

    @Test
    @DisplayName("3) push в большой стек")
    void push_HugeStack() throws Exception
    {
        testStack = MethodsForTest.genStack(100_000);
        testStack.push(10);

        Assertions.assertTrue(testStack.size() == 100_001);
        Assertions.assertTrue(testStack.pop().equals(10));
    }

}