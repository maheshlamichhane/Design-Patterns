import java.util.ArrayList;
import java.util.List;

public class CompositeMain {

    public static void main(String[] args) {
        // Leaf nodes
        Employee dev1 = new Developer("Mahesh", "Senior Developer");
        Employee dev2 = new Developer("Sita", "Junior Developer");

        // Composite manager
        Manager manager = new Manager("Ramesh", "Project Manager");
        manager.addEmployee(dev1);
        manager.addEmployee(dev2);

        // Higher level
        Manager generalManager = new Manager("Hari", "General Manager");
        generalManager.addEmployee(manager);

        // Display organization hierarchy
        generalManager.showDetails();
    }


    static class Manager implements Employee {

        private String name;
        private String position;
        private List<Employee> subordinates = new ArrayList<>();

        public Manager(String name, String position) {
            this.name = name;
            this.position = position;
        }

        public void addEmployee(Employee e) {
            subordinates.add(e);
        }

        public void removeEmployee(Employee e) {
            subordinates.remove(e);
        }

        @Override
        public void showDetails() {
            System.out.println(position + " : " + name);
            for (Employee e : subordinates) {
                e.showDetails();
            }
        }
    }

    interface Employee {
        void showDetails();
    }

    static class Developer implements Employee {

        private String name;
        private String position;

        public Developer(String name, String position) {
            this.name = name;
            this.position = position;
        }

        @Override
        public void showDetails() {
            System.out.println(position + " : " + name);
        }
    }

}





