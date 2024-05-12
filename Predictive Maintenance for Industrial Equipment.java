import java.util.Random;

// Class to represent industrial equipment
class IndustrialEquipment {
    private String name;
    private double currentHealth;
    private double failureThreshold;
    private Random random;

    public IndustrialEquipment(String name, double initialHealth, double failureThreshold) {
        this.name = name;
        this.currentHealth = initialHealth;
        this.failureThreshold = failureThreshold;
        this.random = new Random();
    }

    // Simulate equipment operation and degradation over time
    public void operate() {
        double degradation = random.nextDouble() * 0.1; // Simulate random degradation
        currentHealth -= degradation;
        System.out.println(name + " is operating. Current health: " + currentHealth);

        // Check if equipment is likely to fail
        if (currentHealth <= failureThreshold) {
            System.out.println("WARNING: " + name + " is at risk of failure. Maintenance required.");
            // Trigger maintenance action (e.g., notify maintenance team)
        }
    }
}

// Class to represent a predictive maintenance system
public class PredictiveMaintenanceSystem {
    public static void main(String[] args) {
        // Create industrial equipment instances
        IndustrialEquipment equipment1 = new IndustrialEquipment("Machine 1", 0.9, 0.2);
        IndustrialEquipment equipment2 = new IndustrialEquipment("Machine 2", 0.8, 0.2);
        IndustrialEquipment equipment3 = new IndustrialEquipment("Machine 3", 0.95, 0.2);

        // Simulate equipment operation over time
        for (int i = 1; i <= 100; i++) {
            System.out.println("Day " + i + ":");
            equipment1.operate();
            equipment2.operate();
            equipment3.operate();
            System.out.println();
            // Simulate daily operation
            try {
                Thread.sleep(1000); // Simulate one day of operation (1 second)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
