package hw2;

// Дан номер месяца, например int month = 5. В зависимости от данного значения вывести в консоль время года
public class Task1 {

    public static void main(String[] args) {

        int month = 11;

        if (month == 12 || month < 3) {
            System.out.println("It's winter!");
        } else if (month < 6) {
            System.out.println("It's spring!");
        } else if (month < 9) {
            System.out.println("It's summer!");
        } else if (month < 12) {
            System.out.println("It's autumn!");
        } else {
            System.out.println("Wrong number of month");
        }
    }
}
