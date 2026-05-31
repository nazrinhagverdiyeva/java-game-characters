public class Warrior extends GameCharacter{
    private boolean isDefending = false;

    public Warrior(String name, int health, int energy){
        super(name, health, energy);
    }

    @Override
    public void attack(GameCharacter target) throws InsufficientEnergyException, InvalidActionException {
        if (target.getHealth() <= 0) {
            throw new InvalidActionException("Target is already dead!");
        }
        if (getEnergy() < 5){
            throw new InsufficientEnergyException("Not enough energy!");
        }

        target.setHealth(target.getHealth() - 20);
        setEnergy(getEnergy()-5);
    }

    @Override
    public void defend(){
        isDefending = true;
        System.out.println(getName() + " is defending - next attack" +
                "damage reduced by 50%.");
    }

    @Override
    public void useAbility(GameCharacter target) throws InvalidActionException, InsufficientEnergyException {
        if (target.getHealth() <= 0){
            throw new InvalidActionException("Character is already dead!");
        }
        if (getEnergy() < 10) {
            throw new InsufficientEnergyException("Not enough energy for Shield Slam!");
        }

        target.setHealth(target.getHealth() - 30);
        setEnergy(getEnergy()-10);
    }
}
