package ua.edu.ukma.ykrukovska.models.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamHome {

    private final static String FILE = "C:\\IdeaProjects\\Files\\Text1.txt";

    public static void main(String[] args) {

        //Task 1
        IntStream si1 = IntStream.of(5, 8, 0, 10, -2, 2, 8, 93, -5, 0, 67, 22);
        System.out.println("Sum of odd = " + sumOdd(si1, 10));

        //Task 2
        bigPrimeDiv(5).limit(7).forEach(System.out::println);

        //Task 3
        IntStream si3 = IntStream.of(1, 37, 41, 3, 5, 83, 7, -11, 13, 0, -29, 31, 1, 79);
        System.out.println("Max prime number = " + maxPrime(si3, 31));

        //Task 4
        allIdens(" bcv555 55 5abc6 b  a abbbcbaav jk abnm ").forEach(System.out::println);

        //Task 5
        System.out.println(minIden(FILE));

        //Task 7
        System.out.println(Arrays.toString(allTypesAuthor(BookA.library(), "Buchman S.")));

        //Task 8
        System.out.println(cntAuthor(BookA.library(), "children"));

        //Task 9
        System.out.println(maxPagesBook(BookA.library(), "Buchman S.", "Schadenfreude Press"));
    }

    public static OptionalInt maxPagesBook(Stream<BookA> library, String aut, String pub) {

        return OptionalInt.of(library.filter(x -> x.getPubName()
                .equals(pub))
                .filter(b -> isIn(b.getAuthors(), aut))
                .max((x, y) -> x.getPages() - y.getPages())
                .map(BookA::getPages)
                .get());
    }

    public static long cntAuthor(Stream<BookA> library, String type) {

        Stream<String[]> authors = library
                .filter(b -> isIn(b.getTypes(), type))
                .map(BookA::getAuthors);

        return authors.flatMap(x -> Arrays.stream(x))
                .distinct()
                .count();
    }

    static public String[] allTypesAuthor(Stream<BookA> library, String aut) {
        Stream<String[]> types = library.filter(b -> isIn(b.getAuthors(), aut))
                .map(BookA::getTypes);

        return types.flatMap(x -> Arrays.stream(x))
                .distinct()
                .sorted()
                .toArray(String[]::new);
    }

    public static Optional<String> minIden(String file) {
        try (Stream<String> stream = Files.lines(Paths.get(file))) {
            return stream
                    .flatMap(line -> Arrays.stream(line.split("\\s"))) //add this
                    .filter(x -> isId(x))
                    .sorted()
                    .findFirst();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static Stream<String> allIdens(String word) {
        return Arrays.stream(word.split("\\s")).filter(x -> isId(x));
    }

    private static boolean isId(String x) {
        Pattern pat = Pattern.compile("[A-Za-z]\\w*");
        Matcher mch = pat.matcher(x);
        return mch.matches();
    }

    public static int sumOdd(IntStream is, int m) {
        return is.filter(x -> x % 2 == 0).filter(x -> x < m).sum();
    }

    public static IntStream bigPrimeDiv(int n) {
        return IntStream.iterate(n, x -> x + 1)
                .map(x -> divider(x));

    }

    private static int divider(int x) {
        for (int i = x; i >= 2; i--) {
            if (isPrime(i) && x % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static OptionalInt maxPrime(IntStream is, int n) {
        return is.filter(x -> x > 2)
                .filter(x -> x > n)
                .filter(StreamHome::isPrime).max();
    }

    public static boolean isPrime(int x) {
        IntPredicate isDivisible = index -> x % index == 0;
        return x > 1 && IntStream.range(2, x - 1).noneMatch(isDivisible);
    }

    public static boolean isIn(String[] astr, String s) {
        return Stream.of(astr)
                .anyMatch(x -> x.equals(s));
    }
}
