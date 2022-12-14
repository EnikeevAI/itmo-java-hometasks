package hw2;

/*
Даны переменные age - возраст и exp - опыт работы.
Если значение переменной age больше 100, вывести в консоль "Мы Вам перезвоним".
В противном случае перейти к проверке exp. Если значение exp меньше 5,
вывести в консоль "Вы подходите на должность стажера".
Если значение exp больше или равно 5, вывести в консоль "Вы подходите на должность разработчика".
 */

public class Task5 {

    public static void main(String [] args) {
        int age = 100;
        int exp = 5;
        String text = "Проверьте правильность ввода значений age или exp. Значения не должны быть отрицательными.";

        if(age > 100) {
            text = "Мы Вам перезвоним";
        } else if (age > 0){
            if(exp >= 0 && exp < 5) {
                text = "Вы подходите на должность стажера";
            } else if (exp >= 5){
                text = "Вы подходите на должность разработчика";
            }
        }

        System.out.println(text);
    }
}
