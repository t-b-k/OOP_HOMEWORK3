package ru.gb.lessons.interfaces.core.drugStore;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Component implements Comparable<Component> {
    private String name;
    private String weight;
    private int power;

    public Component(String name, String weight, int power) {
        this.name = name;
        this.weight = weight;
        this.power = power;
    }
    public Component() {
        this.name = "";
        this.weight = "";
        this.power = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public String getName() {
        return this.name;
    }
    public String getWeight() {
        return this.weight;
    }
    public int getPower() {
        return this.power;
    }

    // Метод позволяет увеличить силу вес компонента препарата.
    // применяется при создании множества компонентов, если в инструкции к препарату некоторый компонент
    // встречается не один раз
    void addWeight (String additionWeight) {
        this.weight = weight.concat(" + ").concat(additionWeight);

    }
    // Метод позволяет увеличить силу компонента препарата.
    // применяется при создании множества компонентов, если в инструкции к препарату некоторый компонент
    // встречается не один раз
   void addPower(int additionPower) {

        this.power += additionPower;
    }

    @Override
    public String toString() {
        return "Компонент: " +
                "Name = " + name + ", Weight = " + weight + ", Power= " + power + ", HashCode = " + this.hashCode() + "\n";
    }
    protected void showHashCode() {
        System.out.println(String.format("Хеш-код компонента %s равен %s", getName(), hashCode()));
    }
    protected void showDetails() {
        System.out.println(String.format("Компонент %s: вес %s, сила  - %d ед.", getName(), getWeight(), getPower()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        int factor = 31;
        result = result*factor + this.name.hashCode();
//      Поскольку вес компонента может быть записан в инструкции по-разному, не включаем его в метод вычисления хеша
//      Пример: 50мг или 0.05 г
//        result = result*factor + this.weight.hashCode();
        result = (result*factor + this.power)>>>1;
        return result;
    }

    // Компоненты равны, если у них одинаковые имена и силы
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Component comp = (Component)o;
        return this.name.equals((comp.getName())) && this.power == comp.getPower();
    }

    public int compareTo (Component o) {
        int result = 0;
        if (name.equals(o.getName())) {
            result = Integer.compare(power, o.getPower());
//            System.out.println("Результат сравнения силы препаратов");
//            System.out.println(result);
        } else {
            if (name.compareTo(o.getName()) > 0) result = 1;
            else result = -1;
//            System.out.println("Результат сравнения названий препаратов препаратов");
//            System.out.println(result);
        }
//        System.out.println("Результат метода compareTo");
//        System.out.println(result);
        return result;
    }

}
