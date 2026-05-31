public class Mage extends GameCharacter{
    private boolean hasBarrier = false;

    public Mage(String name, int health, int energy){
        super(name, health, energy);
    }

    @Override
    void attack(GameCharacter target) throws InsufficientEnergyException {
        if (getEnergy()<8){
            throw new InsufficientEnergyException("Not enough energy!");
        }

        target.setHealth(target.getHealth()-15);
        setEnergy(getEnergy()-8);
    }

    @Override
    void defend(){
        hasBarrier = true;
        System.out.println(getName() + " Magic barrier created!");
    }

    @Override
    void useAbility(GameCharacter target) throws InvalidActionException, InsufficientEnergyException {
        if (target.getHealth() <= 0){
            throw new InvalidActionException("Character is already dead!");
        }
        if(getEnergy() < 15){
            throw new InsufficientEnergyException("Not enough energy!");
        }

        target.setHealth(target.getHealth()-35);
        setEnergy(getEnergy()-15);
    }
}
