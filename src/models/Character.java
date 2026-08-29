package models;
public class Character {
    String name;
    int life;
    int attack;
    int defense;
    int critChance;
    String archetype;
    boolean nocauteado;

    public Character(String n, int a){
        switch (a) {
            case 1:
                this.name = n;
                this.life = 100;
                this.attack = (int)(Math.random() * 11) + 20;
                this.defense = (int)(Math.random() * 6) + 10;
                this.critChance = 15;
                this.archetype = "default";
                this.nocauteado = false;
                break;
        
            default:
                this.name = n;
                this.life = 100;
                this.attack = (int)(Math.random() * 11);
                this.defense = 0;
                this.critChance = 1;
                this.archetype = "erro do caraio";
                this.nocauteado = false;
                break;
        }
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\nArchetype: " + this.archetype + "\nLife: " + this.life + "\nAttack: " + this.attack + "\nDefense: " + this.defense + "\nCrit chance: " + this.critChance;
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
        if (crit < this.critChance) {
            dmg = (this.attack * 3) - opponent.defense;
            System.out.println("Crit hit");
        } else{
            dmg = this.attack - opponent.defense;
        }
        if (dmg < 5) {
            dmg = 5;
        }
        opponent.life -= dmg;
        System.out.println(this.name + " attacked " + dmg + " DMG -> " + opponent.stat());
    }

    public String stat(){
        return "Name: " + this.name + " | Life: " + this.life;
    }
}
