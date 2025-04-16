import models.*;
import services.BibliotecaService;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BibliotecaService biblioteca = new BibliotecaService();

    public static void main(String[] args) {
        dateInitiale();
        meniu();
    }

    private static void dateInitiale() {
        Autor autor1 = new Autor("Ion Creanga", "ion@email.com", "0722123456", "Romana", 1837, 5);
        Autor autor2 = new Autor("Mihai Eminescu", "eminescu@email.com", "0722555666", "Romana", 1850, 10);
        Autor autor3 = new Autor("J.K. Rowling", "jk@email.com", "0755333444", "Britanica", 1965, 7);

        Editura e1 = new Editura("Polirom", "Iasi", 1991);
        Editura e2 = new Editura("Humanitas", "Bucuresti", 1990);
        Editura e3 = new Editura("Bloomsbury", "Londra", 1986);

        Sectiune s1 = new Sectiune("Literatura", "Etaj 1", 300);
        Sectiune s2 = new Sectiune("Fictiune", "Etaj 2", 150);
        Sectiune s3 = new Sectiune("Poezie", "Etaj 3", 100);

        Carte c1 = new Carte("Povestea lui Harap-Alb", autor1, "Fabula", 1877, s1, e1, 5);
        Carte c2 = new Carte("Luceafarul", autor2, "Poezie", 1883, s3, e2, 2);
        Carte c3 = new Carte("Harry Potter", autor3, "Ficțiune", 1997, s2, e3, 10);
        Carte c4 = new Carte("Scrisoarea III", autor2, "Poezie", 1881, s3, e2, 3);
        Carte c5 = new Carte("Amintiri din copilarie", autor1, "Autobiografie", 1880, s1, e1, 1);

        biblioteca.adaugaCarte(c1);
        biblioteca.adaugaCarte(c2);
        biblioteca.adaugaCarte(c3);
        biblioteca.adaugaCarte(c4);
        biblioteca.adaugaCarte(c5);

        Cititor cit1 = new Cititor("Ana Pop", "ana@email.com", "0711111111", 1, 20, true);
        Cititor cit2 = new Cititor("George Ionescu", "geo@email.com", "0722222222", 2, 35, false);
        Cititor cit3 = new Cititor("Mara Tudor", "mara@email.com", "0733333333", 3, 28, true);

        biblioteca.inregistreazaCititor(cit1);
        biblioteca.inregistreazaCititor(cit2);
        biblioteca.inregistreazaCititor(cit3);

        Bibliotecar b1 = new Bibliotecar("Ioana Dobre", "ioana@lib.com", "0744444444", 101, "Dimineața");
        Bibliotecar b2 = new Bibliotecar("Radu Munteanu", "radu@lib.com", "0755555555", 102, "Seara");

        biblioteca.inregistreazaBibliotecar(b1);
        biblioteca.inregistreazaBibliotecar(b2);

        biblioteca.imprumutaCarte(cit1, c1);
        biblioteca.imprumutaCarte(cit1, c3);
        biblioteca.imprumutaCarte(cit2, c2);
        biblioteca.imprumutaCarte(cit3, c4);
        biblioteca.imprumutaCarte(cit3, c3);
    }

    private static void meniu() {
        int optiune = -1;

        while (optiune != 0) {
            System.out.println("\n---- Meniu Biblioteca ----");
            System.out.println("1. Afiseaza toate carțile disponibile");
            System.out.println("2. Cauta o carte dupa titlu");
            System.out.println("3. Afiseaza cartile unui autor");
            System.out.println("4. Imprumuta o carte");
            System.out.println("5. Returneaza o carte");
            System.out.println("6. Afiseaza imprumuturile unui cititor");
            System.out.println("7. Vezi top 3 cititori activi");
            System.out.println("8. Afiseaza cartile dintr-o sectiune");
            System.out.println("9. Vezi cartea cu cel mai mare stoc");
            System.out.println("10. Afiseaza toti bibliotecarii");
            System.out.println("0. Iesire");

            System.out.print("Alege optiunea: ");
            optiune = Integer.parseInt(scanner.nextLine());

            switch (optiune) {
                case 1 -> biblioteca.afiseazaCartiDisponibile();
                case 2 -> {
                    System.out.print("Introdu titlul (sau parte din el): ");
                    String titlu = scanner.nextLine();
                    List<Carte> rezultate = biblioteca.cautaCarteDupaTitlu(titlu);

                    if (rezultate.isEmpty()) {
                        System.out.println("Nu s-au gasit carti cu titlul specificat.");
                    } else {
                        rezultate.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("Introdu numele autorului: ");
                    String numeAutor = scanner.nextLine();
                    biblioteca.afiseazaCartiDupaAutor(
                            biblioteca.topCititori().stream()
                                    .flatMap(c -> biblioteca.cautaCarteDupaTitlu("").stream())
                                    .map(Carte::getAutor)
                                    .filter(a -> a.getNume().equalsIgnoreCase(numeAutor))
                                    .findFirst().orElse(new Autor(numeAutor, "-", "-", "-", 0, 0))
                    );
                }
                case 4 -> {
                    System.out.print("ID cititor: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Titlul cartii: ");
                    String titlu = scanner.nextLine();

                    Cititor cititor = biblioteca.topCititori().stream()
                            .filter(c -> c.getIdCititor() == id).findFirst().orElse(null);

                    Carte carte = biblioteca.cautaCarteDupaTitlu(titlu).stream().findFirst().orElse(null);

                    if (cititor != null && carte != null) {
                        biblioteca.imprumutaCarte(cititor, carte);
                    } else {
                        System.out.println("Cititor sau carte inexistenta.");
                    }
                }
                case 5 -> {
                    System.out.print("ID cititor: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Titlul cartii: ");
                    String titlu = scanner.nextLine();

                    Cititor cititor = biblioteca.topCititori().stream()
                            .filter(c -> c.getIdCititor() == id).findFirst().orElse(null);

                    Carte carte = biblioteca.cautaCarteDupaTitlu(titlu).stream().findFirst().orElse(null);

                    if (cititor != null && carte != null) {
                        biblioteca.returneazaCarte(cititor, carte);
                    } else {
                        System.out.println("Cititor sau carte inexistenta.");
                    }
                }
                case 6 -> {
                    System.out.print("ID cititor: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    Cititor cititor = biblioteca.topCititori().stream()
                            .filter(c -> c.getIdCititor() == id).findFirst().orElse(null);

                    if (cititor != null) {
                        biblioteca.afiseazaImprumuturiCititor(cititor);
                    } else {
                        System.out.println("Cititor inexistent.");
                    }
                }
                case 7 -> {
                    System.out.println("Top 3 cititori:");
                    biblioteca.topCititori().forEach(System.out::println);
                }
                case 8 -> {
                    System.out.print("Nume sectiune: ");
                    String nume = scanner.nextLine();
                    biblioteca.afiseazaCartiDinSectiune(nume);
                }
                case 9 -> {
                    Carte c = biblioteca.carteCuCelMaiMareStoc();
                    System.out.println("Cartea cu cel mai mare stoc: " + c);
                }
                case 10 -> {
                    System.out.println("Bibliotecari inregistrati:");
                    biblioteca.topCititori().forEach(System.out::println);
                }
                case 0 -> System.out.println("La revedere!");
                default -> System.out.println("Optiune invalida.");
            }
        }
    }
}
