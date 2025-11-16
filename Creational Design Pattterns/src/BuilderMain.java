public class BuilderMain {
        public static void main(String[] args) {
            Person person = new Person.Builder("John", "Doe")
                    .age(30)
                    .phone("123-456-7890")
                    .address("123 Main Street")
                    .build();
            System.out.println(person.getAddress());
        }
}

// Product class
class Person {
    // Required parameters
    private final String firstName;
    private final String lastName;

    // Optional parameters
    private final int age;
    private final String phone;
    private final String address;

    // Private constructor: only Builder can create Person
    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    // Static Builder class
    public static class Builder {
        // Required parameters
        private final String firstName;
        private final String lastName;

        // Optional parameters - initialized to default values
        private int age = 0;
        private String phone = "";
        private String address = "";

        // Builder constructor with required parameters
        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // Setter methods for optional parameters
        public Builder age(int age) {
            this.age = age;
            return this;  // return Builder for chaining
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        // Build method to create Person instance
        public Person build() {
            return new Person(this);
        }
    }

    // Getters (optional, if immutability needed)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName
                + ", age=" + age + ", phone=" + phone + ", address=" + address + "]";
    }
}



