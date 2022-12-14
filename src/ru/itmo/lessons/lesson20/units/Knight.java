package ru.itmo.lessons.lesson20.units;

import ru.itmo.lessons.lesson20.base.BattleUnit;

public final class Knight extends BattleUnit{
    private int additionalHealth;

    public Knight(int healthScope, int attackScore, int additionalHealth){
        super(healthScope, attackScore);
        if (additionalHealth < 1) throw new IllegalArgumentException("additionalHealth д.б. больше 1");
        this.additionalHealth = additionalHealth;
    }

    @Override
    public void attack(BattleUnit enemy) {
        System.out.println("Knight атакует!");
        enemy.minusHealth(this.attackScore);
        this.plusHealth(5);
        System.out.println("Knight восстанавливает часть здоровья после атаки. Теперь у него " +
                this.getHealthScore() + " здоровья");
    }
}