// PalmerRookery.java
// D. Singletary
// 8/30/2022
// Class which represents a penguin rookery

public class PenguinRookery {

    static final int TOTAL_SPECIES = 3;

    private Penguin penguins[];

    // default constructor
    public PenguinRookery() { }
 
    // overloaded constructor
    public PenguinRookery(Penguin[] penguins) {
        this.penguins = penguins;
    }
    
    // toString
    @Override
    public String toString() {
        String retString = "Our rookery contains the following penguins:\n"; // start here
        
        // append the boxes
        retString += "First penguin is a(n) " + this.penguins[0] + ".\n";
        retString += "Second penguin is a(n) " + this.penguins[1] + ".\n";
        retString += "And the final penguin is a " + 
                        this.penguins[2] + ".\n";
                        
        retString += "There are a total of " + TOTAL_SPECIES + 
                            " penguin species in our rookery."; 
        return retString;
    } 
    
    
    public static void main(String[] args) {
    
        Penguin[] penguins = new Penguin[TOTAL_SPECIES];
        
        // instantiate local Penguin objects
        penguins[0] = new Penguin(PenguinSpecies.CHINSTRAP);
        penguins[1] = new Penguin(PenguinSpecies.GENTOO);
        penguins[2] = new Penguin(PenguinSpecies.ADELIE);
        
        // create our rookery
        PenguinRookery penRook = new PenguinRookery(penguins);
        
        // print the state of the rookery
        System.out.println(penRook);
        
        // make some changes to test the mutator
        System.out.println("Testing mutators and accessors");             
        penRook.penguins[0].setSpecies(PenguinSpecies.ADELIE); 
        penRook.penguins[1].setSpecies(PenguinSpecies.CHINSTRAP);   
        penRook.penguins[2].setSpecies(PenguinSpecies.GENTOO); 
        
        // test the accessor
        System.out.println("first penguin: " + penRook.penguins[0].getSpecies());
        System.out.println("second penguin: " + penRook.penguins[1].getSpecies());
        System.out.println("third penguin: " + penRook.penguins[2].getSpecies());     
    }
}

// enumerated type to represent penguin species
enum PenguinSpecies {
    NO_SPECIES, CHINSTRAP, GENTOO, ADELIE;   
}

// class which represents a penguin
class Penguin {

    // species is the only attribute
    private PenguinSpecies species = PenguinSpecies.NO_SPECIES;
    
    // constructor (overload)
    public Penguin(PenguinSpecies species) {
        this.species = species;
    }
    
    // accessor
    public PenguinSpecies getSpecies() {
        return this.species;
    }
    
    // constructor
    public void setSpecies(PenguinSpecies species) {
        this.species = species;
    }
    
    // toString returns String representation of object.
    // it is inherited from the Object class,
    // we are overriding its default behavior here
    @Override
    public String toString() {
        return species.name();
    }
}
    