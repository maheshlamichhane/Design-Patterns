public class SingletonMain {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.hashCode());
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1.hashCode());
    }
}

class Singleton{

    private static  Singleton instance;
    private Singleton(){
    }

    public synchronized static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

