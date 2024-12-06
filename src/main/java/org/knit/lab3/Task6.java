package org.knit.lab3;

public class Task6 {

    public static void execute() {
        Priest priest = new Priest("Garion", 2, 3);
        Mage mage = new Mage("Merlin");
        Warrior warrior = new Warrior("Roland", 3, 3);
        WarriorTank tank = new WarriorTank("Daniel", 1, 1);
        System.out.println();

        mage.CastAttackSpell(warrior);
        warrior.Attack(mage);
        priest.Heal(warrior);
        tank.ChangePos(2, 2);
        System.out.println();

        mage.CastAttackSpell(warrior);
        warrior.ChangePos(0, 1);
        priest.ChangePos(5, 6);
        tank.Attack(priest);
        System.out.println();

        mage.CastAttackSpell(warrior);
        warrior.Attack(mage);
        priest.Attack(tank);
        tank.Attack(priest);
        System.out.println();

        mage.ChangePos(2, 0);
        warrior.Attack(mage);
        priest.ChangePos(5, 3);
        tank.Attack(priest);
        System.out.println();

        mage.ChangePos(4, 1);
        warrior.Attack(tank);
        tank.Attack(warrior);
        System.out.println();

        mage.CastAttackSpell(warrior);
        warrior.Attack(tank);
        tank.Attack(warrior);
        System.out.println();

        mage.CastAttackSpell(warrior);
        warrior.ChangePos(3, 1);
        tank.Attack(warrior);
        System.out.println();

        tank.Attack(tank);
        System.out.println();

        System.out.println(mage);
        System.out.println(warrior);
        System.out.println(priest);
        System.out.println(tank);
    }
}
