package app.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Appointment> appointments = new ArrayList<>();

        Patient patient = new Patient(1L, PetType.DOG, "Bob", 3, 8.09,
                "Ivan Petrov", "Feldstrasse, 83", true, appointments);
        System.out.println(patient);

        Offer offer = new Offer(1L,"Прививка",55.02, true);
        System.out.println(offer);

        List<Offer> offers = new ArrayList<>();

        Appointment appointment = new Appointment(1L, true, offers, patient,
                LocalDateTime.of(2025, 1, 12, 14, 0));
        System.out.println(appointment);
    }
}
