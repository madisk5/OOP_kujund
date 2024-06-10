import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JLabel titleLabel;
    private JPanel centerPanel;
    private JButton sphereButton;
    private JButton cylinderButton;
    private JTextField filePathField;
    private SpherePanel spherePanel;
    private CylinderPanel cylinderPanel;
    private JPanel blankPanel; // tühi paneel, mida kuvame alguses

    public MainPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 400));

        // Tiitel paneel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titleLabel = new JLabel("Vali arvutused", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(titleLabel, BorderLayout.NORTH);

        // Nupud
        JPanel buttonPanel = new JPanel(new FlowLayout());
        sphereButton = new JButton("Kera");
        cylinderButton = new JButton("Silinder");

        buttonPanel.add(sphereButton);
        buttonPanel.add(cylinderButton);

        titlePanel.add(buttonPanel, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);


        centerPanel = new JPanel(new CardLayout());
        spherePanel = new SpherePanel();
        cylinderPanel = new CylinderPanel();
        blankPanel = new JPanel(); // Alguses tühi paneel

        centerPanel.add(blankPanel, "Blank");
        centerPanel.add(spherePanel, "Kera");
        centerPanel.add(cylinderPanel, "Silinder");

        add(centerPanel, BorderLayout.CENTER);

        // File asukoht
        JPanel filePathPanel = new JPanel(new BorderLayout());
        filePathField = new JTextField();
        filePathField.setEditable(false);
        filePathPanel.add(new JLabel("Faili asukoht:"), BorderLayout.WEST);
        filePathPanel.add(filePathField, BorderLayout.CENTER);
        add(filePathPanel, BorderLayout.SOUTH);

        // Blank paneel
        CardLayout cl = (CardLayout) (centerPanel.getLayout());
        cl.show(centerPanel, "Blank");


        sphereButton.addActionListener(e -> {
            showPanel("Kera");
        });

        cylinderButton.addActionListener(e -> {
            showPanel("Silinder");
        });
    }

    private void showPanel(String panelName) {
        CardLayout cl = (CardLayout) (centerPanel.getLayout());
        cl.show(centerPanel, panelName);
        titleLabel.setText(panelName.equals("Kera") ? "Kera Arvutused" : "Silindri Arvutused");


        if (panelName.equals("Kera")) {
            enablePanel(spherePanel);
            disablePanel(cylinderPanel);
        } else {
            enablePanel(cylinderPanel);
            disablePanel(spherePanel);
        }
    }

    private void enablePanel(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextField || comp instanceof JButton) {
                comp.setEnabled(true);
            }
        }
    }

    private void disablePanel(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextField || comp instanceof JButton) {
                comp.setEnabled(false);
            }
        }
    }

    public void setFilePath(String filePath) {
        filePathField.setText(filePath);
    }
}
