public class Test {
  public static void main(String[] args) {
    IntList A = IntList.of(0, 1, 2, 3);
    IntList B = IntList.of(0, 1, 2, 3);
    IntList C = IntList.squareListIterative(A);
    IntList.dcatenate(A, B);
    while (A != null) {
      System.out.println(A.first);
      A = A.rest;
    }
  }
}
