public class Criterion {
    private String name;
    private double weight;
    private String direction; // "higher" or "lower"
    private double minValue;
    private double maxValue;
    private String unit;
    private double measuredValue;

    public Criterion(String name, double weight, String direction, double minValue, double maxValue, String unit) {
        this.name = name;
        this.weight = weight;
        this.direction = direction;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
    }

    public double calculateScore() {
        double raw;
        if (direction.equals("higher")) {
            raw = 1 + (measuredValue - minValue) / (maxValue - minValue) * 4;
        } else {
            raw = 5 - (measuredValue - minValue) / (maxValue - minValue) * 4;
        }
        raw = Math.max(1.0, Math.min(5.0, raw));
        return Math.round(raw * 2) / 2.0;
    }

    public void setMeasuredValue(double measuredValue) { this.measuredValue = measuredValue; }
    public String getName() { return name; }
    public double getWeight() { return weight; }
    public String getDirection() { return direction; }
    public String getUnit() { return unit; }
    public double getMeasuredValue() { return measuredValue; }
}
