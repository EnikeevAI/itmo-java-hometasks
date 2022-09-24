package hw2;

/*
Дана переменная sum - сумма покупки и переменна saleCode - номер купона.

Если номер купона равен 4525 - вывести сумму с учетом скидки 30%
Если номер купона равен 6424 или 7012 - вывести сумму с учетом скидки 20%
Если номер купона равен 7647 или 9011 или 6612 - вывести сумму с учетом скидки 10%
В остальных случаях скидка не предусмотрена, вывесть полную стоимость покупки.
 */

public class Task2 {

    public static void main(String [] args) {

        double sum = 100.0;
        int saleCode = 1234;
        double result;

        switch (saleCode) {
            case 4524:
                result = sum * 0.7;
                break;
            case 6424:
            case 7012:
                result = sum * 0.8;
                break;
            case 7647:
            case 9011:
            case 6612:
                result = sum * 0.9;
                break;
            default:
                result = sum;
        }

        System.out.println(result);
    }
}
