
public class App {
    public static void main(String[] args) {
        TriangleApi triangleApi = new TriangleService();
        TriangleProcess triangleProcess = new TriangleProcess(triangleApi);
        triangleProcess.process();
    }
}
