package org.knit.lab3;

public class WarriorTank extends Warrior implements Tank{
    int additionalDefense;

    public WarriorTank(String name) {
        super(name);
        this.stepX = 2;
        additionalDefense = 5;
    }

    public WarriorTank(String name, int posX, int posY) {
        super(name, posX, posY);
        this.stepX = 2;
        additionalDefense = 5;
    }

    public WarriorTank(String name, int curHP, int posX, int posY) {
        super(name, curHP, posX, posY);
        this.stepX = 2;
        additionalDefense = 5;
    }

    @Override
    public String toString() {
        return "WarriorTank{" +
                "additionalDefense=" + additionalDefense +
                ", damageRange=" + damageRange +
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

    @Override
    public int DecreaseHP(int value) {
        int damageTaken;
        if (curHP + defense + additionalDefense - value > 0) {
            damageTaken = Math.max(value - defense - additionalDefense, 0);
            curHP = curHP - damageTaken;
            System.out.printf("%s потерял %d HP, теперь его здоровье %d.%n", name, damageTaken, curHP);
        }
        else {
            damageTaken = curHP;
            curHP = 0;
            isAlive = false;
            System.out.printf("%s потерял %d HP, теперь он мёртв.%n", name, damageTaken);
        }
        return damageTaken;
    }
}
