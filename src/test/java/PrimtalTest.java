import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PrimtalTest {


    Primtal primtal;

    @BeforeEach
    void setUp() {
        primtal = new Primtal();
    }

    //testa om inmatad siffra är null, mindre än 0, mer än 1000 eller bara rätt
    @Test
    @DisplayName("validera input")
    public void testValidateInput() {
        assertAll("Validering av inmatning",
                () -> assertThrows(IllegalArgumentException.class, () -> Primtal.validateInput(-5), "Tal är mindre än noll, inte ok"),
                () -> assertTrue(Primtal.validateInput(0), "Test nedre gränsfall"),
                () -> assertTrue(Primtal.validateInput(500), "Talet är mellan 0 och 1000, helt ok"),
                () -> assertTrue(Primtal.validateInput(1000), "Test övre gränsfall"),
                () -> assertThrows(IllegalArgumentException.class, () -> Primtal.validateInput(1500), "Talet är över 1000, inte ok"),
                () -> assertThrows(IllegalArgumentException.class, () -> Primtal.validateInput(null), "Inmatning saknas")
        );
    }

    //testa om prim-tal är negativt
    @Test
    @DisplayName("Är prim-tal negativt")
    public void testIsPrimeNumberNegative() {
        assertFalse(Primtal.isPrimeNumber(-1));
    }

    //testa om prim-tal är positivt
    @Test
    @DisplayName("Är prim-tal positivt")
    public void testIsPrimeNumberPositive() {
        assertTrue(Primtal.isPrimeNumber(3));
    }

    //kontrollera att siffran är ett primtal
    @Test
    @DisplayName("Är siffran ett prim-tal")
    public void testIsItPrimeNumber() {
        assertTrue(Primtal.isPrimeNumber(3));
    }

    //kontroll av att siffran inte är ett primtal
    @Test
    @DisplayName("Är siffran INTE ett prim-tal")
    public void testIsItNotPrimeNumber() {
        assertFalse(Primtal.isPrimeNumber(4));
    }

    //kontrollera antalet primtal inom intervall 10
    @Test
    @DisplayName("Antal prim-tal i array av 10 nummer")
    public void testNumbersInArray10() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> primeNumbers = Primtal.countPrimesInArray(numbers);
        assertEquals(4, primeNumbers.size());
    }

    //kontrollera antalet primtal inom intervall 20
    @Test
    @DisplayName("Antal prim-tal i array av 20 nummer")
    public void testNumbersInArray20() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayList<Integer> primeNumbers = Primtal.countPrimesInArray(numbers);
        assertEquals(8, primeNumbers.size());
    }

    //lägga ihop siffror i array
    @Test
    @DisplayName("Addera siffror från Array")
    public void testSumArray() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int result = Primtal.addArray(numbers);
        assertEquals(15, result);
    }

    //test för att skapa array mellan ett lågt och ett högt nummer
    @Test
    @DisplayName("test skapa array mellan två nummer")
    public void testCreateArrayValidRange() {

        int low = 1;
        int high = 5;
        Primtal.createNumberArray(low, high);
        int[] expectedArray = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArray, Primtal.numberArray);
    }

    //test för att skapa array mellan med samma nummer
    @Test
    @DisplayName("Test att skapa array med samma nummer")
    public void testCreateArraySameLowAndHigh() {
        int low = 5;
        int high = 5;
        Primtal.createNumberArray(low, high);
        int[] expectedArray = {5};
        assertArrayEquals(expectedArray, Primtal.numberArray);
    }

}
