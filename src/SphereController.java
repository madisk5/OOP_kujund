import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

public class SphereController implements ActionListener {
    private SpherePanel view;

    public SphereController(SpherePanel view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double radius = Double.parseDouble(view.getRadiusText());
            Sphere sphere = new Sphere(radius);

            view.setSurfaceArea(String.valueOf(sphere.getSurfaceArea()));
            view.setCircumference(String.valueOf(sphere.getCircumference()));
            view.setVolume(String.valueOf(sphere.getVolume()));
            view.setInputData(String.valueOf(radius));

            String filePath = FileWriterUtil.writeSphereToFile(sphere);
            view.setFilePath(filePath);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Palun sisesta korrektne number.", "Viga", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Tekkis viga faili kirjutamisel.", "Viga", JOptionPane.ERROR_MESSAGE);
        }
    }
}
