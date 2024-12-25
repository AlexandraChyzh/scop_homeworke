package app.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Offer {

    private Long id;
    private String title;
    private double price;
    private boolean active;


    public Offer() {
    }

    public Offer(Long id, String title, double price, boolean active) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        Offer offer = (Offer) o;
        return Double.compare(price, offer.price) == 0 && active == offer.active
                && Objects.equals(id, offer.id) && Objects.equals(title, offer.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, active);
    }

    @Override
    public String toString() {
        return "Услуга:" +
                "id - " + id +
                ", название - " + title +
                ", цена - " + price +
                ", доступна - " + (active? "да" : "нет") + '.';
    }
}
