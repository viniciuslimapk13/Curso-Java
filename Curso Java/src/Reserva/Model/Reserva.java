package Reserva.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate agora = LocalDate.now();

    private BigDecimal numero;
    private LocalDate checkin;
    private LocalDate checkout;

    public Reserva(BigDecimal numero, LocalDate checkin, LocalDate checkout) {
        if(checkin.isBefore(agora) || checkout.isBefore(agora)){
            throw new IllegalArgumentException("Data menor que atual");
        }
        if(checkin.isAfter(checkout)){
            throw new IllegalArgumentException("Data checkin maior que checkout");
        }
        this.numero = numero;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BigDecimal getNumero() {
        return numero;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public BigDecimal duracao(){
        return BigDecimal.valueOf(ChronoUnit.DAYS.between(checkin,checkout));
    }

    public void updateData(LocalDate checkin, LocalDate checkout){
        if(checkin.isBefore(agora) || checkout.isBefore(agora)){
            throw new IllegalArgumentException("Data menor que atual");
        }
        if(checkin.isAfter(checkout)){
            throw new IllegalArgumentException("Data checkin maior que checkout");
        }
        setCheckin(checkin);
        setCheckout(checkout);
    }

    public String toString() {
        return "Reservation: Room "+ numero+
                ", check-in: " + checkin.format(format) +
                ", check-out: " + checkout.format(format) +
                ", " +duracao()+ " nights";
    }
}

