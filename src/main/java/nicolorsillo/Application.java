package nicolorsillo;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nicolorsillo.dao.ElementiBibliotecaDAO;
import nicolorsillo.dao.PrestitiDAO;
import nicolorsillo.dao.UtentiDAO;
import nicolorsillo.entities.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4w3d5pu");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        ElementiBibliotecaDAO elementiBibliotecaDAO = new ElementiBibliotecaDAO(em);
        UtentiDAO utentiDAO = new UtentiDAO(em);
        PrestitiDAO prestitiDAO = new PrestitiDAO(em);
        Faker faker = new Faker();
        Random random = new Random();
 /*
        for (int i = 0; i < 20; i++) {
            String isbn = faker.code().isbn10();
            String titolo = faker.book().title();
            int annoPubblicazione = faker.number().numberBetween(1900, 2027);
            int numeroPagine = faker.number().numberBetween(50, 1201);

            String tipo = random.nextBoolean() ? "libro" : "rivista";

            if (tipo.equals("libro")) {
                String autore = faker.book().author();
                String genere = faker.book().genre();

                Libro libro = new Libro(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere);
                elementiBibliotecaDAO.save(libro);
            } else {
                int randomPeriodicita = faker.number().numberBetween(1, 4);
                Periodicita periodicita = null;
                switch (randomPeriodicita) {
                    case 1:
                        periodicita = Periodicita.SETTIMANALE;
                        break;
                    case 2:
                        periodicita = Periodicita.MENSILE;
                        break;
                    case 3:
                        periodicita = Periodicita.SEMESTRALE;
                        break;
                }

                Rivista rivista = new Rivista(isbn, titolo, annoPubblicazione, numeroPagine, periodicita);
                elementiBibliotecaDAO.save(rivista);

            }
        }
        */


        /*
        System.out.println(elementiBibliotecaDAO.findByISBN("109388309X"));
        elementiBibliotecaDAO.deleteByISBN("109388309X");
        System.out.println(elementiBibliotecaDAO.findByISBN("109388309X"));
        */
        /*
        List<Libro> libriTrovati = elementiBibliotecaDAO.findByAutore("Mr.");
        for (Libro l : libriTrovati) {
            System.out.println(l.getTitolo() + " - " + l.getAutore());
        }

        List<ElementoBiblioteca> elementiTrovati = elementiBibliotecaDAO.findByAnnoPubblicazione(1903);
        for (ElementoBiblioteca e : elementiTrovati) {
            System.out.println(e.getTitolo() + " - " + e.getAnnoPubblicazione());
        }
        */
        /*
        for (int i = 0; i < 20; i++) {
            String nome = faker.name().firstName();
            String cognome = faker.name().lastName();
            LocalDate dataDiNascita = LocalDate.ofInstant(faker.date().birthday(13, 90).toInstant(), ZoneId.systemDefault());
            long numeroTessera = faker.number().randomNumber(12, true);

            Utente nuovoUtente = new Utente(nome, cognome, dataDiNascita, numeroTessera);
            utentiDAO.save(nuovoUtente);
        }
        */

        Utente marcell = utentiDAO.findByNumeroTessera(415052536710L);
        Utente ernesto = utentiDAO.findByNumeroTessera(418256045703L);
        ElementoBiblioteca anticHay = elementiBibliotecaDAO.findByISBN("1821301005");
        ElementoBiblioteca aTimeToKill = elementiBibliotecaDAO.findByISBN("1205749888");

//        Prestito nuovoPrestito = new Prestito(marcell, anticHay, LocalDate.now().minusDays(23));
//        Prestito nuovoPrestito = new Prestito(ernesto, aTimeToKill, LocalDate.now().minusDays(23))
//        Prestito nuovoPrestito = new Prestito(marcel, aTimeToKill, LocalDate.now().minusDays(23));
//        Prestito nuovoPrestito = new Prestito(ernesto, anticHay, LocalDate.now().minusDays(50));
//        prestitiDAO.save(nuovoPrestito);

/*
       List<Prestito> prestitiAttivi = prestitiDAO.findPrestitiDaNumeroTessera(418256045703L);
        for (Prestito p : prestitiAttivi) {
            System.out.println(p);
        }
        */
/*
        List<Prestito> prestitiScaduti = prestitiDAO.findPrestitiScaduti();
        for (Prestito p : prestitiScaduti) {
            System.out.println(p);
        }
*/
//        prestitiDAO.registraRestituzione(415052536710L, "1821301005", LocalDate.now());


    }
}
