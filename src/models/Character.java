package models;
public class Character {
    String name;
    int life;
    int attack;
    int defense;
    boolean nocauteado;

    public Character(String n){
        this.name = n;
        this.life = 100;
        this.attack = (int)(Math.random() * 11) + 20;
        this.defense = (int)(Math.random() * 6) + 10;
        this.nocauteado = false;
        System.out.println(this + "\n////////////////////");
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\nLife: " + this.life + "\nAttack: " + this.attack + "\nDefense: " + this.defense;
    }
    public String getName(){
        return this.name;
    }
    public int getLife(){
        return this.life;
    }

    public boolean getNocauteado(){
        return this.nocauteado;
    }

    public void setNocauteado(){
        this.nocauteado = true;
    }
    
    public void attack(Character opponent){
        int crit = (int)(Math.random() * 101);
        int dmg;
        if (crit < 15) {
            dmg = (this.attack * 3) - opponent.defense;
            System.out.println("Crit hit");
        } else{
            dmg = this.attack - opponent.defense;
        }
        if (dmg < 5) {
            dmg = 5;
        }
        opponent.life -= dmg;
    }

    public String stat(){
        return "Name: " + this.name + " | Life: " + this.life;
    }
}
