public class AbstractFactoryMain {

    public static void main(String[] args) {

        // Choose family of products (Light Theme)
        UIFactory factory = new LightUIFactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.select();

        // Switch family at runtime (Dark Theme)
        factory = new DarkUIFactory();
        button = factory.createButton();
        checkbox = factory.createCheckbox();

        button.render();
        checkbox.select();
    }
}

// Product A
interface Button {
    void render();
}

// Product B
interface Checkbox {
    void select();
}

class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Light Button");
    }
}

class LightCheckbox implements Checkbox {
    @Override
    public void select() {
        System.out.println("Light Checkbox Selected");
    }
}

class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Dark Button");
    }
}

class DarkCheckbox implements Checkbox {
    @Override
    public void select() {
        System.out.println("Dark Checkbox Selected");
    }
}


interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class LightUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}

class DarkUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}


