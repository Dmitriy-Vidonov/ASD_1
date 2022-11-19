import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.text.StyledEditorKit;

import static org.junit.jupiter.api.Assertions.*;

class Insert_Remove_Test {

    DynArray<Integer> testArr = new DynArray<Integer>(Integer.class);

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception
    {
        testArr.append(10);
        testArr.append(20);
        testArr.append(30);
        testArr.append(40);
        testArr.append(50);
        testArr.append(60);
        testArr.append(70);
        testArr.append(80);
        testArr.append(90);
        testArr.append(100);
        testArr.append(110);
        testArr.append(120);
        testArr.append(130);
        testArr.append(140);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("1) Вставка элемента, когда размер буфера не превышен")
    void insert_ifCapacityNotAtLimit() throws Exception
    {
        testArr.append(100);
        Assertions.assertTrue(testArr.getItem(14) == 100);
        Assertions.assertTrue(testArr.capacity == 16);
        Assertions.assertTrue(testArr.count == 15);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("2) Вставка элемента, когда размер буфера превышен")
    void insert_ifCapacityAtLimit() throws Exception
    {
        testArr.append(150);
        testArr.append(160);
        testArr.append(170);

        Assertions.assertTrue(testArr.getItem(16) == 170);
        Assertions.assertTrue(testArr.capacity == 32);
        Assertions.assertTrue(testArr.count == 17);
    }

    @Test()
    @DisplayName("3) Вставка элемента в недопустимую позицию")
    void insert_WrondIndex() throws Exception
    {
        assertThrows(IndexOutOfBoundsException.class,
                ()->{
                    testArr.insert(10, -1);
                    });

        assertThrows(IndexOutOfBoundsException.class,
                ()->{
                    testArr.insert(10, testArr.capacity+1);
                });
    }

    @org.junit.jupiter.api.Test
    @DisplayName("4) Удаление элемента, когда размер буфера остается прежним")
    void remove_CapacitySame() throws Exception
    {
        testArr.remove(13);
        Assertions.assertTrue(testArr.getItem(13) == null);
        Assertions.assertTrue(testArr.capacity == 16);
        Assertions.assertTrue(testArr.count == 13);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("5) Удаление элемента, когда размер буфера понижается")
    void remove_CapacityShrinks() throws Exception
    {
        testArr.append(150);
        testArr.append(160);
        testArr.append(170);

        Assertions.assertTrue(testArr.capacity == 32);
        testArr.remove(0);
        Assertions.assertTrue(testArr.capacity == 21);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("6) Удаление элемента с неверным индексом")
    void remove_WrongIndex() throws Exception
    {
        assertThrows(IndexOutOfBoundsException.class,
                ()->{
                    testArr.remove(-1);
                });

        assertThrows(IndexOutOfBoundsException.class,
                ()->{
                    testArr.remove(testArr.capacity);
                });
    }
}