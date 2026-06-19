package nicolorsillo.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
    @Table(name = "elemento_biblioteca")
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ElementoBiblioteca {
        @Id
        @GeneratedValue
        private UUID id;

    @Column(name = "codice_isbn", nullable = false, unique = true)
    private String codiceIsbn;

    @Column(name = "titolo", nullable = false)
    private String titolo;

    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;

    @Column(name = "numero_pagine")
    private long numeroPagine;

        protected ElementoBiblioteca() {}

    public ElementoBiblioteca(String codiceIsbn, String titolo, int annoPubblicazione, long numeroPagine) {
            this.codiceIsbn = codiceIsbn;
            this.titolo = titolo;
            this.annoPubblicazione = annoPubblicazione;
            this.numeroPagine = numeroPagine;
    }


    @Override
    public String toString() {
        return "ElementoBiblioteca{" +
                "id=" + id +
                ", codiceIsbn='" + codiceIsbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
