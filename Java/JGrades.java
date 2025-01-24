import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class JGrades {
    private static final int WWE_MAX_SCORE = 150;
    private static final int PT_MAX_SCORE = 200;
    private static final double WEIGHT_FACTOR = 0.50;
    private static final double BASE_SCORE = 50.0;
    
    static class StudentInfo {
        String name;
        String section;
        
        StudentInfo(String name, String section) {
            this.name = name;
            this.section = section;
        }
    }
    
    static class SubjectGrades {
        double wweScore;
        double wweGrade;
        double ptScore;
        double ptGrade;
        double finalGrade;
        
        SubjectGrades(double wweScore, double ptScore) {
            this.wweScore = wweScore;
            this.ptScore = ptScore;
            calculateGrades();
        }
        
        private void calculateGrades() {
            wweGrade = roundToTwoDecimals(calculateComponentGrade(wweScore, WWE_MAX_SCORE));
            ptGrade = roundToTwoDecimals(calculateComponentGrade(ptScore, PT_MAX_SCORE));
            finalGrade = roundToTwoDecimals((wweGrade + ptGrade) / 2);
        }
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentInfo studentInfo = getStudentInfo(scanner);
            Map<String, SubjectGrades> grades = collectGrades(scanner);
            displayGradeReport(grades, studentInfo);
        }
    }
    
    private static StudentInfo getStudentInfo(Scanner scanner) {
        System.out.println("Enter Student Information");
        System.out.println("------------------------");
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter your section: ");
        String section = scanner.nextLine().trim();
        
        System.out.println(); // Empty line for better formatting
        return new StudentInfo(name, section);
    }
    
    private static Map<String, SubjectGrades> collectGrades(Scanner scanner) {
        Map<String, SubjectGrades> grades = new LinkedHashMap<>();
        String[] subjects = {"Math", "Filipino", "English"};
        
        for (String subject : subjects) {
            System.out.println("\nEnter your grades in " + subject);
            double wweScore = getValidScore(scanner, "WW & E", WWE_MAX_SCORE);
            double ptScore = getValidScore(scanner, "PT", PT_MAX_SCORE);
            grades.put(subject, new SubjectGrades(wweScore, ptScore));
        }
        
        return grades;
    }
    
    private static double getValidScore(Scanner scanner, String component, int maxScore) {
        while (true) {
            System.out.printf("What is your %s score? (0-%d): ", component, maxScore);
            try {
                double score = Double.parseDouble(scanner.nextLine());
                if (score >= 0 && score <= maxScore) {
                    return score;
                }
                System.out.printf("Please enter a valid score between 0 and %d%n", maxScore);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }
    
    private static double calculateComponentGrade(double score, double maxScore) {
        return ((score / maxScore) * 100 * WEIGHT_FACTOR) + BASE_SCORE;
    }
    
    private static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    
    private static void displayGradeReport(Map<String, SubjectGrades> grades, StudentInfo studentInfo) {
        String studentInfoStr = String.format("Name: %-20s Section: %-15s", 
                                            studentInfo.name, studentInfo.section);
        String divider = "+-------------+--------------+----------+-------+";
        String headers = String.format("| %-11s | %-12s | %-8s | %-5s |", 
                                     "Subject", "WW & E Score", "PT Score", "Grade");
        
        System.out.println("\nGrade Report");
        System.out.println("-----------");
        System.out.println(studentInfoStr);
        System.out.println(divider);
        System.out.println(headers);
        System.out.println(divider);
        
        double totalGrade = 0;
        for (Map.Entry<String, SubjectGrades> entry : grades.entrySet()) {
            SubjectGrades grade = entry.getValue();
            System.out.printf("| %-11s | %-12.2f | %-8.2f | %-5.2f |%n",
                            entry.getKey(), grade.wweGrade, grade.ptGrade, grade.finalGrade);
            totalGrade += grade.finalGrade;
        }
        
        System.out.println(divider);
        double averageGrade = roundToTwoDecimals(totalGrade / grades.size());
        System.out.printf("| Average Grade: %-35.2f |%n", averageGrade);
        System.out.println(divider);
    }
}
