package ru.itmo.lessons.lesson20;

import ru.itmo.lessons.lesson20.base.BattleUnit;
import ru.itmo.lessons.lesson20.units.Infantry;
import ru.itmo.lessons.lesson20.units.King;
import ru.itmo.lessons.lesson20.units.Knight;

public class Application {

    public void finalArgs(final int a, final Infantry infantry){
        System.out.println(a);
        int b = a * a;

        System.out.println(infantry.getHealthScore());
        infantry.plusHealth(10);
    }

    public static void main(String[] args) {
        // 1. final class - запрет наследования
        // 2. final метод - запрет переопределения
        // 3. final свойства - запрет изменения значений,
        // значение final свойству нужно присвоить либо при объявлении либо в конструкторе (сеттеры запрещены)
        // 4. final аргумент метода - доступен только для чтения.
        // Примитивы нельзя изменить. Ссылочным типам нельзя присвоить новую ссылку, но можно изменять свойства

        King king01 = new King(1000);
        king01.rest();
        System.out.println("+++++++++++++++++++++");
        King king02 = new King(2000);
        king02.rest(king01);

        System.out.println(king01.getHealthScore());

        Infantry infantry01 = new Infantry(30, 10, 5);
        infantry01.upAdditionalAttack();
        infantry01.rest();
        System.out.println(infantry01.getAttackScore());
        System.out.println(infantry01.getHealthScore());

        Knight knight01 = new Knight(30, 10, 5);

        BattleUnit battleUnit01 = new Infantry(30, 10, 5);
        BattleUnit battleUnit02 = new Knight(30, 10, 25);

        // полиморфизм наследования
        BattleUnit[] battleUnits = {infantry01, battleUnit01, battleUnit02};
        for (BattleUnit battleUnit: battleUnits) {
            battleUnit.rest();
            battleUnit.attack(knight01);
        }

        king01.generateArmy();
        king02.generateArmy();
        king01.startBattle(king02);
    }
}
