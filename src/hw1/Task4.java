package hw1;

public class Task4 {
    /*

     */
    public static void main(String[] args) {
        // float a = 45.6;                         // необходимо либо указать тип double, либо добавить f в конец
        // long b = 60000;                         // необходимо либо указать тип int, либо добавить L в конец
        // long c = a / b;                         // необходим тип float

        // int x = 34;
        // long y = 78;
        // int z = x / y;                          // необходимо указать тип long

        double n = 90.8;
        double m = -100.1;
        double max = n > m ? n : m;                // тип double
        System.out.println(max);

        // byte code = 1;
        // boolean isActive = (boolean) code;          // byte не переводится в boolean
    }

}
