package nicolorsillo.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("Rivista")

public class Rivista  extends ElementoBiblioteca{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    protected Rivista(){}

    public Rivista(String codiceIsbn, String titolo, int annoPubblicazione, long numeroPagine, Periodicita periodicita){
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                "} " + super.toString();
    }
}
