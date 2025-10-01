package creational.singleton;

class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) { instance = new Logger(); }
        return instance;
    }
    public void log(String msg) { System.out.println("LOG: " + msg); }
}

public class SingletonDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("This is a singleton logger.");
        System.out.println("Logger1 == Logger2? " + (logger1 == logger2));
    }
}