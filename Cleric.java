public class Cleric extends GameCharacter implements Healable, Upgradeable {

    public Cleric(String name, int health, int energy){
        super(name, health, energy);
    }

    @Override
    void attack(GameCharacter target) throws InsufficientEnergyException {
        if (getEnergy() < 5) {
            throw new InsufficientEnergyException("Not enough energy!");
        }
        target.setHealth(target.getHealth() - 15);
        setEnergy(getEnergy() - 5);
    }

    @Override
    void defend() {
        System.out.println(getName() + " is defending!");
    }

    @Override
    void useAbility(GameCharacter target) throws InvalidActionException, InsufficientEnergyException {
        if (target.getHealth() <= 0) {
            throw new InvalidActionException("Target is already dead!");
        }
        if (getEnergy() < 10) {
            throw new InsufficientEnergyException("Not enough energy!");
        }
        target.setHealth(target.getHealth() - 25);
        setEnergy(getEnergy() - 10);
    }

    @Override
    public void heal(){
        setHealth(getHealth()+20);
    }

    @Override
    public void upgrade(String stat) throws InvalidActionException {
        if (stat.equals("health")){
            setHealth(getHealth()+50);
            System.out.println("Health increased by 50!");
        }

        if(stat.equals("energy")){
            setEnergy(getEnergy()+30);
            System.out.println("Energy increased by 30!");
        }
        else{
            throw new InvalidActionException("Incorrect Action!");
        }
    }
}
