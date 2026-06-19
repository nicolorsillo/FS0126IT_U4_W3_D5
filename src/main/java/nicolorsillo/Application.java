package nicolorsillo;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import nicolorsillo.dao.ElementiBibliotecaDAO;
import nicolorsillo.entities.Libro;
import nicolorsillo.entities.Periodicita;
import nicolorsillo.entities.Rivista;

import java.util.Random;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4w3d5pu");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        ElementiBibliotecaDAO elementiBibliotecaDAO = new ElementiBibliotecaDAO(em);
       /* Faker faker = new Faker();
        Random random = new Random();

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

    }
}
