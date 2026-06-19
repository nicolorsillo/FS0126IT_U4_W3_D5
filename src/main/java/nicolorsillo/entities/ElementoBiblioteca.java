package nicolorsillo.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "elemento_biblioteca")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_elemento")
public abstract class ElementoBiblioteca {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "codice_isbn", nullable = false, unique = true)
    private String codiceISBN;

    @Column(name = "titolo", nullable = false)
    private String titolo;

    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;

    @Column(name = "numero_pagine")
    private long numeroPagine;

    // Constructor

    protected ElementoBiblioteca() {
    }

    public ElementoBiblioteca(String codiceISBN, String titolo, int annoPubblicazione, long numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    // Getter

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    @Override
    public String toString() {
        return "ElementoBiblioteca{" +
                "id=" + id +
                ", codiceISBN='" + codiceISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                " ";
    }
}
