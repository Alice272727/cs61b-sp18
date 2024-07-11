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
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        String message = "";
        for (int i = 0; i < 500; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.25 && numberBetweenZeroAndOne >= 0) {
                student.addLast(i);
                solution.addLast(i);
                message += "addLast(" + i + ")\n";
            } else if (0.25 <= numberBetweenZeroAndOne && numberBetweenZeroAndOne <= 0.5) {
                student.addFirst(i);
                solution.addFirst(i);
                message += "addFirst(" + i + ")\n";
            } else if (numberBetweenZeroAndOne > 0.5 && numberBetweenZeroAndOne <= 0.75) {
                if (student.size() == 0 && solution.size() == 0) {
                    continue;
                } else {
                    Integer S1 = student.removeFirst();
                    Integer E1 = solution.removeFirst();
                    message += "removeFirst()\n";
                    assertEquals(message, E1, S1);
                }

            } else if (numberBetweenZeroAndOne > 0.75 && numberBetweenZeroAndOne <= 1) {
                if (student.size() == 0 && solution.size() == 0) {
                    continue;
                } else {
                    Integer S2 = student.removeLast();
                    Integer E2 = solution.removeLast();
                    message += "removeLast()\n";
                    assertEquals(message, E2, S2);
                }
            }

        }

    }

}
