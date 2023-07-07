package ru.gb.lessons.interfaces.core.clients.home.impl;

import ru.gb.lessons.interfaces.core.clients.Swimable;
import ru.gb.lessons.interfaces.core.clients.home.Pet;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;

import java.time.LocalDate;

public class AquaFish extends Pet implements Swimable {
    public AquaFish() {

    }
    public AquaFish (int id, String name, int numberOfLimbs, LocalDate registrationDate, Owner owner){
        super (id, name, numberOfLimbs, registrationDate, owner);
    }

    @Override
    public int swims() {
        return 4;
    }
}
