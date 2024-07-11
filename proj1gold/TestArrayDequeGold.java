import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDequeGold {
    /**
     * Example test that verifies correctness of the StudentArrayDeque. The main
     * point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testArraydeque() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> example1 = new ArrayDequeSolution<>();

        for (int i = 0; i < 20; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.25 && numberBetweenZeroAndOne >= 0) {
                sad1.addLast(i);
                Integer expected = i;
                example1.addLast(i);
                Integer actual = i;
                assertEquals("addLast(" + i + ")\n", expected, actual);
            } else if (0.25 <= numberBetweenZeroAndOne && numberBetweenZeroAndOne <= 0.5) {
                Integer expected = i;
                sad1.addFirst(i);
                example1.addFirst(i);
                Integer actual = i;
                assertEquals("addFirst(" + i + ")\n", expected, actual);
            } else if (numberBetweenZeroAndOne > 0.5 && numberBetweenZeroAndOne <= 0.75) {
                if (sad1.size() == 0) {
                    break;
                } else {
                    Integer expected = sad1.removeFirst();
                    Integer actual = example1.removeFirst();
                    assertEquals("removeFirst()", expected, actual);
                }

            } else if (numberBetweenZeroAndOne > 0.75 && numberBetweenZeroAndOne <= 1) {
                if (sad1.size() == 0) {
                    break;
                } else {
                    Integer expected = sad1.removeLast();
                    Integer actual = example1.removeLast();
                    assertEquals("removeLast()", expected, actual);
                }
            }

        }

    }

}
