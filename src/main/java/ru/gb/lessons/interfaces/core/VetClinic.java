package ru.gb.lessons.interfaces.core;


import org.w3c.dom.ls.LSOutput;
import ru.gb.lessons.interfaces.core.clients.Animal;
import ru.gb.lessons.interfaces.core.clients.Animals;
import ru.gb.lessons.interfaces.core.clients.Runnable;
import ru.gb.lessons.interfaces.core.clients.home.impl.*;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;
import ru.gb.lessons.interfaces.core.clients.wild.impl.Duck;
import ru.gb.lessons.interfaces.core.clients.wild.impl.Snake;
import ru.gb.lessons.interfaces.core.clients.wild.impl.WildCat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class VetClinic {
    private static int clientsCounter;
    private static int ownersCounter;
    private static List<Animal> animals;

    private static List<Animal> owners;

    static {
        clientsCounter = 0;
        ownersCounter = 0;
        animals = new ArrayList<>();
        owners = new ArrayList<>();
    }

    public static void main(String[] args) {
//        Human human = new Human("Пайтон");

        Cat fadei = new Cat(++clientsCounter, "Фадей", 4, LocalDate.of(2017, 3,
                17), null);
        Dog sebastyan = new Dog(++clientsCounter, "Себастьян", 4, LocalDate.of(2008, 12,
                11), null);

        Owner kalashnikovaTB = new Owner("Калашникова Татьяна Борисовна");
        kalashnikovaTB.setPet(fadei);
        kalashnikovaTB.setPet(sebastyan);

        fadei.setOwner(kalashnikovaTB);
        sebastyan.setOwner(kalashnikovaTB);

        System.out.println(fadei);
        System.out.println(sebastyan);
        animals.add(fadei);
        animals.add(sebastyan);

        AquaFish agata = new AquaFish();
        System.out.println(agata);
        agata.setId(++clientsCounter);
        agata.setName("Агата");
        agata.setOwner(new Owner("Окунев Владимир Пескаревич"));
        agata.setNumberOfLimbs(7);
        agata.setRegistrationDate(LocalDate.of(2013, 12, 31));
        System.out.println(agata);
        animals.add(agata);

        Parrot pirat = new Parrot(++clientsCounter, "Пират", 4, LocalDate.of(2020, 7,
                19), agata.getOwner());
        System.out.println(pirat);
        animals.add(pirat);

        Chicken clava = new Chicken(++clientsCounter, "Клава", 4, LocalDate.of(2018, 4,
                15), new Owner("Афанасьева Тамара Кондратьевна"));
        System.out.println(clava);
        animals.add(clava);

        Duck wildDuck1 = new Duck(++clientsCounter, 4, LocalDate.of(2023, 1,
                22), clava.getOwner());
        System.out.println(wildDuck1);
        animals.add(wildDuck1);

        Snake python1 = new Snake(++clientsCounter, 0, LocalDate.of(2019, 8, 31),
                new Owner("Бесстрашный Владлен Перфильевич"));
        System.out.println(python1);
        animals.add(python1);

        WildCat wildCat1 = new WildCat(++clientsCounter, 3, LocalDate.of(2019, 8,
                31), python1.getOwner());
        System.out.println(wildCat1);
        animals.add(wildCat1);

        System.out.println("\nНАШИ ПАЦИЕНТЫ: ");
        printPatients(animals);
        System.out.println("\nНАШИ БЕГАЮЩИЕ ПАЦИЕНТЫ: ");
        System.out.println(animals.get(0).getClass().getInterfaces()[0]);
        LinkedList<Animal> runningPatients = getRunnable();
        printPatients(runningPatients);
        System.out.println("\nНАШИ ПЛАВАЮЩИЕ ПАЦИЕНТЫ: ");
        LinkedList<Animal> swimmingPatients = getSwimable();
        printPatients(swimmingPatients);
        System.out.println("\nНАШИ ЛЕТАЮЩИЕ ПАЦИЕНТЫ: ");
        LinkedList<Animal> flyingPatients = getFlyable();
        printPatients(flyingPatients);
        System.out.println("\nНАШИ ПАЦИЕНТЫ, ИЗДАЮЩИЕ ЗВУКИ: ");
        LinkedList<Animal> soundingPatients = getSoundable();
        printPatients(soundingPatients);

//        System.out.println(runningPatients);

//        animals.add(human);
//        animals.add(cat);
//        for (Animals elem: animals) {
//            heal(elem);
//        }
    }

    static LinkedList<Animal> getRunnable() {
        LinkedList<Animal> result = new LinkedList<>();
        for (Animal patient: animals) {
            for (int i = 0; i < patient.getClass().getInterfaces().length; i++) {
                if (patient.getClass().getInterfaces()[i].toString().endsWith("Runnable")) {
                    result.add(patient);
                }
            }
        }
        return result;
    }
    static LinkedList<Animal> getSwimable() {
        LinkedList<Animal> result = new LinkedList<>();
        for (Animal patient: animals) {
            for (int i = 0; i < patient.getClass().getInterfaces().length; i++) {
                if (patient.getClass().getInterfaces()[i].toString().endsWith("Swimable")) {
                    result.add(patient);
                }
            }
        }
        return result;
    }
    static LinkedList<Animal> getFlyable() {
        LinkedList<Animal> result = new LinkedList<>();
        for (Animal patient: animals) {
            for (int i = 0; i < patient.getClass().getInterfaces().length; i++) {
                if (patient.getClass().getInterfaces()[i].toString().endsWith("Flyable")) {
                    result.add(patient);
                }
            }
        }
        return result;
    }
    static LinkedList<Animal> getSoundable() {
        LinkedList<Animal> result = new LinkedList<>();
        for (Animal patient: animals) {
            for (int i = 0; i < patient.getClass().getInterfaces().length; i++) {
                if (patient.getClass().getInterfaces()[i].toString().endsWith("Soundable")) {
                    result.add(patient);
                }
            }
        }
        return result;
    }
    static void printPatients (List<Animal> patients) {
        for (Animal item: patients) {
            System.out.println(item);
        }
    }

//    private static void heal (Animals patient) {
//
//        System.out.println(patient.getClassName() + " вылечен");
//    }
}
