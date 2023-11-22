package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
        initialize();
    }

    private void initialize() {
        // Customize appearance
        setForeground(Color.WHITE);
        setBackground(Color.BLUE);
        setBorderPainted(false); // Remove border
        setFocusPainted(false); // Remove focus border

        // Add custom behavior
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Custom action when the button is clicked
                System.out.println("Custom Button Clicked!");
            }
        });
    }

    // Add additional custom methods or override existing ones as needed
}

class CustomButtonExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Button Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CustomButton customButton = new CustomButton("Click me");
            frame.getContentPane().add(customButton);

            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
