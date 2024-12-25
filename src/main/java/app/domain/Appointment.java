package app.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Appointment {

    private Long id;
    private LocalDateTime dateTime;
    private Patient patient;
    private List<Offer> appointmentOffers = new ArrayList<>();
    private boolean active;

    public Appointment() {
    }

    public Appointment(Long id, boolean active, List<Offer> appointmentOffers, Patient patient, LocalDateTime dateTime) {
        this.id = id;
        this.active = active;
        this.appointmentOffers = appointmentOffers;
        this.patient = patient;
        this.dateTime = dateTime;
    }

    public void addOffer(Offer offer){
        if (offer.isActive()){
            appointmentOffers.add(offer);
        }
    }

    public List<Offer> getAllActiveOffers(){
        return appointmentOffers.stream()
                .filter(Offer::isActive)
                .toList();
    }

    public void removeById(Long id){
        Iterator<Offer> iterator = appointmentOffers.iterator();
        while (iterator.hasNext()){
            Offer offer = iterator.next();
            if (offer.getId().equals(id)){
                iterator.remove();
                break;
            }
        }
    }

    public void removeAllOffers(){
        appointmentOffers.clear();
    }

    public double getAllActiveOffersTotalCost(){
         return appointmentOffers.stream()
                .filter(Offer::isActive)
                 .mapToDouble(Offer::getPrice)
                 .sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Offer> getAppointmentOffers() {
        return appointmentOffers;
    }

    public void setAppointmentOffers(List<Offer> appointmentOffers) {
        this.appointmentOffers = appointmentOffers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return active == that.active && Objects.equals(id, that.id) && Objects.equals(dateTime, that.dateTime) && Objects.equals(patient, that.patient) && Objects.equals(appointmentOffers, that.appointmentOffers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, patient, appointmentOffers, active);
    }

    @Override
    public String toString() {
        return "Прием: " +
                "id - " + id +
                ", дата: " + dateTime +
                ", пациент: " + patient +
                ", услуги: " + appointmentOffers +
                '.';
    }
}
