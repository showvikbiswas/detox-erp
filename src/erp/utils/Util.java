package erp.utils;

public class Util {

    public static void log(String message) {
        System.out.println("[LOG] " + message); 
    }

    public static void pauseExecution(int milliseconds) {  
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
