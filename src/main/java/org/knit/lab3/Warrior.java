package org.knit.lab3;

public class Warrior extends Player implements Melee{
    int damageRange;

    public Warrior(String name) {
        this.name = name;

        this.maxHP = 150;
        this.curHP = maxHP;
        this.posX = 0;
        this.posY = 0;
        this.damage = 40;
        this.defense = 10;
        damageRange = 2;
        this.stepX = 3;
        this.stepY = 3;
    }

    public Warrior(String name, int posX, int posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;

        this.maxHP = 150;
        this.curHP = maxHP;
        this.damage = 40;
        this.defense = 10;
        damageRange = 2;
        this.stepX = 3;
        this.stepY = 3;
    }

    public Warrior(String name, int curHP, int posX, int posY) {
        this.name = name;
        this.curHP = curHP;
        this.posX = posX;
        this.posY = posY;

        this.maxHP = 150;
        this.damage = 40;
        this.defense = 10;
        damageRange = 2;
        this.stepX = 3;
        this.stepY = 3;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", curHP=" + curHP +
                ", maxHP=" + maxHP +
                ", isAlive=" + isAlive +
                ", posX=" + posX +
                ", posY=" + posY +
                ", damage=" + damage +
                ", defense=" + defense +
                ", stepX=" + stepX +
                ", stepY=" + stepY +
                ", damageRange=" + damageRange +
                '}';
    }

    @Override
    public int Attack(Player player) {
        int damageDealt;
        if ((Math.abs(posX - player.posX) <= damageRange) || (Math.abs(posY - player.posY) <= damageRange)) {
            System.out.printf("%s атакует %s!%n", name, player.name);
            damageDealt = player.DecreaseHP(damage);
        }
        else {
            System.out.printf("The target is too far! it should be inside of %d by %d square around of the attacker.%n",
                    damageRange, damageRange);
            damageDealt = 0;
        }
        return damageDealt;
    }
}
