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

    // Constructor

    protected Rivista(){}

    public Rivista(String codiceIsbn, String titolo, int annoPubblicazione, long numeroPagine, Periodicita periodicita){
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString() +
                "periodicita=" + periodicita +
                "}";
    }
}
