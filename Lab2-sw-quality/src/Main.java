import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 1. Load all systems
        HashMap<String, ArrayList<SWSystem>> allSystems = SWSystemData.getAllSystems();

        // 2. Get Web category
        ArrayList<SWSystem> webSystems = allSystems.get("Web");

        // 3. Find ShopSphere
        SWSystem shopSphere = null;
        for (SWSystem s : webSystems) {
            if (s.getName().equals("ShopSphere")) {
                shopSphere = s;
                break;
            }
        }

        if (shopSphere == null) {
            System.out.println("System not found.");
            return;
        }

        // 4. Set test values for each metric
        // Functional Suitability
        shopSphere.getDimensions().get(0).getCriteria().get(0).setMeasuredValue(94);  // Functional Completeness Ratio
        shopSphere.getDimensions().get(0).getCriteria().get(1).setMeasuredValue(91);  // Functional Correctness Ratio

        // Reliability
        shopSphere.getDimensions().get(1).getCriteria().get(0).setMeasuredValue(99.2); // Availability Ratio
        shopSphere.getDimensions().get(1).getCriteria().get(1).setMeasuredValue(2.1);  // Defect Density

        // Performance Efficiency
        shopSphere.getDimensions().get(2).getCriteria().get(0).setMeasuredValue(220);  // Response Time
        shopSphere.getDimensions().get(2).getCriteria().get(1).setMeasuredValue(38);   // CPU Utilisation

        // Maintainability
        shopSphere.getDimensions().get(3).getCriteria().get(0).setMeasuredValue(72);   // Test Coverage Ratio
        shopSphere.getDimensions().get(3).getCriteria().get(1).setMeasuredValue(8.5);  // Cyclomatic Complexity

        // 5. Print report
        shopSphere.printReport();
    }
}
