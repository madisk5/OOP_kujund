import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

public class CylinderController implements ActionListener {
    private CylinderPanel view;

    public CylinderController(CylinderPanel view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double radius = Double.parseDouble(view.getRadiusText());
            double height = Double.parseDouble(view.getHeightText());
            Cylinder cylinder = new Cylinder(radius, height);

            view.setTotalSurfaceArea(String.valueOf(cylinder.getTotalSurfaceArea()));
            view.setLateralSurfaceArea(String.valueOf(cylinder.getLateralSurfaceArea()));
            view.setVolume(String.valueOf(cylinder.getVolume()));
            view.setInputData(String.valueOf(radius), String.valueOf(height));

            String filePath = FileWriterUtil.writeCylinderToFile(cylinder);
            view.setFilePath(filePath);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Palun sisesta korrektne number.", "Viga", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Tekkis viga faili kirjutamisel.", "Viga", JOptionPane.ERROR_MESSAGE);
        }
    }
}
