import java.util.ArrayList;
import java.util.Scanner;

import models.Character;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int KO = 0;
        int playerCount = 0;
        ArrayList<Character> players = new ArrayList<Character>();
        while (true) {
            System.out.println("Digite o nome do personagem");
            String nome = scan.next();
            System.out.println("Digite o número do arquétipo");
            int arc;
            while (true) {
                try {
                    arc = scan.nextInt();
                } catch (Exception e) {
                    System.err.println("insira um NÚMERO valido");
                    scan.next();
                    continue;
                }
                break;   
            }
            Character player = new Character(nome,arc);
            System.out.println(player + "\n////////////////////");
            players.add(player);
            System.out.println("adicionar outro personagem? (y/n)");
            if (scan.next().equals("y")) {
                continue;
            }
            break;
        }
        playerCount = players.size();
        while (true) {
            for (int j = 0; j < players.size();j++) {
                System.out.println("Nº " + j + " " + players.get(j).stat());
            }
            for(int j = 0; j < players.size();j++){
                if (players.get(j).getNocauteado() == true) {
                    continue;
                }
                System.out.println(players.get(j).getName() + " Coloque o numero de quem deseja atacar:");
                int target = -1;
                while (true) {
                    try {
                        target = scan.nextInt();
                    } catch (Exception e) {
                        System.err.println("insira um NÚMERO valido");
                        scan.next();
                        continue;
                    }
                    if (target == j) {
                        System.err.println("bro...");
                        continue;
                    }
                    if (target > players.size() - 1 || target < 0) {
                        System.err.println("insira um número valido");
                        continue;
                    }
                    break;
                }
                players.get(j).attack(players.get(target));
            }
            for (int j = players.size() - 1; j >= 0;j--) {
                if (players.get(j).getLife() <= 0 && players.get(j).getNocauteado() == false) {
                    players.get(j).setNocauteado();
                    KO++;
                }
            }
            if (KO >= playerCount - 1) {
                if (KO == playerCount) {
                    System.out.println("todo mundo morreu, acabo.");
                    break;
                }
                for (Character character : players) {
                    if (character.getNocauteado()) {
                        continue;
                    } else {
                        System.out.println(character.getName() + " Venceu com " + character.getLife() + " de vida");
                    }
                }
                break;
            }
        }
        
    }
}
