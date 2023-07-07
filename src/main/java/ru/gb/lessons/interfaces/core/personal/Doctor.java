package ru.gb.lessons.interfaces.core.personal;

import ru.gb.lessons.interfaces.core.clients.DoctorSpecialities;
import ru.gb.lessons.interfaces.core.clients.supports.Record;
import ru.gb.lessons.interfaces.core.drugStore.Marker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;

import static ru.gb.lessons.interfaces.core.clients.DoctorSpecialities.THERAPIST;

public class Doctor implements Marker {
    protected int vetPersonID;
    protected String fio;
    protected DoctorSpecialities speciality;
    protected String phoneNumber;
//    protected vetPersonSchedule doctorSchedule;

    public Doctor(int id, String fio, DoctorSpecialities speciality, String phone) {
        vetPersonID = id;
        this.fio = fio;
        this.speciality = speciality;
        this.phoneNumber = phone;
    }
    public Doctor(int id) {
        this(id, null, null, null);
    }
    public String getFIO () {
        return this.fio;
    }
    public void setFIO (String fio) {
        this.fio = fio;
    }
    public DoctorSpecialities getSpeciality () {
        return this.speciality;
    }
    public void setSpeciality (DoctorSpecialities speciality) {
        this.speciality = speciality;
    }
    protected int getDoctorID () { return this.vetPersonID; }
    public void showDoctorBriefInfo () {}
    public Record acceptPatient (int patientID) {
        // Метод возвращает запись в карточку пациента
        Record newRecord = new Record("", new Date());
        return newRecord;
    }

}
