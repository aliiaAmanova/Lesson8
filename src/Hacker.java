
public class Hacker extends Hero{
    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperAbility.TRANSFER_HEALTH, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int hacker = RPG_Game.random.nextInt(150);
        int num = RPG_Game.random.nextInt(heroes.length);
        boss.setHealth(boss.getHealth()-hacker);
        heroes[num].setHealth(heroes[num].getHealth()+hacker);
        System.out.println(this.getName()+"  stole  "+ hacker + "  health points from boss and gave it to " + heroes[num].getName());

    }
}