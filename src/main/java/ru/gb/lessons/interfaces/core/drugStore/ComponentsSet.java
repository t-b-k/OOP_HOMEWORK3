package ru.gb.lessons.interfaces.core.drugStore;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ComponentsSet {
    private TreeSet<Component> members;

    public ComponentsSet() {
        this.members = new TreeSet<Component>();
    }
    public TreeSet<Component> getMembers() {
        return this.members;
    }
    public ComponentsSet add (Component component) {
//        Component newComp = new Component();
        this.members.add(component);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Множество компонентов препарата состоит из: \n");
        for (Component elem: this.members) {
            res.append(elem.toString());
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        System.out.println(this.members);
        System.out.println(((ComponentsSet) o).getMembers());
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        if (this.members.size() != ((ComponentsSet) o).members.size()) return false;
        int hashSum1 = 0;
        for (Component thisElem : this.members) {
            hashSum1 = hashSum1 + thisElem.hashCode();
            }
        System.out.println(String.format("hashSum1 = %d", hashSum1));
        int hashSum2 = 0;
        for (Component otherElem : ((ComponentsSet) o).getMembers()) {
            hashSum2 = hashSum2 + otherElem.hashCode();
        }
        System.out.println(String.format("hashSum2 = %d", hashSum2));
        return (hashSum1 == hashSum2);
    }

    public int hashCode() {
        int result = 11;
        int factor = 5;
        for (Component elem: this.members) {
            result = result*factor + elem.hashCode();
        }
        return result>>>1;
    }
}
