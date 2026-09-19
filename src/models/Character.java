package models;

import java.util.ArrayList;

public class Character {
    String name;
    int life;
    int attack;
    int defense;
    int critChance;
    String archetype;
    String desc;
    int arcNum;
    boolean nocauteado;
    ArrayList<Character> tagged;
    boolean bot;

    public Character(String n, int a, boolean b){
        this.name = n;
        this.life = 100;
        this.nocauteado = false;
        this.bot = b;
        if (a == 0) {
            a = (int)(Math.random() * 5) + 1;
        }
        switch (a) {
            case 1:
                this.attack = (int)(Math.random() * 6) + 10;
                this.defense = (int)(Math.random() * 11) + 20;
                this.critChance = 5;
                this.archetype = "fat";
                this.desc = "lutador bem resistente";
                this.arcNum = 1;
                break;

            case 2:
                this.attack = (int)(Math.random() * 11) + 20;
                this.defense = (int)(Math.random() * 6) + 10;
                this.critChance = 10;
                this.archetype = "default";
                this.desc = "lutador basico";
                this.arcNum = 2;
                break;

            case 3:
                this.attack = (int)(Math.random() * 11) + 15;
                this.defense = (int)(Math.random() * 16) + 10;
                this.critChance = 10;
                this.archetype = "freak";
                this.desc = "seu ataque dobra durante um x1";
                this.arcNum = 3;
                break;

            case 4:
                this.attack = (int)(Math.random() * 6) + 10;
                this.defense = (int)(Math.random() * 6) + 5;
                this.critChance = 5;
                this.archetype = "vampire";
                this.desc = "lifesteal duh";
                this.arcNum = 4;
                break;

            case 5:
                this.attack = (int)(Math.random() * 11) + 5;
                this.defense = (int)(Math.random() * 6) + 5;
                this.critChance = 5;
                this.archetype = "tagger";
                this.desc = "ataque todos e eles tomaram um ataque baseado na quantidade de lutadores";
                this.arcNum = 5;
                this.tagged = new ArrayList<Character>();
                break;
        
            default:
                this.attack = (int)(Math.random() * 11) + 1;
                this.defense = 0;
                this.critChance = 1;
                this.archetype = "bizonho";
                this.desc = "erro um número ae, tonto";
                this.arcNum = -1;
                break;
        }
        String[] g_names = {"gambler", "gambling", "hakari"};
        n.toLowerCase();
        for (String gn : g_names) {
            if (n.contains(gn)) {
                this.attack = (int)(Math.random() * 701) - 600;
                this.defense = (int)(Math.random() * 126) - 75;
                this.critChance = 1;
                this.archetype = "True gambler";
                this.desc = "the true way of life";
                this.arcNum = 777;
            }   
        }
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\nArchetype: " + this.archetype + "\nDescription: " + this.desc + "\nLife: " + this.life + "\nAttack: " + this.attack + "\nDefense: " + this.defense + "\nCrit chance: " + this.critChance;
    }
    public String getName(){
        return this.name;
    }
    public int getLife(){
        return this.life;
    }

    public int getArcnum(){
        return this.arcNum;
    }

    public boolean getNocauteado(){
        return this.nocauteado;
    }

    public boolean getBot(){
        return this.bot;
    }

    public void setNocauteado(){
        this.nocauteado = true;
    }
    public void attack(Character opponent,int playerCount, int KO){
        int crit = (int)(Math.random() * 101);
        int dmg = this.attack;
        int trueDmg;
        boolean kaboom = false;
        if (this.arcNum == 3) {
            int remaining = playerCount - KO;
            if (remaining <= 2) {
            dmg = this.attack * 2;
            }
        } else if (this.arcNum == 5) {
            if (tagged.contains(opponent) == false) {
                tagged.add(opponent);
            }
            if (tagged.size() == playerCount - 1) {
                dmg = this.attack * (playerCount - 1);
                kaboom = true;
            }
        }
        if (crit < this.critChance) {
            if (dmg < 0) {
                dmg = 15;
            } else {
                dmg = dmg * 3;
            }
            System.out.println("Crit hit");
        }
        if (kaboom) {
            System.out.println("kaboom");
            for (Character character : tagged) {
                trueDmg = dmg - character.defense;
                if (trueDmg < 10) {
                    trueDmg = 10;
                }
                character.life -= trueDmg;
                System.out.println(this.name + " attacked " + trueDmg + " DMG -> " + character.stat());
            }
            tagged.clear();
            kaboom = false;
        } else {
            trueDmg = dmg - opponent.defense;
            if (trueDmg < 10) {
                trueDmg = 10;
            }
            if (this.arcNum == 4) {
                if (opponent.life > 0) {
                    this.life += trueDmg;
                }
            }
            opponent.life -= trueDmg;
            System.out.println(this.name + " attacked " + trueDmg + " DMG -> " + opponent.stat());
        }
    }

    public String stat(){
        return "Name: " + this.name + " | Life: " + this.life;
    }
}
