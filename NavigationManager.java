import java.util.*;

interface NavigationManager {
    void visit(String url);
    void back();
    void forward();
    void currentPage();
}

// Implementation
class BrowserNavigation implements NavigationManager {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String current = null;

    public void visit(String url) {
        if (current != null) backStack.push(current);
        current = url;
        forwardStack.clear();
        System.out.println("Visited: " + current);
    }

    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
            System.out.println("Back to: " + current);
        } else {
            System.out.println("No pages in back history");
        }
    }

    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(current);
            current = forwardStack.pop();
            System.out.println("Forward to: " + current);
        } else {
            System.out.println("No pages in forward history");
        }
    }

    public void currentPage() {
        System.out.println("Current Page: " + current);
    }
}

// Demo
public class BrowserApp {
    public static void main(String[] args) {
        NavigationManager nav = new BrowserNavigation();
        nav.visit("google.com");
        nav.visit("openai.com");
        nav.visit("github.com");

        nav.back();       // openai.com
        nav.back();       // google.com
        nav.forward();    // openai.com
        nav.currentPage();// openai.com
    }
}
