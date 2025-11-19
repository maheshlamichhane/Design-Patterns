import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyweightMain {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Adding characters - notice how same character/size combinations are reused
        editor.addCharacter('H', 12, 0, "Arial");
        editor.addCharacter('e', 12, 1, "Arial");
        editor.addCharacter('l', 12, 2, "Arial");
        editor.addCharacter('l', 12, 3, "Arial");  // Reuses existing 'l'
        editor.addCharacter('o', 12, 4, "Arial");
        editor.addCharacter(' ', 12, 5, "Arial");
        editor.addCharacter('W', 12, 6, "Times New Roman");
        editor.addCharacter('o', 12, 7, "Times New Roman");  // Reuses existing 'o'
        editor.addCharacter('r', 12, 8, "Times New Roman");
        editor.addCharacter('l', 12, 9, "Times New Roman");  // Reuses existing 'l'
        editor.addCharacter('d', 12, 10, "Times New Roman");
        editor.addCharacter('!', 12, 11, "Times New Roman");

        editor.displayText();

        System.out.println("\nTotal unique characters created: " + CharacterFactory.getCacheSize());
        System.out.println("Total characters in document: 12");
        System.out.println("Memory saved by reusing flyweights!");
    }
}

// 1. Flyweight Interface
interface CharacterFlyweight {
    void display(int position, String font);
}

// 2. Concrete Flyweight - Intrinsic State
class Character implements CharacterFlyweight {
    private final char character; // Intrinsic state - shared
    private final int size;       // Intrinsic state - shared

    public Character(char character, int size) {
        this.character = character;
        this.size = size;
    }

    @Override
    public void display(int position, String font) {
        // Extrinsic state (position, font) is passed as parameters
        System.out.printf("Character: %c, Size: %d, Position: %d, Font: %s%n",
                character, size, position, font);
    }

    // Getters for intrinsic state
    public char getCharacter() { return character; }
    public int getSize() { return size; }
}

// 3. Flyweight Factory
class CharacterFactory {
    private static Map<String, Character> characterCache = new HashMap<>();

    public static Character getCharacter(char c, int size) {
        String key = c + "_" + size;

        if (!characterCache.containsKey(key)) {
            System.out.println("Creating new character: " + c + " with size: " + size);
            characterCache.put(key, new Character(c, size));
        } else {
            System.out.println("Reusing existing character: " + c + " with size: " + size);
        }

        return characterCache.get(key);
    }

    public static int getCacheSize() {
        return characterCache.size();
    }
}

// 4. Client - Uses flyweights with extrinsic state
class TextEditor {
    private List<Character> characters = new ArrayList<>();
    private List<Integer> positions = new ArrayList<>();
    private List<String> fonts = new ArrayList<>();

    public void addCharacter(char c, int size, int position, String font) {
        Character character = CharacterFactory.getCharacter(c, size);
        characters.add(character);
        positions.add(position);
        fonts.add(font);
    }

    public void displayText() {
        System.out.println("\n=== Displaying Text ===");
        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).display(positions.get(i), fonts.get(i));
        }
    }
}
