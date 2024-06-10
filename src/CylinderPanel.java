import javax.swing.*;
import java.awt.*;

public class CylinderPanel extends JPanel {
    private JTextField radiusField;
    private JTextField heightField;
    private JLabel totalSurfaceAreaLabel;
    private JLabel lateralSurfaceAreaLabel;
    private JLabel volumeLabel;
    private JLabel inputDataLabel;
    private CylinderController controller;
    private JButton clearButton;
    private JButton calculateButton;

    public CylinderPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel titleLabel = new JLabel("Silindri Arvutused");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, gbc);
        gbc.gridwidth = 1;


        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Raadius:"), gbc);
        radiusField = new JTextField(10);
        radiusField.setEnabled(false); // Disable initially
        gbc.gridx = 1;
        add(radiusField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Kõrgus:"), gbc);
        heightField = new JTextField(10);
        heightField.setEnabled(false); // Disable initially
        gbc.gridx = 1;
        add(heightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Kogu pindala:"), gbc);
        totalSurfaceAreaLabel = new JLabel();
        gbc.gridx = 1;
        add(totalSurfaceAreaLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Külgpindala:"), gbc);
        lateralSurfaceAreaLabel = new JLabel();
        gbc.gridx = 1;
        add(lateralSurfaceAreaLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Ruumala:"), gbc);
        volumeLabel = new JLabel();
        gbc.gridx = 1;
        add(volumeLabel, gbc);

        // Sisesta andmed väli
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        inputDataLabel = new JLabel();
        add(inputDataLabel, gbc);

        // Arvuta nupp
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        calculateButton = new JButton("Arvuta");
        calculateButton.setEnabled(false); // Disable initially
        add(calculateButton, gbc);

        // Tühjenda väljad nupp
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        clearButton = new JButton("Tühjenda väljad");
        clearButton.setEnabled(false); // Disable initially
        add(clearButton, gbc);

        controller = new CylinderController(this);
        calculateButton.addActionListener(controller);
        clearButton.addActionListener(e -> clearFields());
    }

    public String getRadiusText() {
        return radiusField.getText();
    }

    public String getHeightText() {
        return heightField.getText();
    }

    public void setTotalSurfaceArea(String totalSurfaceArea) {
        totalSurfaceAreaLabel.setText(totalSurfaceArea);
    }

    public void setLateralSurfaceArea(String lateralSurfaceArea) {
        lateralSurfaceAreaLabel.setText(lateralSurfaceArea);
    }

    public void setVolume(String volume) {
        volumeLabel.setText(volume);
    }

    public void setInputData(String radius, String height) {
        inputDataLabel.setText("<html>Algandmed<br>Raadius: " + radius + "<br>Kõrgus: " + height + "</html>");
    }

    public void clearFields() {
        radiusField.setText("");
        heightField.setText("");
        totalSurfaceAreaLabel.setText("");
        lateralSurfaceAreaLabel.setText("");
        volumeLabel.setText("");
        inputDataLabel.setText("");
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        radiusField.setEnabled(enabled);
        heightField.setEnabled(enabled);
        calculateButton.setEnabled(enabled);
        clearButton.setEnabled(enabled);
    }

    public void setFilePath(String filePath) {
        Container parent = getParent();
        while (parent != null && !(parent instanceof MainPanel)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            ((MainPanel) parent).setFilePath(filePath);
        }
    }
}
