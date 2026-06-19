package nicolorsillo.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Libro")
public class Libro extends ElementoBiblioteca{
    private String autore;
    private String genere;

    // Constructor

    protected  Libro() {
    }
    public Libro(String codiceIsbn, String titolo, int annoPubblicazione, long numeroPagine, String autore, String genere) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return super.toString() +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                "}" ;
    }
}
