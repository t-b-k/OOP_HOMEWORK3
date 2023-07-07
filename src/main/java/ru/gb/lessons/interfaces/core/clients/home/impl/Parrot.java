package ru.gb.lessons.interfaces.core.clients.home.impl;

import ru.gb.lessons.interfaces.core.clients.Flyable;
import ru.gb.lessons.interfaces.core.clients.Soundable;
import ru.gb.lessons.interfaces.core.clients.Runnable;
import ru.gb.lessons.interfaces.core.clients.home.Pet;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;

import java.time.LocalDate;

public class Parrot extends Pet implements Flyable, Runnable, Soundable {
    public Parrot(){

    }
    public Parrot (int id, String name, int numberOfLimbs, LocalDate registrationDate, Owner owner) {
        super(id, name, numberOfLimbs, registrationDate, owner);
    }

    @Override
    public int runs() {
        return 4;
    }
    @Override
    public int flies() {
        return 20;
    }
    @Override
    public void sounds() {
        System.out.println("- Попка дур-р-рак!!!");
    }

}
