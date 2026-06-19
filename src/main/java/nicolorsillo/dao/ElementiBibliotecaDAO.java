package nicolorsillo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import nicolorsillo.entities.ElementoBiblioteca;
import nicolorsillo.entities.Libro;
import nicolorsillo.exceptions.NotFoundException;

import java.util.List;

public class ElementiBibliotecaDAO {
    private final EntityManager em;

    public ElementiBibliotecaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoBiblioteca nuovoElementoBiblioteca) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(nuovoElementoBiblioteca);
        transaction.commit();
        System.out.println("L'elemento " + nuovoElementoBiblioteca + " è stato salvato correttamente!");
    }

    public ElementoBiblioteca findByISBN(String codiceISBN) {
        TypedQuery<ElementoBiblioteca> query = em.createQuery("SELECT e FROM ElementoBiblioteca e WHERE e.codiceISBN = :codiceISBN", ElementoBiblioteca.class);
        query.setParameter("codiceISBN", codiceISBN);
        return query.getSingleResult();
    }

    public void deleteByISBN(String codiceISBN) {
        EntityTransaction transaction = em.getTransaction();
        ElementoBiblioteca found = this.findByISBN(codiceISBN);
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'elemento con ISBN " + codiceISBN + " è stato eliminato correttamente!");
    }

    public List<ElementoBiblioteca> findByAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<ElementoBiblioteca> query = em.createQuery("SELECT e FROM ElementoBiblioteca e WHERE e.annoPubblicazione = :annoPubblicazione", ElementoBiblioteca.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();
    }

    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE LOWER(l.autore) LIKE LOWER(:param)", Libro.class);
        query.setParameter("param", autore + "%");
        return query.getResultList();
    }
}
