package ru.gb.lessons.interfaces.core.personal;

import ru.gb.lessons.interfaces.core.clients.DoctorSpecialities;
import ru.gb.lessons.interfaces.core.clients.NurseSpecialities;

import java.time.LocalDate;
import java.util.LinkedHashMap;

import static ru.gb.lessons.interfaces.core.clients.DoctorSpecialities.THERAPIST;

public class Nurse {
    protected int vetPersonID;
    protected String fio;
    protected NurseSpecialities speciality;
    protected String phoneNumber;
    public Nurse (int id, String fio, NurseSpecialities speciality, String phone) {
        vetPersonID = id;
        this.fio = fio;
        this.speciality = speciality;
        this.phoneNumber = phone;
    }
    public Nurse (int id) {
        this(id, null, null, null);
    }
    public String getFIO () {
        return this.fio;
    }
    public void setFIO (String fio) {
        this.fio = fio;
    }
    public NurseSpecialities getSpeciality () {
        return this.speciality;
    }
    public void setSpeciality (NurseSpecialities speciality) {
        this.speciality = speciality;
    }
    protected int getNurseID () { return this.vetPersonID; }
    public void showNurseBriefInfo () {}
    public boolean makeInjection (int patientID, String drugName, double dose) {
        return true;
    }
    public boolean putDrip (int patientID, String drugName, double volume) {
        return true;
    }
    public boolean makeDressing (int patientID, String bodyPart, String drug) {
        return true;
    }

}
