package selectionsortanimation;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;
import java.util.stream.IntStream;
import static selectionsortanimation.SelectionSortAnimation.*;

/**
 * Инициализация кнопок, вызов алгоритма сортировки, обновление гистограммы
 */
public class SelectionSort extends JPanel {

    private JButton stepBtn;
    private JButton resetBtn;
    private SelectionSortIterator it;
    int min;

    // {1..20}
    int[]array = IntStream.rangeClosed(1, ELEMENTS_COUNT).toArray();
    private selectionsortanimation.HistogramPanel histogram;

    SelectionSort() {
        stepBtn = new JButton("Следующий шаг");
        resetBtn = new JButton("Сброс");

        // Кнопка сброса
        resetBtn.addActionListener((ActionEvent e) -> {
            reset();
        });

        // Кнопка следующий шаг
        stepBtn.addActionListener((ActionEvent e) -> {

            // проверяет, есть ли у сортировки следующий шаг
            if (it.hasNext()) {


                // обновляем картинку с новыми данными
                int current = (int) it.next();
                int min = (int) it.min();
                System.out.println(Arrays.toString(this.array));
                System.out.println("min's index = " + min);

                updateView(current, min);

                // Выводим сообщение, если сортировка окончена
            } else {
                JOptionPane.showMessageDialog(null, "Сортировка завершена");
            }
        });


        // добавление компонентов на панель
        JPanel buttons = new JPanel();
        buttons.add(stepBtn);
        buttons.add(resetBtn);

        add(buttons, BorderLayout.SOUTH);

        histogram = new selectionsortanimation.HistogramPanel();
        histogram.updateHistogram(this.array, 0, 0);
        add(histogram, BorderLayout.CENTER);

        // сброс массива в рандомный порядок
        reset();
    }

    /**
     * Генерирует массив в случайном порядке и перерисовывает
     */
    private void reset() {
        // перетасуем существующий массив из 20 целых чисел в случайном порядке
        for (int i = 0; i < this.array.length; i++) {
            Random r = new Random();
            int swapIndex = r.nextInt(i + 1);

            int temp = this.array[i];
            this.array[i] = this.array[swapIndex];
            this.array[swapIndex] = temp;
        }

        this.it = new SelectionSortIterator(this.array);

        // обновляем картинку
        updateView(0, (int)it.min());
    }

    /**
     * Передает в updateHistogram только что отсортированный массив
     */
    private void updateView(int current, int minInd) {
        this.histogram.updateHistogram(this.array, current, minInd);
    }
}
