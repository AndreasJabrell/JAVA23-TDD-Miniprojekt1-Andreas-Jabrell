import java.util.ArrayList;
import java.util.Scanner;

public class Primtal {
    public static int lengthArray = 0;
    public static int[] numberArray = new int[lengthArray];
    public static int sum = 0;
    public static ArrayList<Integer> primeArray = new ArrayList<>();


    // metod för att kolla om siffra är prim-tal
    //DENNA hamnar mitt i en loop som kontrollerar siffrorna i en array
    static boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0)
                return false;
        }
        return true;
    }

    public static int addArray(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // kontrollera input
    public static boolean validateInput(Integer input) throws IllegalArgumentException {
        if (input == null || input < 0 || input > 1000) {
            throw new IllegalArgumentException("Input måste vara mellan 0 och 1000.");
        } else{
            return true;
        }
    }


    //MÅSTE TA EMOT EN ARRAY
    // räknar prim-tal inom specifik längd av siffror
    public static ArrayList<Integer> countPrimesInArray(int[] numbers) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        // Kontrollera alla tal i array för att se om de är primtal
        for (int num : numbers) {
            if (isPrimeNumber(num)) {
                primeNumbers.add(num); // Lägg till primtalet i listan
            }
        }

        // Summera primtalen
        sum = addArray(primeNumbers);
        primeArray = primeNumbers;
        System.out.println("Summa av primtal: " + sum);
        return primeNumbers;  // Returnerar listan med primtal
    }


    // Skapar en array med nummer från low till high
    public static void createNumberArray(int low, int high) {
        int[] myArray = new int[high - low + 1];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = low + i;
        }
        numberArray = myArray;
    }

    public static void main(String[] args) {
        // Sätter startmeddelande
        String welcome = "Hej, mata in två siffror mellan 0-1000 för att se hur många primtal det finns mellan dessa siffror + få ut summan av dem";
        System.out.println(welcome);
        boolean validInput = false;  // Flagga för att kontrollera giltig inmatning
        int lowNumber = 0;
        int highNumber = 0;
        // Öppna scanner för input
        Scanner sc = new Scanner(System.in);
        while (!validInput) {
            try {
                System.out.println("Enter low number: ");
                lowNumber = sc.nextInt();
                validateInput(lowNumber);

                System.out.println("Enter high number: ");
                highNumber = sc.nextInt();
                validateInput(highNumber);

                validInput = true;

            } catch (IllegalArgumentException e) {
                // Fångar felmeddelandet och skriver ut det
                System.out.println("Error: " + e.getMessage());
                System.out.println("Var god och mata in korrekta siffror mellan 0 och 1000.");
                sc.nextLine(); // Rensar scanners buffert ifall användaren matar in fel typ av data
            }
        }

        // Skapa array och skriv ut resultatet efter giltig inmatning
        createNumberArray(lowNumber, highNumber);
        countPrimesInArray(numberArray);
        System.out.println("Här är prim-tals listan" + primeArray);
        System.out.println("Här antal tal i prim-tals listan: " + primeArray.toArray().length);

    }
}
