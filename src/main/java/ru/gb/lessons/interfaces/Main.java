package ru.gb.lessons.interfaces;

import ru.gb.lessons.interfaces.core.clients.home.impl.Cat;
import ru.gb.lessons.interfaces.core.clients.home.impl.Dog;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;
import ru.gb.lessons.interfaces.core.clients.wild.impl.Duck;
import ru.gb.lessons.interfaces.core.clients.wild.impl.WildCat;

import java.time.LocalDate;
import java.lang.Class;
import java.util.Arrays;

/**
 Небольшая шпаргалка по синтаксису java:

 1) Названия классов в java - существительные с большой буквы верблюжьей нотацией: CamelCase;
 2) названия методов - отглагольные, с маленькой буквы, верблюжьей нотацией: getUserById;
 3) Названия переменных - существительные с маленькой буквы, верблюжьей нотацией: maxCount;
 4) названия пакетов в java существительные, всегда с маленькой буквы и в одно слово;
 -! Если логика классов внутри пакета не позволяет назвать все в одно существительное, надо вложить один пакет в другой.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Cat homeCat =
                new Cat(2, "Tom", 4, LocalDate.of(2022, 4,13), new Owner("Ivanov Ivan"));

        WildCat wildCat =
                new WildCat(
                        1, 4, LocalDate.of(2023, 1, 5), new Owner("incognito"));

        homeCat.hunt();
        wildCat.hunt();

        Dog dog = new Dog();
        dog.setName("Barbos");

        System.out.println(homeCat);
        System.out.println(dog);

        Duck duck = new Duck();
        System.out.println(duck);
        String typeOfElements;
        typeOfElements = String.valueOf(Class.forName(String.valueOf(duck.getClass().getInterfaces()[0].getTypeName())));
        System.out.println(typeOfElements);
        if (typeOfElements.contains("Flyable")) {
            System.out.println("Утка бегает");
        }
        System.out.println(Arrays.asList(duck.getClass().getInterfaces()));
        }
    }
