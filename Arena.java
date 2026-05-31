import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.io.*;

public class Arena {
    public static void main(String[] args){
        Player p1 = new Player(1, "Thor", new Warrior("Thor", 100,50));
        Player p2 = new Player(2, "Merlin", new Mage("Merlin", 80,60));
        Player p3 = new Player(3, "Arthur", new Cleric("Arthur", 120,40));
        Player p4 = new Player(4, "Ragnar", new Warrior("Ragnar", 100,50));

        HashSet<Player> players = new HashSet<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);

        HashMap<Integer, GameCharacter> characterMap = new HashMap<>();
        characterMap.put(1, p1.getCharacter());
        characterMap.put(2, p2.getCharacter());
        characterMap.put(3, p3.getCharacter());
        characterMap.put(4, p4.getCharacter());

        ArrayList<String> history = new ArrayList<>();

        try (FileWriter log = new FileWriter("game.log", true)){
            (p1.getCharacter()).attack(p2.getCharacter());
            history.add("Thor attacked Merlin");
            log.write("Thor attacked Merlin\n");

            (p2.getCharacter()).useAbility(p1.getCharacter());
            history.add("Merlin used Fireball on Thor");
            log.write("Merlin used Fireball on Thor\n");

            ((Healable) p3.getCharacter()).heal();
            history.add("Arthur healed himself");
            log.write("Arthur healed himself");

            ((Upgradeable) p3.getCharacter()).upgrade("strength");
            history.add("Arthur upgraded strength");

            try  {
                p2.getCharacter().setHealth(0);
                p1.getCharacter().attack(p2.getCharacter());
            }catch(InvalidActionException | InsufficientEnergyException e){
                System.out.println("Error: " + e.getMessage());
            }

            try {
                p1.getCharacter().setEnergy(0);
                p1.getCharacter().useAbility(p3.getCharacter());
            } catch (InvalidActionException | InsufficientEnergyException e) {
                System.out.println("Action error: " + e.getMessage());
                log.write("Error: " + e.getMessage() + "\n");
            }

        }
        catch(InvalidActionException | InsufficientEnergyException e){
            System.out.println("Action error: " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("Log error: " + e.getMessage());
        }
        finally{
            System.out.println("Game state saved - character health/energy logged");
        }

        System.out.println("\n--- ACTION HISTORY ---");
        System.out.println("Total actions: " + history.size());
        System.out.println("Last 3 actions:");
        System.out.println(history.get(history.size() - 3));
        System.out.println(history.get(history.size() - 2));
        System.out.println(history.get(history.size() - 1));

        System.out.println("\n--- PLAYERS ---");
        for (Player p : players) {
            System.out.println(p.getNickname());
        }

        System.out.println("\n--- CHARACTER STATS ---");
        for (Player p : players) {
            System.out.println(p.getNickname() + " → Health: " + p.getCharacter().getHealth() + ", Energy: " + p.getCharacter().getEnergy());
        }

    }
}
