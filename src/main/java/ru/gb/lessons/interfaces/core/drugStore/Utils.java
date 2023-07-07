package ru.gb.lessons.interfaces.core.drugStore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    public LinkedList<Component> sortComponentsList (List<Component> sourceListOfComponents) {
        LinkedList<Component> result = copy(sourceListOfComponents);
        if (result != null) {
            for (int i = result.size()-1; i > 0 ; i--) {
                for (int j = 0; j < i; j++) {
                    if (result.get(j).compareTo(result.get(j+1)) == 1) {
                        Component temp = result.get(j);
                        result.set(j + 1, result.get(j));
                        result.set(j, temp);
                    }
                }
            }
        }
        return result;
    }
    public LinkedList<Component> copy (List<Component> sourceListOfComponents) {
        LinkedList<Component> result = new LinkedList<>();
        for (Component comp: sourceListOfComponents) {
            result.add(comp);
        }
        return result;
    }
}
