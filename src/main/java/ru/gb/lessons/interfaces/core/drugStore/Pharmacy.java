package ru.gb.lessons.interfaces.core.drugStore;

import java.util.*;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy>, Marker {
    private String name;
    private List<Component> components;
    private int componentsCount;

    public Pharmacy() {
        this.name = "NoName";
        this.components = new ArrayList<>();
        this.componentsCount = 0;
    }
    public int getComponentsCount() {
        return componentsCount;
    }
    public ArrayList<Component> getComponents() {

        return (ArrayList<Component>)components;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // Добавление к препарату списка компонентов
    public void addComponents (ArrayList<Component> compList) {
        components.addAll(compList);
        componentsCount = componentsCount + compList.size();
    }
    // Добавление к препарату одного компонента
    public Pharmacy addComponent (Component component) {
        this.components.add(component);
        this.componentsCount++;
        return this;
    }
    // Метод возвращает копию компонента препарата для добавления его во множество компонентов
    // Без этого метода формирование множества почему-то портило исходный объект (список препаратов в нем)
    public Component createCopy(Component sourceComponent) {
        Component newElem = new Component();
        newElem.setName(sourceComponent.getName());
        newElem.setWeight(sourceComponent.getWeight());
        newElem.setPower(sourceComponent.getPower());
        return newElem;
    }
    // Метод возвращает копию списка компонента препарата для его последующей модификацию с целью сравнения
    public ArrayList<Component> createCopy (ArrayList<Component> sourceComponentList) {
        ArrayList<Component> newComponentList = new ArrayList<>();
        for (int i = 0; i < sourceComponentList.size(); i++) {
            newComponentList.add(new Component());
            newComponentList.set(i, createCopy(sourceComponentList.get(i)));
        }
        return newComponentList;
    }
    // Вывод в консоль полной информации о препарате: список компонентов, сила, хеш-код
    public void showFullInfo () {
        showComponents();
        showPharmacyPower();
        showHashCode();
    }
    // Вывод в консоль списка компонентов препарата (как в инструкции)
    public void showComponents() {
        System.out.println(String.format("Состав препарата %s: ", name));
        for (Component elem : components) {
            elem.showDetails();
        }
    }
    // Вывод в консоль хеш-кода препарата
    public void showHashCode() {
        System.out.println(String.format("HashCode препарата %s = %d", getName(), hashCode()));
    }
    // Вывод в консоль силы препарата
    public void showPharmacyPower() {
        System.out.println(String.format("Сила препарата %s = %d: ", getName(), getPower()));
    }
    // Метод toString, написанный на семинаре 3
    @Override
    public String toString() {
        return "Pharmacy {" +
                "components=" + components +
                ", index=" + componentsCount +
                '}' + "Total power = " + getPower()+"\n";
    }
    // Итератор для сравнения компонентов
    @Override
    public Iterator<Component> iterator() {
        return new ComponentIterator();
//        ДЕЛАЛИ НА СЕМИНАРЕ, НЕ ХОЧУ УДАЛЯТЬ
//  Альтернативная реализация с использованием анонимного класса
//        return new Iterator<Component>() {
//            public Component next() {
//                return components.get(componentsCount++);
//            }
//
//            public boolean hasNext() {
//                return componentsCount < components.size();
//            }
//        };
    }
    // Переопределили метод CompareTo для объектов класса Pharmacy
    // Метод сравнивает препараты по силе методом сравнения целых чисел:
    // если силы равны, возвращается 0,
    // если сила первого препарата меньше силы второго, возвращается -1,
    // если сила первого препарата больше первого, возвращает 1.
    // Если силы препаратов равны, сравниваются на равенство множества компонентов как множества.
    // Если они равны, метод возвращает 0.
    // Если множества компонетов различны, приводим оба множества к строковому типу и сравниваем как строки.
//    @Override
//    public int compareTo(Pharmacy o) {
//        if (this.compareByPower(o) == 0) {
//                TreeSet<Component> set1 = new TreeSet(this.getComponents());
//                TreeSet<Component> set2 = new TreeSet(o.getComponents());
//                if (set1.equals(set2)) {return 0;}
//                else return set1.toString().compareTo(set2.toString());
//        } else return this.compareByPower(o);
//    }

// Метод сравнения двух препаратов.
// Если сравнение препаратов по силе дает 0 (то есть, они равны по силе),
// сравнивает их упорядоченные списки компонентов (из инструкции) покомпонентно до первого неравенства.
// Один компонент больше другого, если:
// - У них одинаковые названия, но сила первого больше силы второго, либо
// - Имя одного компонента (как строковое значение) больше имени другого
    public int compareTo (Pharmacy otherPharm){
        int res = compareByPower(otherPharm);
        if (res == 0) {
            ArrayList<Component> sortedList1 = createCopy ((ArrayList<Component>)this.components);
            sortComponents(sortedList1);
            ArrayList<Component> sortedList2 = createCopy ((ArrayList<Component>)otherPharm.components);
            sortComponents(sortedList2);
            res = compareComponents(sortedList1, sortedList2);
        }
        return res;
    }
    // Метод сортировки списка компонентов препарата по возрастанию методом compareTo
    public void sortComponents (ArrayList<Component> listOfComp) {
            Collections.sort(listOfComp, new ComponentsComparator());
        }

    // Метод сравнения двух отсортированных по возрастанию списков компонентов (применяется в CompareTo)
    public int compareComponents (ArrayList<Component> one, ArrayList<Component> another) {
        if (one == null && another == null) return 0;
        else if (one ==null) return -1;
        else if (another == null) return 1;
        else {
            int sizeCompareResult = Integer.compare(one.size(), another.size());
            if (sizeCompareResult != 0) return sizeCompareResult;
            else {
                int i = 0;
                int result = 0;
                while (i < one.size() && result == 0) {
                    result = one.get(i).compareTo(another.get(i));
                    i++;
                }
                return result;
            }
        }
    }

    // Метод сравнивает два препарата по силе суммированием сил компонентов
    public int compareByPower(Pharmacy o) {
        int pow1 = getPower();
        int pow2 = o.getPower();
        return Integer.compare(pow1, pow2);
    }
    // Метод вычисляет силу препарата как сумму сил его компонетов
    public int getPower() {
        int result = 0;
        for (Component elem: getComponents()) {
            result += elem.getPower();
        }
        return result;
    }
    // Метод проверяет два объекта препарата на полную идентичность именно как объектов
    // возвращает 1, если у препаратов полностью совпадают названия и описание состава (инструкция).
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        if (this.name.equals(((Pharmacy) o).getName())) {
            for (int i = 0; i < this.componentsCount; i++) {
                if (!this.components.get(i).equals(((Pharmacy) o).getComponents().get(i))) return false;
            }
            return true;
        }
        return false;
    }

    // Метод возвращает множество компонентов препарата, суммируя вес и силу препаратов с одинаковыми названиями
    // (на случай, если какой-то препарат в списке препаратов встречается дважды. Это маловероятная ситуация, конечно, но так интереснее ).
    public ComponentsSet getComponentsSet() {
        ComponentsSet result = new ComponentsSet();
        int cycleCountOut = 1;
        for (Component nextElem : this.getComponents()) {
            boolean met = false;
            int cycleCountIn = 1;
            for (Component resElem : result.getMembers())
            {
                if (nextElem.getName().equals(resElem.getName())) {
                    met = true;
                    resElem.addPower(nextElem.getPower());
                    resElem.addWeight(nextElem.getWeight());
                }
                cycleCountIn++;
            }
            if (met == false) {
                Component newSetElem = createCopy(nextElem);
                result.add(createCopy(nextElem));
            }
            cycleCountOut++;
        }
        return result;
    }
    // Метод сравнивает состав двух препаратов на аналогичность.
    // Препараты аналогичны, если у них одинаковые множества входящих в их состав компонентов.
    // Уникальность проверяется путем суммирования хэш-кодов компонентов, которые зависят только от названия и силы.
    public boolean componentsIdentical (Pharmacy o) {
        return this.getComponentsSet().equals(o.getComponentsSet());
    }
//        if (this.components.size() == o.getComponents().size()) {
//            result = true;
//            for (int i = 0; i < this.components.size(); i++) {
//                if (!this.components.get(i).equals(o.getComponents().get(i))) return false;
//            }
//        }
    @Override
    public int hashCode() {
        int result = 19;
        int factor = 31;
        result = result*factor + this.name.hashCode();
        result = result*factor + this.componentsCount;
        for (int i = 0; i < this.components.size(); i++) {
            result = result*factor + this.components.get(i).hashCode();
        }
        return result>>>1;
    }
}
