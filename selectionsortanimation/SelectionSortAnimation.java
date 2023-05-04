package selectionsortanimation;

import java.awt.*;
import javax.swing.*;

public class SelectionSortAnimation extends JApplet {
    static int MAX_ELEMENT = 20;
    static int ELEMENTS_COUNT = 20;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Визуализация сортировки выбором");
        SelectionSortAnimation sortAnimation = new SelectionSortAnimation();

        frame.add(sortAnimation, BorderLayout.CENTER);

        selectionsortanimation.SelectionSort sortPanel = new selectionsortanimation.SelectionSort();
        sortAnimation.add(sortPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);
    }

}
