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
    void addWeight (String additionWeight) {
        this.weight = weight.concat(" + ").concat(additionWeight);
    }
   void addPower(int additionPower) {
        this.power += additionPower;
    }

    @Override
    public String toString() {
        return "Компонент: " +
                "Name = " + name + ", Weight = " + weight + ", Power= " + power + ", HashCode = " + this.hashCode() + "\n";
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

    protected void showHashCode() {
        System.out.println(String.format("Хеш-код компонента %s равен %s", getName(), hashCode()));
    }
    protected void showDetails() {
        System.out.println(String.format("%s, %s, сила компонента - %d ед.", getName(), getWeight(), getPower()));
    }

    @Override
    public int hashCode() {
        int result = 17;
        int factor = 31;
        result = result*factor + this.name.hashCode();
//        result = result*factor + this.weight.hashCode();
        result = (result*factor + this.power)>>>1;
        return result;
    }

    // Компоненты равны, если у них одинаковые имена и сила
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Component comp = (Component)o;
        return this.name.equals((comp.getName())) && this.power == comp.getPower();
    }

    public int compareTo (Component o) {
        int result;
        if (this.name.equals(o.getName())) {
            result = Integer.compare(this.power, o.getPower());
        } else {
            result = this.name.compareTo(o.getName());
        }
        return result;
    }

}
