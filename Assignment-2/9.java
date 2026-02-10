// Interface defining the behavior of a Planet
interface Planet {
    String getEnvironmentType();
    void provideAtmosphericData();
}

// Abstract Class for the Explorer
abstract class Explorer {
    protected String name;

    public Explorer(String name) {
        this.name = name;
    }

    // Abstract method: Every explorer must implement their specific exploration logic
    public abstract void explore(Planet planet);
}

// Concrete Planet Implementations
class Mars implements Planet {
    public String getEnvironmentType() { return "Dusty/Rocky"; }
    public void provideAtmosphericData() {
        System.out.println("Mars: Thin CO2 atmosphere. Monitoring for perchlorates.");
    }
}

class Venus implements Planet {
    public String getEnvironmentType() { return "Crushing/Acidic"; }
    public void provideAtmosphericData() {
        System.out.println("Venus: High pressure, sulfuric acid clouds. Heat shield active.");
    }
}

class Saturn implements Planet {
    public String getEnvironmentType() { return "Gaseous/Cold"; }
    public void provideAtmosphericData() {
        System.out.println("Saturn: No solid surface. Floating in hydrogen/helium layers.");
    }
}

// Concrete Explorer Implementations
class Rover extends Explorer {
    public Rover(String name) { super(name); }

    @Override
    public void explore(Planet planet) {
        System.out.println("\n--- " + name + " (Rover) Landing Sequence ---");
        planet.provideAtmosphericData();
        if (planet instanceof Saturn) {
            System.out.println("Error: Rover cannot explore Saturn. It has no surface to drive on!");
        } else {
            System.out.println("Action: Deploying wheels on " + planet.getEnvironmentType() + " terrain.");
        }
    }
}

class Orbiter extends Explorer {
    public Orbiter(String name) { super(name); }

    @Override
    public void explore(Planet planet) {
        System.out.println("\n--- " + name + " (Orbiter) Scanning Sequence ---");
        planet.provideAtmosphericData();
        System.out.println("Action: Capturing high-res images from high altitude.");
    }
}

// Main Class
public class SpaceMission {
    public static void main(String[] args) {
        // Create Planets
        Planet mars = new Mars();
        Planet venus = new Venus();
        Planet saturn = new Saturn();

        // Create Explorers
        Explorer curiosity = new Rover("Curiosity");
        Explorer cassini = new Orbiter("Cassini");

        // Start Missions
        curiosity.explore(mars);   // Successful Rover mission
        curiosity.explore(saturn); // Failed Rover mission logic
        
        cassini.explore(saturn);   // Successful Orbiter mission
        cassini.explore(venus);    // Successful Orbiter mission
    }
}