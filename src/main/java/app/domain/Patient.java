package app.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient {

    private Long id;
    private PetType petType;
    private String name;
    private  int age;
    private double weight;
    private String ownerName;
    private String address;
    private boolean active;
    List<Appointment> appointments = new ArrayList<>();

    public Patient(Long id, PetType petType,
                   String name, int age, double weight, String ownerName, String address, boolean active,
                   List<Appointment> appointments) {
        this.id = id;
        this.petType = petType;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.ownerName = ownerName;
        this.address = address;
        this.active = active;
        this.appointments = appointments;
    }

    public void addAppointment(Appointment appointment){
        if (appointment.isActive()){
            appointments.add(appointment);
        }
    }

    public List<Appointment> getAllActiveAppointments(){
        return appointments.stream()
                .filter(Appointment::isActive)
                .toList();
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return age == patient.age && Double.compare(weight, patient.weight) == 0 && active == patient.active && Objects.equals(id, patient.id) && petType == patient.petType && Objects.equals(name, patient.name) && Objects.equals(ownerName, patient.ownerName) && Objects.equals(address, patient.address) && Objects.equals(appointments, patient.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, petType, name, age, weight, ownerName, address, active, appointments);
    }

    @Override
    public String toString() {
        return "Пациент: " +
                "id - " + id +
                ", вид животного - " + petType +
                ", кличка - " + name +
                ", возраст - " + age +
                ", вес - " + weight +
                ", имя хозяина - " + ownerName +
                ". Адрес: " + address +
                "; клиент клиники - " + (active ? "да." : "выбыл.") +
                " Список посещений" + appointments +
                '.';
    }
}
