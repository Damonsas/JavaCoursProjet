package TpRPGAttribut;

public class Personnage {
    public String name;
    public int hp;
    public int power;


    public Personnage(String name, int hp, int power){
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public  void looseHP(int dmg){
        hp -= dmg;
        if (hp<0) hp = 0;
    }

    public boolean attaque(){
        int x =(int) (Math.random()*100);
        return x%2 == 0;
    }

    public boolean isDead(){return hp <= 0;}

    public static boolean initiative(){
        int x = (int)(Math.random()*101);
        return x%2 ==0;
    }
}

