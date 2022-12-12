import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class main extends JPanel {
    private JButton jiggle_button;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JButton jcomp4;
    private JComboBox jcomp5;
    private JLabel jcomp6;
    private JCheckBox jcomp7;

    public main() {
        //construct preComponents
        String[] jcomp5Items = {"Hazzard", "Linear"};

        //construct components
        jiggle_button = new JButton ("Jiggle");
        jcomp2 = new JLabel ("Auto Jiggler V1.0a");
        jcomp3 = new JLabel ("OS:" + osDetection.OSType.Linux);
        jcomp4 = new JButton ("Stop");
        jcomp5 = new JComboBox (jcomp5Items);
        jcomp6 = new JLabel ("Movement :");
        jcomp7 = new JCheckBox ("Prevent Detection (Administrator)");

        //set components properties
        jiggle_button.setToolTipText ("My Money doesn't jiggle jiggle, it moves. Wait...");
        jcomp5.setToolTipText ("This will change how the move is jiggled around the screen.");
        jcomp6.setToolTipText ("This will change how the move is jiggled around the screen.");
        jcomp7.setToolTipText ("This will run certain scripts that will attempt to prevent being detected, keep in mind this is in no way a guarantee.");

        //adjust size and set layout
        setPreferredSize (new Dimension (270, 125));
        setLayout (null);

        //add components
        add (jiggle_button);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);
        add (jcomp7);

        //set component bounds (only needed by Absolute Positioning)
        jiggle_button.setBounds (5, 30, 125, 20);
        jcomp2.setBounds (85, 5, 110, 20);
        jcomp3.setBounds (0, 105, 270, 20);
        jcomp4.setBounds (140, 30, 125, 20);
        jcomp5.setBounds (90, 60, 175, 25);
        jcomp6.setBounds (5, 60, 65, 25);
        jcomp7.setBounds (0, 85, 255, 25);
    }

    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new main());
        frame.pack();
        frame.setVisible (true);
    }
}
