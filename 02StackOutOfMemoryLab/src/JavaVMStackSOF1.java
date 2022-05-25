public class JavaVMStackSOF1 {

    private int stackLength = 0;
    private void stackLeak() {
        ++stackLength;
        stackLeak();
    }
    public static void main(String[] args) {
        JavaVMStackSOF1 oom = new JavaVMStackSOF1();
        try{
            oom.stackLeak();
        } catch (StackOverflowError error) {
            System.out.println("oom.stackLength = " + oom.stackLength);
            throw error;
        }
    }
}
