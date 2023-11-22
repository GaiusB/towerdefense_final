package Window;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class AWindow extends JPanel implements IWindow, ActionListener {
    private ArrayList<JButton> buttonList = new ArrayList<>();

    // size = new Dimension(640, 800);
    // setMinimumSize(size);
    // setMaximumSize(size);
    // setPreferredSize(size);

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        draw(G);
    }

    @Override
    public void setUpButton(JButton b, int x, int y, int w, int h) {
        b.setBounds(x, y, w, h); // definir le bouton
        add(b); // ajoute le bouton au panel
        buttonList.add(b);
    }

    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }

    @Override
    public void handleRefresh() {
        // Implémentation par défaut (à adapter dans chaque classe concrète)
    }

    @Override
    public void printRefreshCount() {
        // Implémentation par défaut (à adapter dans chaque classe concrète)
    }

    // protected void addButton(JButton button) {
    //     buttonList.add(button);
    // }

    public abstract void draw(Graphics g);

    public abstract void changePanel();

}
