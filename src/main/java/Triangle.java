
public class Triangle implements Comparable<Triangle> {
    private String name;
    private double SideA;
    private double SideB;
    private double SideC;
    private double perimeter;
    private double square;
    public Triangle(String name, double firstSide, double secondSideLength, double thirdSideLength) {
        if (firstSide + secondSideLength <= thirdSideLength ||
                firstSide + thirdSideLength <= secondSideLength ||
                secondSideLength + thirdSideLength <= firstSide) {
            throw new IllegalArgumentException("Triangle with such sides does not exists.");
        }

        this.name = name;
        this.SideA = firstSide;
        this.SideB = secondSideLength;
        this.SideC = thirdSideLength;
        this.perimeter = (firstSide + secondSideLength + thirdSideLength) / 2;
        this.square = Math.round((Math.sqrt(perimeter * (perimeter - firstSide) *
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

    public double getSideC() {
        return SideC;
    }

    public void setSideC(double sideC) {
        this.SideC = sideC;
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


}
