public class FacadeMain {

    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        // Using the simplified facade interface
        computer.startComputer();
        computer.performTask();
        computer.shutdownComputer();
    }


}

// Subsystem Classes
class CPU {
    public void start() {
        System.out.println("CPU is starting...");
    }

    public void execute() {
        System.out.println("CPU is executing commands...");
    }

    public void shutdown() {
        System.out.println("CPU is shutting down...");
    }
}

class Memory {
    public void load() {
        System.out.println("Memory is loading data...");
    }

    public void free() {
        System.out.println("Memory is being freed...");
    }
}

class HardDrive {
    public void read() {
        System.out.println("Hard Drive is reading data...");
    }

    public void write() {
        System.out.println("Hard Drive is writing data...");
    }
}

// Facade Class
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    // Simplified interface for starting computer
    public void startComputer() {
        System.out.println("=== Starting Computer ===");
        cpu.start();
        memory.load();
        hardDrive.read();
        cpu.execute();
        System.out.println("Computer started successfully!\n");
    }

    // Simplified interface for shutting down computer
    public void shutdownComputer() {
        System.out.println("=== Shutting Down Computer ===");
        hardDrive.write();
        memory.free();
        cpu.shutdown();
        System.out.println("Computer shut down successfully!\n");
    }

    // Another simplified operation
    public void performTask() {
        System.out.println("=== Performing Task ===");
        hardDrive.read();
        cpu.execute();
        hardDrive.write();
        System.out.println("Task completed!\n");
    }
}


