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
        opponent.life -= this.attack - opponent.defense;
    }

    public String stat(){
        return "Name: " + this.name + " | Life: " + this.life;
    }
}
