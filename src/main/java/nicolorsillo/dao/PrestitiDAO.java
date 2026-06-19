package nicolorsillo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import nicolorsillo.entities.Prestito;

import java.time.LocalDate;
import java.util.List;

public class PrestitiDAO {
    private final EntityManager em;

    public PrestitiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito nuovoPrestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(nuovoPrestito);
        transaction.commit();
        System.out.println("L'elemento " + nuovoPrestito + " è stato salvato correttamente!");
    }

    public List<Prestito> findPrestitiDaNumeroTessera(long numeroTessera) {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL", Prestito.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public List<Prestito> findPrestitiScaduti() {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL", Prestito.class);
        return query.getResultList();
    }

    public void registraRestituzione(long numeroTessera, String codiceISBN, LocalDate dataRestituzioneEffettiva) {
        EntityTransaction transaction = em.getTransaction();
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.elementoPrestato.codiceISBN = :codiceISBN AND p.dataRestituzioneEffettiva IS NULL", Prestito.class);
        query.setParameter("numeroTessera", numeroTessera);
        query.setParameter("codiceISBN", codiceISBN);
        Prestito prestitoAttivo = query.getSingleResult();

        transaction.begin();
        prestitoAttivo.setDataRestituzioneEffettiva(dataRestituzioneEffettiva);
        transaction.commit();

        System.out.println("Restituzione del libro" + prestitoAttivo.getElementoPrestato().getTitolo() + "registrata correttamente!");

    }

}
