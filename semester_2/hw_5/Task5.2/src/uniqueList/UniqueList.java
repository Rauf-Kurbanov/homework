/*
 * Унаследовать от класса "список" класс UniqueList, который не содержит повторяющихся значений. 
 * Реализовать классы исключений, которые генерируются при попытке добавления 
 * в такой список уже существующего или при попытке удаления несуществующего элемента.
 */
package uniqueList;

import list.*;

/**
 *
 * @author paRRadox
 */
public class UniqueList<T> extends LinkedList<T> {

    @Override
    public void add(T value) {
        if (super.contains(value)) {
            throw new AlreadyExistException();
        } else {
            super.add(value);
        }
    }

    @Override
    public void remove(T value) {
        if (!super.contains(value)) {
            throw new NotExistException();
        } else {
            super.remove(value);
        }
    }
}
