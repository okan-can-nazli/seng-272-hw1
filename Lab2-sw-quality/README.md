# Lab 2 — Software Quality Evaluation System (ISO/IEC 25010)

A Java application that evaluates software system quality using ISO/IEC 25010 characteristics and ISO/IEC 25023 metrics.

## Project Structure
```
Lab2-sw-quality/
├── src/
│   ├── Criterion.java         # ISO 25023 metric with score calculation
│   ├── QualityDimension.java  # ISO 25010 quality characteristic
│   ├── SWSystem.java          # Software system being evaluated
│   ├── SWSystemData.java      # Static factory with test data
│   └── Main.java              # Entry point
└── README.md
```

## How to Run
```bash
cd src
javac *.java
java Main
```

## ISO 25010 Quality Characteristics Used

| ISO Code | Characteristic         |
|----------|------------------------|
| QC.FS    | Functional Suitability |
| QC.RE    | Reliability            |
| QC.PE    | Performance Efficiency |
| QC.MA    | Maintainability        |
| QC.SE    | Security               |
| QC.US    | Usability              |

## ISO 25023 Metrics Reference

| Characteristic         | Metric                         | Direction | Unit         |
|------------------------|--------------------------------|-----------|--------------|
| Functional Suitability | Functional Completeness Ratio  | Higher    | %            |
| Functional Suitability | Functional Correctness Ratio   | Higher    | %            |
| Reliability            | Availability Ratio             | Higher    | %            |
| Reliability            | Defect Density                 | Lower     | defect/KLOC  |
| Reliability            | MTBF                           | Higher    | hours        |
| Performance Efficiency | Response Time                  | Lower     | ms           |
| Performance Efficiency | CPU Utilisation Ratio          | Lower     | %            |
| Performance Efficiency | Throughput                     | Higher    | req/s        |
| Usability              | Task Completion Rate           | Higher    | %            |
| Usability              | User Error Rate                | Lower     | %            |
| Security               | Security Test Coverage         | Higher    | %            |
| Security               | Vulnerability Count            | Lower     | count        |
| Maintainability        | Test Coverage Ratio            | Higher    | %            |
| Maintainability        | Cyclomatic Complexity (avg)    | Lower     | score        |

## Score Calculation

- **Higher is better:** `score = 1 + (value - min) / (max - min) × 4`
- **Lower is better:** `score = 5 - (value - min) / (max - min) × 4`
- Scores clamped to [1, 5] and rounded to nearest 0.5
- Dimension score = weighted average of metric scores

## Quality Labels

| Score Range | Label              |
|-------------|--------------------|
| 4.5 – 5.0   | Excellent Quality  |
| 3.5 – 4.4   | Good Quality       |
| 2.5 – 3.4   | Needs Improvement  |
| 1.0 – 2.4   | Poor Quality       |
