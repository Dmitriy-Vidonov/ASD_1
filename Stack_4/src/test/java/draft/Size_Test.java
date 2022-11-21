package draft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class Size_Test {

    Stack arrTest = new Stack();
    Stack emptyStack = new Stack();

    @org.junit.jupiter.api.Test
    @DisplayName("1) Проверка нулевого и заполненного стека")
    void size() throws Exception
    {
        arrTest.push(1);
        arrTest.push(2);
        arrTest.push(3);

        Assertions.assertTrue(arrTest.size() == 3);
        Assertions.assertTrue(emptyStack.size() == 0);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("2) Проверка стека на 100 000 элементов")
    void size_BigStack() throws Exception
    {
        Stack testStack = MethodsForTest.genStack(100_000);
        Assertions.assertTrue(testStack.size() == 100_000);
    }

}