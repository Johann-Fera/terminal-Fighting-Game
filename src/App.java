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
            Character player = new Character(nome);
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
                // colocar textos para impedir ataquer estranhos/invalidos
                System.out.println(players.get(j).getName() + " Coloque o numero de quem deseja atacar");
                int target = scan.nextInt();
                players.get(j).attack(players.get(target));
                System.out.println(players.get(j).getName() + " attacked -> " + players.get(target).stat());
            }
            for (int j = players.size() - 1; j >= 0;j--) {
                if (players.get(j).getLife() <= 0) {
                    players.get(j).setNocauteado();
                    KO++;
                }
            }
            if (KO >= playerCount - 1) {
                //NÃO coloque sistema que mostre o vencedor isso spoila o final
                break;
            }
        }
        
    }
}
