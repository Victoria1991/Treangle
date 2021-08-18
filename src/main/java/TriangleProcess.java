import java.util.*;

public class TriangleProcess {

    static Scanner scanner = new Scanner(System.in);
    private TriangleApi triangleApi;
    public TriangleProcess(TriangleApi triangleApi) {
        this.triangleApi = triangleApi;
    }

    public void process() { // наполнение треугольниками
        List<Triangle> triangles = new ArrayList<>();
        boolean shouldContinue = true;
        while (shouldContinue) {
            triangles.add(getTriangle());
            shouldContinue = confirmation("Do you want to add new triangle?");
        }

        triangleApi.sort(triangles); // получила отсортированные треугольники
        System.out.println("=========Triangles list:=========");
        for (int i = 0; i < triangles.size(); i++) {
            System.out.println((i + 1) + ". " + triangles.get(i));// тут я вывожу массив треугольников
        }
    }

    private Triangle getTriangle() {
        Triangle triangle = null;
        boolean shouldContinue = true;
        while (shouldContinue) {
            String input = getAnyString("Input triangle parameters in format <name>, " +
                    "<side length>, <side length>, <side length>.");
            List<String> list = Arrays.asList(input.split(",")); // разбитие строки по ","
            String name;
            double sideA, sideB, sideC;
            try { // оборачиваю в эксепшен (отслеживаю ошибки)
                if (list.size() != 4) {
                    throw new InputMismatchException("Incorrect elements count entered.");
                } else {
                    name = list.get(0).trim(); // обрезает лишние пробелы trim
                    try {
                        sideA = Double.parseDouble(list.get(1).trim());
                        sideB = Double.parseDouble(list.get(2).trim());
                        sideC = Double.parseDouble(list.get(3).trim());
                    } catch (NumberFormatException ex) {
                        throw new NumberFormatException("Could not parse sides into double.");
                    }
                    triangle = new Triangle(name, sideA, sideB, sideC);
                    if (Double.isNaN(triangle.getSquare())) { // если площадь равна 0 то
                        throw new InputMismatchException("Triangle with such sides does not exists.");
                    }
                    shouldContinue = false;
                }
            } catch (InputMismatchException | NumberFormatException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return triangle;
    }
    public static boolean confirmation(String question) {
        boolean shouldContinue = true;
        boolean result = false;

        while (shouldContinue) {
            System.out.println(question + " (Yes/No)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
                result = true;
                shouldContinue = false;
            } else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
                shouldContinue = false;
            } else {
                System.out.println("Invalid symbol! Repeat.");
            }
        }
        return result;
    }

    public static String getAnyString(String message) {
        System.out.println(message + "\nPlease enter string:");
        String result = scanner.nextLine();
        if (result.equals("")) {
            result = scanner.nextLine();
        }
        return result;
    }
}

