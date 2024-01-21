import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    /* take 10 random operations and see if the result of the two is the same
    * However, it's not aduquate condition
    * Should I SET SOME SPECIAL EXAMPLES? So that I CAN TELL CODER WHAT'S WRONG
    * The answer is no. I don't know why but I know how to do it now
    * Should I CHECK THE RESULT every time I do an operation?*/
//    No error.
//    @Test
//    public void testAd(){
//        ArrayDequeSolution<Integer> adSta = new ArrayDequeSolution<Integer>();
//        StudentArrayDeque<Integer> adStu = new StudentArrayDeque<Integer>();
//        String log = "";
//        /*Random but not so Random calls*/
//        for (int i = 0; i<1000; i++) {
//            int rd_add = StdRandom.uniform(1) ;
//            int addNum = StdRandom.uniform(1000);
//
//            if (rd_add == 0) {
//                adSta.addFirst(addNum);
//                adStu.addFirst(addNum);
//            } else {
//                adSta.addLast(addNum);
//                adStu.addLast(addNum);
//            }
//        }
//
//        for (int i = 0; i<1000; i++) {
//            int rd_rm = StdRandom.uniform(1);
//            Integer sta, stu;
//            if (rd_rm == 0) {
//                sta = adSta.removeFirst();
//                stu = adStu.removeFirst();
//                log = log + "The element added by StudentArrayDeque is" + stu + "\n" + "The element added by the ArrayDeque Solution is " + sta;
//
//            } else {
//                sta = adSta.removeLast();
//                stu = adStu.removeLast();
//                log = log + "The element added by StudentArrayDeque is " + stu + "\n" + "The element added by the ArrayDeque Solution is " + sta;
//            }
//            /*Think still need some message as feedbacks*/
//            assertEquals(log, sta, stu);
//        }
//    }
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> stdArray = new ArrayDequeSolution<>();
        String log = "";
        for (int i = 0; i < 1000; i++) {
            if (stdArray.size() == 0) {
                int addNumber = StdRandom.uniform(1000);
                int headOrBack = StdRandom.uniform(2);
                if (headOrBack == 0) {
                    log = log + "addFirst(" + addNumber + ")\n";
                    testArray.addFirst(addNumber);
                    stdArray.addFirst(addNumber);
                } else {
                    log = log + "addLast(" + addNumber + ")\n";
                    testArray.addLast(addNumber);
                    stdArray.addLast(addNumber);
                }
            } else {
                int x = StdRandom.uniform(4);
                int addNumber = StdRandom.uniform(1000);
                Integer testremoveNumber = 1;
                Integer stdremoveNumber = 1;
                switch (x) {
                    case 0:
                        log = log + "addFirst(" + addNumber + ")\n";
                        testArray.addFirst(addNumber);
                        stdArray.addFirst(addNumber);
                        break;
                    case 1:
                        log = log + "addLast(" + addNumber + ")\n";
                        testArray.addLast(addNumber);
                        stdArray.addLast(addNumber);
                        break;
                    case 2:
                        log = log + "removeFirst()\n";
                        testremoveNumber = testArray.removeFirst();
                        stdremoveNumber = stdArray.removeFirst();
                        break;
                    case 3:
                        log = log + "removeLast()\n";
                        testremoveNumber = testArray.removeLast();
                        stdremoveNumber = stdArray.removeLast();
                        break;
                    default:
                }
                assertEquals(log, stdremoveNumber, testremoveNumber);
            }
        }

    }

    /*There is a way to make comparisions faster*/
    public boolean equals(StudentArrayDeque adStudent, ArrayDequeSolution adStandard) {
        int sizeStu = adStudent.size();
        int sizeSta = adStandard.size();
        if ( sizeStu != sizeSta ) {
            return false;
        }
        for (int i = 0; i < sizeSta; i++) {
            if (adStudent.get(i) != adStandard.get(i)) {
                return false;
            }
        }

        return true;
    }


}
