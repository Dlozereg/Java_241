package org.knit.lab3;

public abstract class Player {
    // Player должен иметь свойства:
    //
    //Имя
    //Текущее здоровье
    //Максимальное здоровье
    //Статус (жив/мертв)
    //Позиция X
    //Позиция Y
    //урон
    //защита
    //Player должен иметь поведение:
    //
    //увеличить здоровье
    //уменьшить здоровье
    //подвинуться на позицию x и y
    //(обёртка для проверки статуса игрока)

    String name;
    int curHP;
    int maxHP;
    boolean isAlive = true;
    int posX;
    int posY;
    int damage;
    int defense;
    int stepX;
    int stepY;

    int IncreaseHP(int value) {
        int restoredHP;
        if (curHP + value < maxHP) {
            curHP = curHP + value;
            restoredHP = value;
        }
        else {
            restoredHP = maxHP - curHP;
            curHP = maxHP;
        }
        System.out.printf("%s восстановил %d HP, теперь его здоровье %d.%n", name, restoredHP, curHP);
        return restoredHP;
    }

    int DecreaseHP(int value) {
        int damageTaken;
        if (curHP + defense - value > 0) {
            damageTaken = Math.max(value - defense, 0);
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

    public int Attack(Player player){
        int damageDealt;
        if ((Math.abs(posX - player.posX) == 1) && (posY == player.posY) ||
                (posX == player.posX) && (Math.abs(posY - player.posY) == 1)) {
            System.out.printf("%s атакует %s!%n", name, player.name);
            damageDealt = player.DecreaseHP(damage);
        }
        else {
            System.out.println("The target is too far! The distance should be 1 unit.");
            damageDealt = 0;
        }
        return damageDealt;
    }

    int[] ChangePos(int x, int y) {
        int[] steps = {0, 0};
        if ((Math.abs(posX - x) <= stepX)&&(Math.abs(posY - y) <= stepY)) {
            steps[0] = posX - x;
            steps[1] = posY- y;
            posX = x;
            posY = y;
            System.out.printf("%s перемещается на координаты (%d, %d).%n", name, x, y);
        }
        else {
            if (Math.abs(posX - x) > stepX) {
            System.out.println("Invalid destination! You can only go " + stepX + " steps left/right.");
            }
            if (Math.abs(posY - y) > stepY) {
            System.out.println("Invalid destination! You can only go " + stepY + " steps up/down.");
            }
        }
        return steps;
    }
}
