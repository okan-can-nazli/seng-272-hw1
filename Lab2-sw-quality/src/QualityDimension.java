import java.util.ArrayList;

public class QualityDimension {
    private String name;
    private String isoCode;
    private double weight;
    private ArrayList<Criterion> criteria;

    public QualityDimension(String name, String isoCode, double weight) {
        this.name = name;
        this.isoCode = isoCode;
        this.weight = weight;
        this.criteria = new ArrayList<>();
    }

    public void addCriterion(Criterion c) {
        criteria.add(c);
    }

    public double calculateDimensionScore() {
        double weightedSum = 0;
        double totalWeight = 0;
        for (Criterion c : criteria) {
            weightedSum += c.calculateScore() * c.getWeight();
            totalWeight += c.getWeight();
        }
        return totalWeight == 0 ? 0 : weightedSum / totalWeight;
    }

    public String getQualityLabel(double score) {
        if (score >= 4.5) return "Excellent Quality";
        else if (score >= 3.5) return "Good Quality";
        else if (score >= 2.5) return "Needs Improvement";
        else return "Poor Quality";
    }

    public String getName() { return name; }
    public String getIsoCode() { return isoCode; }
    public double getWeight() { return weight; }
    public ArrayList<Criterion> getCriteria() { return criteria; }
}
