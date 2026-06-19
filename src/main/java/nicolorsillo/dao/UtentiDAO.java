package nicolorsillo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import nicolorsillo.entities.Utente;

public class UtentiDAO {
    private final EntityManager em;

    public UtentiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente nuovoUtente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(nuovoUtente);
        transaction.commit();
        System.out.println("L'elemento " + nuovoUtente + " è stato salvato correttamente!");
    }

    public Utente findByNumeroTessera(long numeroTessera) {
        TypedQuery<Utente> query = em.createQuery("SELECT u FROM Utente u WHERE u.numeroTessera = :numeroTessera", Utente.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getSingleResult();
    }
}
