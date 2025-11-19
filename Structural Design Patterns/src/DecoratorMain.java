public class DecoratorMain {

    public static void main(String[] args) {
        // Simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println("Cost: $" + coffee.getCost() + ", Description: " + coffee.getDescription());

        // Coffee with milk
        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        System.out.println("Cost: $" + milkCoffee.getCost() + ", Description: " + milkCoffee.getDescription());

        // Coffee with milk and sugar
        Coffee milkSugarCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println("Cost: $" + milkSugarCoffee.getCost() + ", Description: " + milkSugarCoffee.getDescription());

        // Fancy coffee with everything
        Coffee fancyCoffee = new WhippedCreamDecorator(
                new SugarDecorator(
                        new MilkDecorator(
                                new SimpleCoffee())));
        System.out.println("Cost: $" + fancyCoffee.getCost() + ", Description: " + fancyCoffee.getDescription());
    }
}

// 1. Component Interface
interface Coffee {
    double getCost();
    String getDescription();
}

// 2. Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 5.0;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}

// 3. Abstract Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

// 4. Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}
class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whipped Cream";
    }
}

