import javax.swing.*;
import java.util.Locale;

public class osDetection {

    public enum OSType {
        Windows, MacOS, Linux, Other
    };

    protected static OSType detectedOS;

    // Detects Operating System to print on the JSwing UI.

    public static void getOperatingSystemType() {
        if (detectedOS == null) {
            String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
            if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
                detectedOS = OSType.MacOS;
                isMac();
            } else if (OS.indexOf("win") >= 0) {
                detectedOS = OSType.Windows;
                isWin();
            } else if (OS.indexOf("nux") >= 0) {
                detectedOS = OSType.Linux;
                isUnix();
            } else {
                detectedOS = OSType.Other;
                autoDetectionFailed();
            }
        }
    }

    public static void isWin() {
        System.out.println("Win32/Win64 System");
    }

    public static void isMac() {
        System.out.println("XNU System");
    }

    public static void isUnix() {
        System.out.println("I run arch");
    }

    public static void autoDetectionFailed() {
        System.out.println("Unknown System");

        JOptionPane.showMessageDialog(null,
                "Operating System type not detected!",
                "Detection Failure",
                JOptionPane.WARNING_MESSAGE);
        try {
            System.out.println("The Operating system was not detected properly and for safety reasons it will now close. Submit an issue report on Github.");
            Thread.sleep(1000);
            exitSystem();
        } catch (InterruptedException ex) {
            System.out.println("The Operating system was not detected properly and for safety reasons it will now close. Submit an issue report on Github.");
            Thread.currentThread().interrupt();
            exitSystem();
        }
    }

    public static void exitSystem() {
        Runtime.getRuntime().exit(0);
    }
}