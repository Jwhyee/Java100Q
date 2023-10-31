package study.impl.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.impl.list.array.ArrayList;
import study.impl.list.linked.LinkedList;

import static org.junit.Assert.assertTrue;

public class ListTest {
    @Test
    @DisplayName("LinkedList 테스트")
    void linkedTest() {
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= 4; i++) {
            list.add(i);
        }

        System.out.println(list);

        assertTrue(list.get(2) == 3);
    }

    @Test
    @DisplayName("ArrayList 테스트")
    void arrayTest() {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        System.out.println(list);

        assertTrue(list.get(3) == 4);


    }
}
