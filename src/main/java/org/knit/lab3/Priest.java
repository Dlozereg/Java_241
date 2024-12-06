package org.knit.lab3;

public class Priest extends Player implements Healer{
    int healPower;

    public Priest(String name) {
        this.name = name;

        this.maxHP = 100;
        this.curHP = maxHP;
        this.posX = 0;
        this.posY = 0;
        this.damage = 10;
        this.defense = 3;
        healPower = 15;
        this.stepX = 3;
        this.stepY = 2;
    }

    public Priest(String name, int posX, int posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;

        this.maxHP = 100;
        this.curHP = maxHP;
        this.damage = 10;
        this.defense = 3;
        healPower = 15;
        this.stepX = 3;
        this.stepY = 2;
    }

    public Priest(String name, int curHP, int posX, int posY) {
        this.name = name;
        this.curHP = curHP;
        this.posX = posX;
        this.posY = posY;

        this.maxHP = 100;
        this.damage = 10;
        this.defense = 3;
        healPower = 15;
        this.stepX = 3;
        this.stepY = 2;
    }

    @Override
    public int Heal(Player player) {
        System.out.printf("%s лечит %s.%n", name, player.name);
        int healedHP = player.IncreaseHP(healPower);
        return healedHP;
    }

    @Override
    public String toString() {
        return "Priest{" +
                "healPower=" + healPower +
                ", name='" + name + '\'' +
                ", curHP=" + curHP +
                ", maxHP=" + maxHP +
                ", isAlive=" + isAlive +
                ", posX=" + posX +
                ", posY=" + posY +
                ", damage=" + damage +
                ", defense=" + defense +
                ", stepX=" + stepX +
                ", stepY=" + stepY +
                '}';
    }
}
