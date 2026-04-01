public class Main {
    public static void main(String[] args) throws InvalidVectorException {
        VectorClass v1 = new VectorClass(new double[]{1, 2});
        VectorClass v2 = new VectorClass(new double[]{3, 4});

        System.out.print("Vector 1: ");
        v1.print();

        System.out.print("Vector 2: ");
        v2.print();

        VectorClass sum = v1.add(v2);
        VectorClass diff = v1.subtract(v2);
        double dot = v1.dotProduct(v2);

        System.out.print("Addition: ");
        sum.print();

        System.out.print("Subtraction: ");
        diff.print();

        System.out.println("Dot Product: " + dot);
    }
}