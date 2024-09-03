class Singleton {
    
    // Private constructor prevents instantiation from other classes
    private Singleton() {
        // Private constructor to prevent instantiation
    }

    // Inner static helper class responsible for holding the Singleton instance
    private static class SingletonHelper {
        // The Singleton instance is initialized when the SingletonHelper class is loaded
        private static final Singleton INSTANCE = new Singleton();
    }

    // Global point of access to the Singleton instance
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    // Example method for demonstration purposes
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// Test class to demonstrate the Singleton implementation
class SingletonTest {
    public static void main(String[] args) {
        // Create multiple threads to test the Singleton
        Runnable task = () -> {
            Singleton singleton = Singleton.getInstance();
            singleton.showMessage();
            System.out.println("Instance hash code: " + singleton.hashCode());
        };

        // Create and start multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
