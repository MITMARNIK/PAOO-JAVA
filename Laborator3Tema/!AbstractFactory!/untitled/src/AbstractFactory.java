//Abstract Factory Pattern oferă o interfață pentru a crea familii de obiecte înrudite fără a
// specifica clasele concrete, permițând schimbarea ușoară a acestor familii.

// 1. Fabrica Abstractă
interface GUIFactory {
    Button createButton();
    TextBox createTextBox();
}

// 2. Fabrici Concrete
class ModernGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new ModernButton();
    }

    @Override
    public TextBox createTextBox() {
        return new ModernTextBox();
    }
}

class ClassicGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new ClassicButton();
    }

    @Override
    public TextBox createTextBox() {
        return new ClassicTextBox();
    }
}

// 3. Produse Abstracte
interface Button {
    void paint();
}

interface TextBox {
    void setText(String text);
    void display();
}

// 4. Produse Concrete
class ModernButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a modern button.");
    }
}

class ModernTextBox implements TextBox {
    @Override
    public void setText(String text) {
        System.out.println("Setting text for a modern text box: " + text);
    }

    @Override
    public void display() {
        System.out.println("Displaying a modern text box.");
    }
}

class ClassicButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a classic button.");
    }
}

class ClassicTextBox implements TextBox {
    @Override
    public void setText(String text) {
        System.out.println("Setting text for a classic text box: " + text);
    }

    @Override
    public void display() {
        System.out.println("Displaying a classic text box.");
    }
}

// 5. Client
public class AbstractFactory {
    public static void main(String[] args) {
        // Alegem fabrica concretă în funcție de stilul dorit
        GUIFactory factory = new ModernGUIFactory(); // Sau new ClassicGUIFactory();

        Button button = factory.createButton();
        TextBox textBox = factory.createTextBox();

        button.paint();
        textBox.setText("Hello from Abstract Factory!");
        textBox.display();
    }
}