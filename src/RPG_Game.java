import java.util.Random;


public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(2500, 50, "Kraken");

        Warrior warrior1 = new Warrior(270, 10, "Thor");
        Warrior warrior2 = new Warrior(280, 15, "Hercules");
        Magic magic = new Magic(290, 10, "Wizard");
        Berserk berserk = new Berserk(260, 10, "Gats");
        Medic doc = new Medic(250, 5, 15, "Doctor");
        Medic assistant = new Medic(290, 5, 5, "Avicenna");
        Witcher witcher = new Witcher(200,0,"Vedmak");
        Hacker hacker = new Hacker(155,16,"Shadow");

        Hero[] heroes = {warrior1, warrior2, doc, magic, berserk, assistant,witcher,hacker};
        showStatistics(boss, heroes);

        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0
                    && boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " --------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }
}
