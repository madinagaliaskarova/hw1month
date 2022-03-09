package com.company;

public class Main {
    public static String bossDefenceType;
    public static int bossHealth = 700; //здоровье босса
    public static int bossDamage = 50; //сила удара босса
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic"}; //типы аттак
    public static int[] heroesDamage = {25, 20, 15}; // сила удара
    public static int[] heroesHealth = {280, 270, 260}; //здоровье героев
    public static int roundNumber = 0;


    public static void main(String[] args) {
        printStatistics(); // запускаем метод print statistics
        while (!isGameFinished()){
            round();
        };

    }
    public static void round(){
        roundNumber++;
        bossHits();
        heroesHit();
        printStatistics();
    }

    public static void bossHits(){
        for (int i = 0; i < heroesHealth.length; i++) {
            heroesHealth[i] = heroesHealth[i] - bossDamage;
        }
    }
    public static void heroesHit(){
        for (int i = 0; i < heroesDamage.length; i++) {
            bossHealth = bossHealth - heroesDamage[i];
        }
    }

    public static boolean isGameFinished(){ // если здоровье босса равно или меньше 0 то побеждают герои, если здоровье героев равно или меньше 0 то побеждают
        //  герои, если у обоих больше нуля то возвращает false
        if(bossHealth <=0) {
            System.out.println("Heroes won!!!");
            return true; //если здоровье босса <=0, то тогда распечатываем  "Heroes won" и даем задание что игра закончена с помощью boolean и возвращаем true
        }
       if(heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
           System.out.println ("Boss won!!!");
           return true;
       }
       return false; //если здоровье всех героев равно или меньше нуля то тогда победил Босс (if return + здоровье героев оператор и) возвращаем правда
    }

    public static void printStatistics(){
        System.out.println(roundNumber + "ROUND__________________");
        System.out.println("Boss health: " + bossHealth + " (" + bossDamage + ")"); // распечатываем слово "Boss health: " + значение переменной bossHealth +
        // в скобках сила удара босса

        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i] + " (" + heroesDamage[i] + ")" ); // здесь мы распечатываем здоровье героев и типы аттак
            //цикл i=0; i < длина heroesHealth; i++ сложение, распечатать heroes attacktype + "health": + массив heroesHealth;
            //+массив heroesDamege чтоб в скобках выходило три значения силы удара
        }




    }
}

