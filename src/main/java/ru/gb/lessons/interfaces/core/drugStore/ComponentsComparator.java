package ru.gb.lessons.interfaces.core.drugStore;

import java.util.Comparator;

// Данный класс позволяет правильным образом сортировать коллекции компонентов класса Component

public class ComponentsComparator implements Comparator<Object> {

    @Override
    public int compare(Object o, Object t1) {
        Component c1 = (Component) o;
        Component c2 = (Component) t1;
        int result = 0;
        if (c1.getName().equals(c2.getName())) {
            result = Integer.compare(c1.getPower(),c2.getPower());
        } else {
            if (c1.getName().compareTo(c2.getName()) > 0) result = 1;
            else result = -1;

        }
        return result;
    }
}
