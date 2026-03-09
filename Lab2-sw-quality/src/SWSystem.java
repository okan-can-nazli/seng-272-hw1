import java.util.ArrayList;

public class SWSystem {
    private String name;
    private String category;
    private String version;
    private ArrayList<QualityDimension> dimensions;

    public SWSystem(String name, String category, String version) {
        this.name = name;
        this.category = category;
        this.version = version;
        this.dimensions = new ArrayList<>();
    }

    public void addDimension(QualityDimension d) {
        dimensions.add(d);
    }

    public double calculateOverallScore() {
        double weightedSum = 0;
        double totalWeight = 0;
        for (QualityDimension d : dimensions) {
            weightedSum += d.calculateDimensionScore() * d.getWeight();
            totalWeight += d.getWeight();
        }
        return totalWeight == 0 ? 0 : weightedSum / totalWeight;
    }

    public QualityDimension findWeakestDimension() {
        QualityDimension weakest = null;
        double lowestScore = Double.MAX_VALUE;
        for (QualityDimension d : dimensions) {
            double score = d.calculateDimensionScore();
            if (score < lowestScore) {
                lowestScore = score;
                weakest = d;
            }
        }
        return weakest;
    }

    public void printReport() {
        System.out.println("========================================");
        System.out.println("SOFTWARE QUALITY EVALUATION REPORT (ISO/IEC 25010)");
        System.out.println("System: " + name + " v" + version + " (" + category + ")");
        System.out.println("========================================");

        for (QualityDimension d : dimensions) {
            double dimScore = d.calculateDimensionScore();
            System.out.println("--- " + d.getName() + " [" + d.getIsoCode() + "] (Weight: " + (int)d.getWeight() + ") ---");
            for (Criterion c : d.getCriteria()) {
                String dir = c.getDirection().equals("higher") ? "Higher is better" : "Lower is better";
                System.out.printf("%s: %.1f %s -> Score: %.1f (%s)%n",
                        c.getName(), c.getMeasuredValue(), c.getUnit(), c.calculateScore(), dir);
            }
            System.out.printf(">> Dimension Score: %.1f/5 [%s]%n%n", dimScore, d.getQualityLabel(dimScore));
        }

        double overall = calculateOverallScore();
        QualityDimension weakest = findWeakestDimension();
        double weakestScore = weakest.calculateDimensionScore();

        System.out.println("========================================");
        System.out.printf("OVERALL QUALITY SCORE: %.1f/5 [%s]%n", overall, new QualityDimension("","",0).getQualityLabel(overall));
        System.out.println("========================================");
        System.out.println("GAP ANALYSIS (ISO/IEC 25010)");
        System.out.println("========================================");
        System.out.println("Weakest Characteristic : " + weakest.getName() + " [" + weakest.getIsoCode() + "]");
        System.out.printf("Score: %.1f/5 | Gap: %.1f%n", weakestScore, 5.0 - weakestScore);
        System.out.println("Level: " + weakest.getQualityLabel(weakestScore));
        System.out.println(">> This characteristic requires the most improvement.");
        System.out.println("========================================");
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getVersion() { return version; }
    public ArrayList<QualityDimension> getDimensions() { return dimensions; }
}
