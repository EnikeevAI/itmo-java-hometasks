package ru.itmo.lessons.lesson11;
import ru.itmo.lessons.lesson11.enums.Planet;
public class Application {
    public static void main(String[] args) {
        Planet[] planets = Planet.values();
        for (Planet planet: planets) {
            System.out.printf("Планета: %s, радиус: %d километров, вес: %e килограмм\n", planet.getName(), planet.getRadius(),planet.getWeight());
        }


    }
}
