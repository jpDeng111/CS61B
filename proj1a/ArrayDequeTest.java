
public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /*Checked the item of the arrayDeque*/
    public static boolean checkGet(String expected, String actual){
        if (expected != actual) {
            System.out.println("get(int i) returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }
    /* Prints a nice message based on whether a test passed.
     * The \n means newline.
     * In fact, without the function, I thought I need to do format print
     * after every function.*/
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }


    /* Integration Test Of addRemoveTest() */
    public static void addRemoveTest(){
        ArrayDeque<String> JostarI = new ArrayDeque<String>();
        JostarI.addFirst("Jonathan");
        JostarI.addLast("Joseph");
        JostarI.addLast("Jotaro");



        System.out.print("Check Empty");
        Boolean passed = checkEmpty(false, JostarI.isEmpty());
        printTestStatus(passed);

        System.out.print("Check Size");
        passed = checkSize(3, JostarI.size());
        printTestStatus(passed);

        System.out.print("Check Get");
        passed = checkGet("Jonathan", JostarI.get(0));
        printTestStatus(passed);

        JostarI.removeFirst();
        System.out.print("Check Size");
        passed = checkSize(2, JostarI.size());
        printTestStatus(passed);

        JostarI.removeLast();

        System.out.print("Check Get");
        passed = checkGet("Joseph", JostarI.get(0));
        printTestStatus(passed);

    }
    public static void main(String[] args){

        addRemoveTest();
    }

}
