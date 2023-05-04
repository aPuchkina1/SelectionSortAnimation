package selectionsortanimation;

import java.util.Iterator;

/**
 * проходит через каждый внешний цикл сортировки.
 */
public class SelectionSortIterator implements Iterator {
    int[] array;
    int counter = 0;
    int length;

    SelectionSortIterator(int arr[]) {
        this.array = arr;
        this.length = arr.length;
    }

    /**
     * Проверяет, остались ли у сортировки шаги
     */
    @Override
    public boolean hasNext() {
        return counter < this.length;
    }

    /**
     * Находит индекс наименьшего элемента
     */
    public Object min(){
        int j, minIndex = counter;
        int n = length;

        for (j = counter + 1; j < n; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex != counter - 1)
            return minIndex;
        else return -1;
    }

    /**
     * Проходит один раз через цикл сортировки
     */
    @Override
    public Object next() {
        int j, minIndex = counter;
        int tmp;
        int n = length;

        for (j = counter + 1; j < n; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }

        if (minIndex != counter) {
            tmp = array[counter];
            array[counter] = array[minIndex];
            array[minIndex] = tmp;
        }

        return counter++;
    }




}
