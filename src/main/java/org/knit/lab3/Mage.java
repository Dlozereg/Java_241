package org.knit.lab3;

import java.sql.SQLOutput;

public class Mage extends Player implements SpellCaster{
    int spellDamage;
    int dangerDistance;

    public Mage(String name) {
        this.name = name;

        this.maxHP = 120;
        this.curHP = maxHP;
        this.posX = 0;
        this.posY = 0;
        this.damage = 10;
        this.defense = 5;
        spellDamage = 35;
        dangerDistance = 2;
        this.stepX = 2;
        this.stepY = 2;
    }

    public Mage(String name, int posX, int posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;

        this.maxHP = 120;
        this.curHP = maxHP;
        this.damage = 10;
        this.defense = 5;
        spellDamage = 35;
        dangerDistance = 2;
        this.stepX = 2;
        this.stepY = 2;
    }

    public Mage(String name, int curHP, int posX, int posY) {
        this.name = name;
        this.curHP = curHP;
        this.posX = posX;
        this.posY = posY;

        this.maxHP = 120;
        this.damage = 10;
        this.defense = 5;
        spellDamage = 35;
        dangerDistance = 2;
        this.stepX = 2;
        this.stepY = 2;
    }

    @Override
    public int CastAttackSpell(Player player) {
        int damageDealt;
        if ((Math.abs(posX - player.posX) > dangerDistance) || (Math.abs(posY - player.posY) > dangerDistance)) {
            System.out.printf("%s атакует магией %s!%n", name, player.name);
            damageDealt = player.DecreaseHP(spellDamage);
        }
        else {
            System.out.printf("The target is too close! it should be outside of %d by %d square around of the caster.%n",
                    dangerDistance, dangerDistance);
            damageDealt = 0;
        }
        return damageDealt;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "spellDamage=" + spellDamage +
                ", dangerDistance=" + dangerDistance +
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
