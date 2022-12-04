import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JsonVersion {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        File file  = new File("src/main/resources/movie.json");
        MovieLibrary movieLibrary = objectMapper.readValue(file,MovieLibrary.class);
        System.out.println(movieLibrary);
        //musiałem dodać obsługę wyjątku bo inaczej podkreślało mi "readValue"
        //potrzebuje do zmapowania pustych konstruktorów:
//        public Person() {
//        }

//        select none

        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Podaj dwie daty aby wyświetlić nazwy filmów wydanych pomiędzy tymi datami");
        System.out.println("2 - Wyświetl wszystkie informacje o losowym filmie");
        System.out.println("3 - Podaj imię i nazwisko aktora aby wyświetlić nazwy filmów w jakich zagrał");
        System.out.println("Wybierz numer operacji i potwierdź ENTER");
        int number = scanner.nextInt();
        switch (number){
            case 1:
                System.out.println("Wpisz rok - początek zakresu");
                int start = scanner.nextInt();
                System.out.println("Wpisz rok - koniec zakresu");
                int end = scanner.nextInt();
                movieLibrary.getMoviesFromTo(start,end);
                break;
            case 2:
                movieLibrary.getRandomMovie();
                break;
            case 3:
                System.out.println("Wpisz imię aktora");
                String name = scanner.next();
                System.out.println("Wpisz nazwisko aktora");
                String sirname = scanner.next();
                movieLibrary.findMovies(name,sirname);
                break;
            default:
                System.out.println("Error error...");
        }
    }

}
