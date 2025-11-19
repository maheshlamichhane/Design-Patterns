public class ProxyMain {
    public static void main(String[] args) {
        System.out.println("=== Virtual Proxy Demo ===");

        // Create proxy - real image not loaded yet
        Image image1 = new ImageProxy("photo1.jpg");
        Image image2 = new ImageProxy("photo2.jpg");

        System.out.println("\nProxies created, but real images not loaded yet.");

        // Real image loaded only when display() is called
        System.out.println("\nDisplaying image 1:");
        image1.display();

        System.out.println("\nDisplaying image 1 again (should reuse loaded image):");
        image1.display();

        System.out.println("\nDisplaying image 2:");
        image2.display();
    }
}

// 1. Subject Interface
interface Image {
    void display();
    String getFileName();
}

// 2. RealSubject - Expensive to create
class HighResolutionImage implements Image {
    private String fileName;

    public HighResolutionImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading high-resolution image: " + fileName);
        // Simulate expensive operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Image loaded: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying high-resolution image: " + fileName);
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
// 3. Virtual Proxy - Lazy initialization
class ImageProxy implements Image {
    private String fileName;
    private HighResolutionImage realImage;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
        System.out.println("Proxy created for: " + fileName);
    }

    @Override
    public void display() {
        // Lazy initialization - create real object only when needed
        if (realImage == null) {
            realImage = new HighResolutionImage(fileName);
        }
        realImage.display();
    }
    @Override
    public String getFileName() {
        return fileName;
    }
}
