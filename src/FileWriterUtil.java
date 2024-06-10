import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {
    private static final String FILE_PATH = "JavaKujundid.txt";

    public static String writeSphereToFile(Sphere sphere) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write("Kera;" + sphere.getRadius() + ";" + sphere.getSurfaceArea() + ";" + sphere.getCircumference() + ";" + sphere.getVolume());
            writer.newLine();
        }
        return new java.io.File(FILE_PATH).getAbsolutePath();
    }

    public static String writeCylinderToFile(Cylinder cylinder) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write("Silinder;" + cylinder.getRadius() + ";" + cylinder.getHeight() + ";" + cylinder.getTotalSurfaceArea() + ";" + cylinder.getLateralSurfaceArea() + ";" + cylinder.getVolume());
            writer.newLine();
        }
        return new java.io.File(FILE_PATH).getAbsolutePath();
    }
}
