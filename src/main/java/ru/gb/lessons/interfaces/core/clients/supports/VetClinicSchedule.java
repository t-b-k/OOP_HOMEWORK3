package ru.gb.lessons.interfaces.core.clients.supports;

import java.util.LinkedList;

public class VetClinicSchedule {
    public static final int DATE = 0; // номер записи о дате в строке расписания
    public static final int CAB = 1;
    public static final int START_TIME = 2;
    public static final int END_TIME = 3;
    public static final int DOCTOR_ID = 4;
    public static final int PATIENT_ID = 5;
    public static final int FIELDS_NUMBER = 6;

    public static final LinkedList<String[]> VET_SCHEDULE = new LinkedList<>();
}
