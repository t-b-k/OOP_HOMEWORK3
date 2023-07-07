package ru.gb.lessons.interfaces.core.drugStore;

import org.w3c.dom.ls.LSSerializer;
import ru.gb.lessons.interfaces.core.clients.DoctorSpecialities;
import ru.gb.lessons.interfaces.core.personal.Doctor;

import java.io.Serializable;
import java.util.*;

import static ru.gb.lessons.interfaces.core.clients.DoctorSpecialities.THERAPIST;

public class Main {
    public static void main(String[] args) {

        Set<Pharmacy> resultSet = new HashSet<>();
        LinkedList<Pharmacy> resultList = new LinkedList<>();

        Component comp1 = new Component("Penicillin", "10 mg", 10);
        System.out.println("Компонент 1: ");
        comp1.showDetails();
        comp1.showHashCode();
        System.out.println();
        Component comp2 = new Component("Spirit", "100 g", 1000);
        System.out.println("Компонент 2: ");
        comp2.showDetails();
        comp2.showHashCode();
        System.out.println();
        System.out.println(String.format("(%s == %s) = %b", comp1.getName(), comp2.getName(), comp1.equals(comp2)));
        System.out.println(String.format("Равны ли компоненты %s и %s? Ответ - %b", comp1.getName(), comp2.getName(), comp1.equals(comp2)));
        System.out.println();
        Component comp3 = comp1;
        System.out.println("Компонент 3: ");
        System.out.println("Получен из Компонента 1 обычным присваиванием \"=\"");
        comp3.showDetails();
        System.out.println(String.format("Равны ли компоненты 1 и 3? Ответ - %b", comp1.equals(comp3)));
        comp1.showHashCode();
        comp3.showHashCode();
        System.out.println();
        System.out.println("Теперь создадим для переменной comp4 новый объект и скопируем в него все поля из comp1.");
        System.out.println("Компонент 4: ");
        Component comp4 = new Component(comp1.getName(), comp1.getWeight(), comp1.getPower());
        comp3.showDetails();
        System.out.println(String.format("Равны ли компоненты 1 и 4? Ответ - %b", comp1.equals(comp4)));
        comp1.showHashCode();
        comp4.showHashCode();
        System.out.println();

        System.out.println("Создали Препарат 1, состоящий из компонентов 1 и 2: ");
        Pharmacy pharmacy1 = new Pharmacy();
        pharmacy1.setName("Пенициллин");
        pharmacy1.addComponent(comp1).addComponent(comp2);
        pharmacy1.showFullInfo();
        System.out.println();

        System.out.println("Создадим Препарат 2, имеющий такое же название и такой же список компонентов, как у Препарата 1: ");
        ArrayList<Component> temp = new ArrayList<>();
        temp.addAll(pharmacy1.getComponents());
        Pharmacy pharmacy2 = new Pharmacy();
        pharmacy2.setName(pharmacy1.getName());
        pharmacy2.addComponents(temp);
        System.out.println("Препарат 2: точная копия Препарата 1");
        pharmacy2.showFullInfo();
        System.out.println();
        System.out.println("Добавим к Препарату 2 еще два компонента: ");
        Component comp5 = new Component("Nitrophuran", "16 mg", 109);
        Component comp6 = new Component("Aspirin", "125 g", 10001);
        comp5.showDetails();
        comp6.showDetails();
        pharmacy2.addComponent(comp5).addComponent(comp6);
        pharmacy2.setName("АспиНитроПенициллин");
        System.out.println();
        System.out.println(String.format("... назовем его: %s", pharmacy2.getName()));
        System.out.println("Препарат 2: ");
        pharmacy2.showFullInfo();
        System.out.println();

        System.out.println("Препарат 3: ");
        Pharmacy pharmacy3 = new Pharmacy();
        Component comp7 = new Component("Biseptol", "400 g", 13000);
        pharmacy3.addComponent(comp5).addComponent(comp6).addComponent(comp7);
        pharmacy3.setName("АспиНитроБисептол");
        pharmacy3.showFullInfo();
        System.out.println();

        System.out.println("Препарат 4: ");
        Pharmacy pharmacy4 = new Pharmacy();
        Component comp8 = new Component("Valeriana", "30 g", 5);
        Component comp15 = new Component("Valeriana", "30g", 5);
        System.out.println(String.format("Сравнение компонентов 8 и 15: %d", comp8.compareTo(comp15)));
        comp8.showHashCode();
        comp15.showHashCode();
        pharmacy4.addComponent(comp8);
        pharmacy4.setName("Валерианка");
        pharmacy4.showFullInfo();
        System.out.println();

        System.out.println("Препарат 5 - точная копия препарата 3: ");
        Pharmacy pharmacy5 = new Pharmacy();
        pharmacy5.setName(pharmacy3.getName());
        pharmacy5.addComponents(pharmacy3.getComponents());
        pharmacy5.showFullInfo();
        System.out.println();

        System.out.println(String.format("Совпадают ли препараты 3 и 5 по силе? %b", pharmacy5.compareByPower(pharmacy3)));
        boolean helpVariable = pharmacy5.componentsIdentical(pharmacy3);
        System.out.println(helpVariable);
        System.out.println(String.format("Совпадает ли препарат 5 с препаратом 3 по компонентам? %b", helpVariable));
        System.out.println(String.format("Одинаковы ли препараты 5 и 3? %b", pharmacy5.equals(pharmacy3)));
        System.out.println();

        System.out.println("Препарат 6: сумма препаратов 3 и 4");
        Pharmacy pharmacy6 = new Pharmacy();
        pharmacy6.setName(pharmacy3.getName().concat(pharmacy4.getName()));
        pharmacy6.addComponents(pharmacy3.getComponents());
        pharmacy6.addComponents(pharmacy4.getComponents());
        pharmacy6.showFullInfo();
        System.out.println();

        System.out.println("Создадим два препарата с разными названиями, несовпадающим перечнем компонентов, но одинаковых по составу и действию");
        Pharmacy pharmacy7 = new Pharmacy();
        Pharmacy pharmacy8 = new Pharmacy();
        Component comp9 = new Component("Cianid", "160 mg", 1600);
        Component comp10 = new Component("Arsenic", "125 g", 12500);
        Component comp11 = new Component("Cianid", "60 mg", 600);
        Component comp12 = new Component("Cianid", "100 mg", 1000);
        Component comp13 = new Component("Arsenic", "100 g", 10000);
        Component comp14 = new Component("Arsenic", "25 g", 2500);
        pharmacy7.setName("Poison1");
        pharmacy8.setName("Poison2");
        pharmacy7.addComponent(comp10).addComponent(comp11).addComponent(comp12);
        pharmacy8.addComponent(comp9).addComponent(comp13).addComponent(comp14);
        System.out.println("ПРЕПАРАТ 7: -----------------------------------------------------");
        pharmacy7.showFullInfo();
        System.out.println("СОЗДАЕМ МНОЖЕСТВО КОМПОНЕНТОВ ПРЕПАРАТА 7");
        ComponentsSet set1 = pharmacy7.getComponentsSet();
        System.out.println(set1);
        System.out.println(String.format("1 Хэш-код множества компонентов препарата 7 равен %d",set1.hashCode()));
        System.out.println("-----------------------------------------------------");
        System.out.println("ПРЕПАРАТ 8: ");
        pharmacy8.showFullInfo();
        System.out.println("СОЗДАЕМ МНОЖЕСТВО КОМПОНЕНТОВ ПРЕПАРАТА 8");
        ComponentsSet set2 = pharmacy8.getComponentsSet();
        System.out.println(set2);
        System.out.println(String.format("1 Хэш-код множества компонентов препарата 8 равен %d", set2.hashCode()));
        System.out.println("-----------------------------------------------------");
        pharmacy7.showFullInfo();
        pharmacy8.showFullInfo();
        System.out.println(String.format("2 Хэш-код множества компонентов препарата 7 равен %d", pharmacy7.getComponentsSet().hashCode()));
        System.out.println(String.format("2 Хэш-код множества компонентов препарата 8 равен %d", pharmacy8.getComponentsSet().hashCode()));
//        System.out.println(pharmacy7.getComponentsSet().hashCode());
//        System.out.println(pharmacy8.getComponentsSet().hashCode());

//        System.out.println(String.format("Идентичны ли составы Препаратов 7 и 8? %b", set1.equals(set2)));
        System.out.println(String.format("Идентичны ли составы Препаратов 7 и 8? %b", pharmacy7.getComponentsSet().equals(pharmacy8.getComponentsSet())));
        //       ВОПРОС: почему метод equals для ComponentSet выдает разный результат при передаче ему объектов и
        //       при вызове методов GetComponentsSet непосредственно из вызова данного метода????
        //      НЕ МОГУ ПОНЯТЬ.
        System.out.println(String.format("Равны ли объекты Препаратов 7 и 8? %b", pharmacy7.equals(pharmacy8)));
        System.out.println("Присвоим препаратам 7 и 8 одинаковые названия, раз у них идентичные составы");
        pharmacy7.setName("Deadly Poison");
        pharmacy8.setName("Deadly Poison");
        System.out.println(String.format("Равны ли объекты Препаратов 7 и 8? %b", pharmacy7.equals(pharmacy8)));
        System.out.println("Они не равны, потому что в них по-разному изложен состав, хоти сила одинаковая");
        // Добавим все созданные препараты в одно множество:
        System.out.println("Мы создали 8 препаратов. Создадим из них множество.");
        resultSet.add(pharmacy1);
        resultSet.add(pharmacy2);
        resultSet.add(pharmacy3);
        resultSet.add(pharmacy4);
        resultSet.add(pharmacy5);
        resultSet.add(pharmacy6);
        resultSet.add(pharmacy7);
        resultSet.add(pharmacy8);
        System.out.println("ИТОГОВОЕ МНОЖЕСТВО ПРЕПАРАТОВ: ");
        int counter = 1;
        for (Pharmacy elem: resultSet) {
            System.out.println(String.format("%d.", counter));
            elem.showFullInfo();
            counter++;
        }
        System.out.println("А теперь создадим из них список: ");
        resultList.add(pharmacy1);
        resultList.add(pharmacy2);
        resultList.add(pharmacy3);
        resultList.add(pharmacy4);
        resultList.add(pharmacy5);
        resultList.add(pharmacy6);
        resultList.add(pharmacy7);
        resultList.add(pharmacy8);

        System.out.println("ИТОГОВЫЙ СПИСОК ПРЕПАРАТОВ: ");
        counter = 1;
        for (Pharmacy elem: resultList) {
            System.out.println(String.format("%d.", counter));
            elem.showFullInfo();
            counter++;
        }
        // СРАВНИМ ПРЕПАРАТЫ 3 И 5 ИЗ ОДИНАКОВОГО КОЛИЧЕСТВА КОМПОНЕНТОВ, НО С РАЗНЫМИ ИМЕНАМИ
        System.out.println("СРАВНИМ ПРЕПАРАТЫ 3 И 5 ИЗ ОДИНАКОВЫХ КОМПОНЕНТОВ, И С ОДИНАКОВЫМИ ИМЕНАМИ");
        System.out.println(pharmacy3.compareTo(pharmacy5));
        // СРАВНИМ ПРЕПАРАТЫ 7 И 8 ИЗ ОДИНАКОВОГО КОЛИЧЕСТВА КОМПОНЕНТОВ, С ОДИНАКОВЫМИ ИМЕНАМИ И РАЗНОЙ СИЛОЙ
        System.out.println("СРАВНИМ ПРЕПАРАТЫ 7 И 8 ИЗ ОДИНАКОВОГО КОЛИЧЕСТВА КОМПОНЕНТОВ, С ОДИНАКОВЫМИ ИМЕНАМИ И РАЗНОЙ СИЛОЙ");
        System.out.println("ОТСОРТИРОВАННЫЙ СПИСОК КОМПОНЕНТОВ ПРЕПАРАТА 7");
        ArrayList<Component> orderedList7 = pharmacy7.sortComponents();
        System.out.println(orderedList7);
        System.out.println("ОТСОРТИРОВАННЫЙ СПИСОК КОМПОНЕНТОВ ПРЕПАРАТА 8");
        ArrayList<Component> orderedList8 = pharmacy8.sortComponents();
        System.out.println(orderedList8);
        System.out.println(pharmacy7.compareTo(pharmacy8));
//        Pharmacy pharmacy6 = new Pharmacy();
//        pharmacy6.addComponent(comp1).addComponent(comp4).addComponent(comp7);
//        Pharmacy pharmacy7 = pharmacy1;
//        Pharmacy pharmacy8 = new Pharmacy();
//        pharmacy8.addComponent(comp1).addComponent(comp8).addComponent(comp3).addComponent(comp2);
//
//

//        Интерфейс Serializable - отвечает за сериализацию объектов. Превращает объект в массив байтов, который потом
//        можно собрать обратно при помощи десериализатора.

//        List<Marker> markers = new ArrayList<>();
//        Doctor doc1 = new Doctor(234, "Петрович", THERAPIST, "8(495)429-43-23");
//        markers.add().add();

//        while (((Iterator<Component>) pharmacy1).hasNext()){
//            System.out.println(pharmacy1.next());
//        }
//        System.out.println(pharmacy1);

//        DogPharmacy dogPharmacy = new DogPharmacy();
//        System.out.println(dogPharmacy.hashCode());
//        for (Component elem : pharmacy1) {
//            System.out.println(elem);
//        }
//
//
//        List<Pharmacy> nomenclature = new ArrayList<>();
//        nomenclature.add(pharmacy3);
//        nomenclature.add(pharmacy1);
//        nomenclature.add(pharmacy2);
//
//        System.out.println(nomenclature);
//        Collections.sort(nomenclature);
//        System.out.println("============================================================================");
//        System.out.println(nomenclature);

    }

}
