
public class Triangle implements Comparable<Triangle> {
    private String name;
    private double SideA;
    private double SideB;
    private double thirdSideLength;
    private double perimeter;
    private double square;
    public Triangle(String name, double firstSideLength, double secondSideLength, double thirdSideLength) {
        this.name = name;
        this.SideA = firstSideLength;
        this.SideB = secondSideLength;
        this.thirdSideLength = thirdSideLength;
        this.perimeter = (firstSideLength + secondSideLength + thirdSideLength) / 2;
        this.square = Math.round((Math.sqrt(perimeter * (perimeter - firstSideLength) *
                (perimeter - secondSideLength) * (perimeter - thirdSideLength))) * 100.0) / 100.0;
    }

    @Override
    public int compareTo(Triangle triangle) {
        return Double.compare(this.getSquare(), triangle.getSquare());
    }

    @Override
    public String toString() {
        return "[" + name + "]: " + square + " cm";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFirstSideLength() {
        return SideA;
    }

    public void setFirstSideLength(double firstSideLength) {
        this.SideA = firstSideLength;
    }

    public double getSecondSideLength() {
        return SideB;
    }

    public void setSecondSideLength(double secondSideLength) {
        this.SideB = secondSideLength;
    }

    public double getThirdSideLength() {
        return thirdSideLength;
    }

    public void setThirdSideLength(double thirdSideLength) {
        this.thirdSideLength = thirdSideLength;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }
}
