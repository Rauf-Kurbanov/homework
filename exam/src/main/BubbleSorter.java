package main;

import java.util.List;

/**
 *
 * @author paRRadox
 */
public class BubbleSorter<E> {

    public List<E> sort(List<E> inpList) {
        List<E> result = inpList;

        for (int i = result.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comp.compare(result.get(j), result.get(i)) > 0) {
                    swap(result, j, j + 1);
                }
            }
        }

        return result;
    }

    public BubbleSorter(Compareter<E> comp) {
        this.comp = comp;
    }

    private void swap(List<E> list, int i, int j) {
        E t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }
    
    private Compareter<E> comp;
}
