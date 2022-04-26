public class Main {

    public static void main(String[] args) throws Exception {
        try {
            uncheckedTwoExceptions(false);
        } catch(ArithmeticException | NullPointerException e) {
            System.out.println("Runtime Exception");
        }
    }


    // Many Catchs
    public static void exampleCustomException() {
        throw new CustomException();
    }

    // Many Catchs
    public static void manyCatchsExample() {
        try {
            checkedTwoExceptions(false);
        } catch(RuntimeException e) {
            System.out.println("Runtime Exception");
        } catch(Exception e) {
            System.out.println("Exception");
        } catch(Throwable e) {
            System.out.println("Exception");
        }
    }

    // Checked Exceptions
    private static void uncheckedTwoExceptions(boolean flag) throws Exception {
        if (flag) {
            throw new ArithmeticException();
        } else {
            throw new NullPointerException();
        }
    }

    // Checked Exceptions
    private static void checkedTwoExceptions(boolean flag) throws Exception {
        if (flag) {
            throw new Exception();
        } else {
            throw new RuntimeException();
        }
    }

    // Finally
    private static void finallyExample() throws Exception {
        try {
            checkedException();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new Exception();
        } finally {
            System.out.println("End");
        }
    }

    // Checked Exceptions
    private static void checkedException() throws Exception {
        throw new Exception();
    }

    // Unchecked Exceptions
    private static void exampleArithmeticException() {
        double number = 10 / 0;
    }


}
