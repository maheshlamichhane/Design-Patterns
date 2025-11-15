public class PrototypeMain {

    public static void main(String[] args) throws CloneNotSupportedException {


        // Shallow Cloning
        ShallowPrototypePerson original = new ShallowPrototypePerson("Mahesh", 31);
        ShallowPrototypePerson clone = (ShallowPrototypePerson) original.clone();

        System.out.println(original);
        System.out.println(clone);
        System.out.println(original == clone);

        // Deep Cloning
        DeepPrototypeAddress address = new DeepPrototypeAddress("balewa");
        DeepPrototypePerson original2 = new DeepPrototypePerson("Mahesh", 31,address);
        DeepPrototypePerson clone2 = (DeepPrototypePerson) original2.clone();

        System.out.println(original2);
        System.out.println(clone2);
        System.out.println(original2 == clone2);
    }
}

class ShallowPrototypePerson implements Cloneable {
    private String name;
    private int age;

    public ShallowPrototypePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class DeepPrototypePerson implements Cloneable {
    private String name;
    private int age;

    private DeepPrototypeAddress  deepPrototypeAddress;

    public DeepPrototypePerson(String name, int age,DeepPrototypeAddress deepPrototypeAddress) {
        this.name = name;
        this.age = age;
        this.deepPrototypeAddress = deepPrototypeAddress;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepPrototypePerson cloned = (DeepPrototypePerson) super.clone();
        cloned.deepPrototypeAddress = (DeepPrototypeAddress) deepPrototypeAddress.clone(); // deep clone
        return cloned;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class DeepPrototypeAddress implements Cloneable {

    private String address;

    public DeepPrototypeAddress(String address) {
        this.address = address;
    }

    @Override
    public DeepPrototypeAddress clone() {
        try {
            DeepPrototypeAddress clone = (DeepPrototypeAddress) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
