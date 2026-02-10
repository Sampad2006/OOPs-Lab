import java.util.*;

// Interface defining the Planet contract
interface Planet {
    String getName();
    String getMethod();
}

// Abstract Class defining the Explorer base
abstract class Explorer {
    protected String name;

    public Explorer(String name) {
        this.name = name;
    }

    // Every explorer must have an explore method
    public abstract void explore(Planet planet);
}

// Planet Implementations
class Mars implements Planet {
    public String getName() { return "Mars"; }
    public String getMethod() { return "Mineral Exploration."; }
}

class Venus implements Planet {
    public String getName() { return "Venus"; }
    public String getMethod() { return "Acid clouds."; }
}

class Saturn implements Planet {
    public String getName() { return "Saturn"; }
    public String getMethod() { return "gas layers."; }
}

// Concrete Explorer implementation
class SpaceExplorer extends Explorer {
    public SpaceExplorer(String name) {
        super(name);
    }

    @Override
    public void explore(Planet planet) {
        System.out.println(this.name + " is exploring " + planet.getName() + " " + planet.getMethod());
    }
}

// Main Driver Class
public class SpaceMission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Setup Explorer
        Explorer explorer = new SpaceExplorer("User-1");

        System.out.println("Select a Planet to explore: 1. Mars, 2. Venus, 3. Saturn");
        int choice = sc.nextInt();

        Planet target = null;
        switch (choice) {
            case 1: target = new Mars(); break;
            case 2: target = new Venus(); break;
            case 3: target = new Saturn(); break;
            default: System.out.println("Invalid choice."); return;
        }

        // Behavior based on the type of planet passed
        explorer.explore(target);
        
        sc.close();
    }
}