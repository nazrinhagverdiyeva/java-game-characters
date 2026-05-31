public abstract class GameCharacter {
    private String name;
    private int health;
    private int energy;

    public GameCharacter(String name, int health, int energy){
        this.name = name;
        this.health = health;
        this.energy = energy;
    }

    public int getEnergy(){
        return energy;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }

    abstract void attack(GameCharacter target) throws InsufficientEnergyException, InvalidActionException;
    abstract void defend();
    abstract void useAbility(GameCharacter target) throws InvalidActionException, InsufficientEnergyException;
}
