package ru.gb.lessons.interfaces.core.clients;

/**
 Абстракция человека
 */
public class Human { // todo на семинаре, в учебных целях, сделать extends Animal
    protected final String fullName;

    public Human(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
