
import org.junit.Assert;
import org.junit.Test;


public class TreangleTest {
    private static TriangleProcess triangleProcess;


    @Test
    public void testGetTriangleSidsSum() {
        String name = "1";
        double SideA = 3.4;
        double SideB = 4.5;
        double SideC = 5;
        double expected = 7.45;

        Triangle triangle = new Triangle(name, SideA, SideB, SideC);
        double actual = triangle.getSquare();

        Assert.assertEquals(expected, actual, 0.05);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetTriangleSidsSum1() {
        String name = "2";
        double SideA = 2;
        double SideB = 3;
        double SideC = 5;

        Triangle triangle = new Triangle(name, SideA, SideB, SideC);
    }
}



