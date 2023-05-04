package selectionsortanimation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import static selectionsortanimation.SelectionSortAnimation.*;

/**
 * Визуальное представление сортируемого массива
 */
public class HistogramPanel extends JPanel {

    private int[] array;
    private int current;
    private int minInd;
    private final int TOTAL_HEIGHT = 410;
    private final int TOTAL_WIDTH = 762;

    HistogramPanel() {
        setPreferredSize(new Dimension(this.TOTAL_WIDTH, this.TOTAL_HEIGHT));
    }

    /**
     * Отображает представление для текущего сортируемого массива
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(200,220,200));

        // рассчитать размеры
        int width = this.TOTAL_WIDTH / ELEMENTS_COUNT;
        int intHeight = this.TOTAL_HEIGHT / MAX_ELEMENT;


        // визуализировать каждый столбец гистограммы
        for (int i = 0; i < this.array.length; i++) {
            int height = intHeight * this.array[i];

            if (i == current) {
                g.setColor(Color.black);
            }else if (i == minInd){
                g.setColor(Color.pink);
            }
            else { g.setColor(Color.white); }


            g.fillRect(i * width, this.TOTAL_HEIGHT - height, width, height);
            g.setColor(Color.black);
            g.drawRect(i * width, this.TOTAL_HEIGHT - height, width, height);


            if (i == current) {
                g.setColor(Color.white);
            } else { g.setColor(Color.black); }
            g.drawString(String.valueOf(this.array[i]),
                    i * width + width / 2 - 7,
                    this.TOTAL_HEIGHT - (height / 2));
        }

    }

    // обновляем картинку
    public void updateHistogram (int[] array, int current, int minInd) {
        this.array = array;
        this.current = current;
        this.minInd = minInd;

        repaint();
    }
}
