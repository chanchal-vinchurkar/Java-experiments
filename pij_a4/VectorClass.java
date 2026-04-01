public class VectorClass {
    double[] comps;

    public VectorClass(double[] arr) throws InvalidVectorException {
        if (arr == null || arr.length == 0)
            throw new InvalidVectorException("Invalid Vector");

        if (arr.length != 2 && arr.length != 3)
            throw new InvalidVectorException("Only 2D or 3D supported");

        comps = arr.clone();
    }

    public VectorClass add(VectorClass v) throws InvalidVectorException {
        checkDimension(v);
        double[] result = new double[comps.length];

        for (int i = 0; i < comps.length; i++)
            result[i] = comps[i] + v.comps[i];

        return new VectorClass(result);
    }

    public VectorClass subtract(VectorClass v) throws InvalidVectorException {
        checkDimension(v);
        double[] result = new double[comps.length];

        for (int i = 0; i < comps.length; i++)
            result[i] = comps[i] - v.comps[i];

        return new VectorClass(result);
    }

    public double dotProduct(VectorClass v) throws InvalidVectorException {
        checkDimension(v);
        double result = 0;

        for (int i = 0; i < comps.length; i++)
            result += comps[i] * v.comps[i];

        return result;
    }

    void checkDimension(VectorClass v) throws InvalidVectorException {
        if (this.comps.length != v.comps.length)
            throw new InvalidVectorException("Incompatible vector dimensions");
    }

    public void print() {
        System.out.print("Vector(");
        for (int i = 0; i < comps.length; i++) {
            System.out.print(comps[i]);
            if (i != comps.length - 1)
                System.out.print(", ");
        }
        System.out.println(")");
    }
}