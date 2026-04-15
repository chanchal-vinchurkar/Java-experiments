import java.io.*;
import java.nio.file.*;
import java.util.*;

class Student {
    int studentId;
    String name;
    String branch;
    int marks1, marks2, marks3, marks4, marks5;
    double percentage;

    public Student(int studentId, String name, String branch,
                   int marks1, int marks2, int marks3, int marks4, int marks5) {
        this.studentId = studentId;
        this.name = name;
        this.branch = branch;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.marks4 = marks4;
        this.marks5 = marks5;
        this.percentage = 0.0;
    }

    public void calculatePercentage() {
        int total = marks1 + marks2 + marks3 + marks4 + marks5;
        this.percentage = total / 5.0;
    }

    public String toCSV() {
        return studentId + "," + name + "," + branch + "," +
                marks1 + "," + marks2 + "," + marks3 + "," +
                marks4 + "," + marks5 + "," + percentage;
    }
}

public class StudentsCSVCRUD {

    private static final String FILE_NAME = "Students.csv";

    public static void main(String[] args) {
        try {
            // Creating file with header and 2 rows
            createFile();

            // Adding 3 rows
            addMoreStudents();

            updateMarks();

            // Calculating percentage
            updatePercentage();

            // Deleting one row
            deleteStudent(2);


            // Force exception condition
            readFromInvalidFile();

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

    private static void createFile() throws IOException {
        System.out.println("\n--- Creating File with Header and 2 Rows ---");

        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        writer.write("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage\n");

        writer.write("1,Amit,CS,78,82,88,0,0,0\n");
        writer.write("2,Neha,IT,70,75,80,0,0,0\n");

        writer.close();
        displayFile();
    }

    private static void addMoreStudents() throws IOException {
        System.out.println("\n--- Adding 3 More Rows ---");

        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));

        writer.write("3,Rahul,ENTC,65,68,72,0,0,0\n");
        writer.write("4,Priya,CS,90,92,94,0,0,0\n");
        writer.write("5,Karan,IT,55,60,58,0,0,0\n");

        writer.close();
        displayFile();
    }

    private static void updateMarks() throws IOException {
        System.out.println("\n--- Updating marks4 and marks5 ---");

        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");

            parts[6] = String.valueOf(70 + i); // marks4
            parts[7] = String.valueOf(75 + i); // marks5

            lines.set(i, String.join(",", parts));
        }

        Files.write(Paths.get(FILE_NAME), lines);
        displayFile();
    }

    private static void updatePercentage() throws IOException {
        System.out.println("\n--- Calculating Percentage ---");

        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

        for (int i = 1; i < lines.size(); i++) {
            String[] p = lines.get(i).split(",");

            int m1 = Integer.parseInt(p[3]);
            int m2 = Integer.parseInt(p[4]);
            int m3 = Integer.parseInt(p[5]);
            int m4 = Integer.parseInt(p[6]);
            int m5 = Integer.parseInt(p[7]);

            double percent = calculatePercentage(m1, m2, m3, m4, m5);
            p[8] = String.valueOf(percent);

            lines.set(i, String.join(",", p));
        }

        Files.write(Paths.get(FILE_NAME), lines);
        displayFile();
    }

    private static double calculatePercentage(int m1, int m2, int m3, int m4, int m5) {
        return (m1 + m2 + m3 + m4 + m5) / 5.0;
    }

    private static void deleteStudent(int id) throws IOException {
        System.out.println("\n--- Deleting Student with ID " + id + " ---");

        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
        List<String> updated = new ArrayList<>();

        updated.add(lines.get(0));

        for (int i = 1; i < lines.size(); i++) {
            if (!lines.get(i).startsWith(id + ",")) {
                updated.add(lines.get(i));
            }
        }

        Files.write(Paths.get(FILE_NAME), updated);
        displayFile();
    }

    private static void displayFile() throws IOException {
        System.out.println("\nCurrent File Content:");
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    private static void readFromInvalidFile() {
        System.out.println("\n--- Demonstrating Exception Condition ---");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("InvalidFile.csv"));
            reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Exception caught successfully: " + e);
        }
    }
}
