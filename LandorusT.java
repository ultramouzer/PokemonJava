public class LandorusT extends Pokemon {
    // use this to get a sense of how to create a new pokemon
    // notice the array of Moves. look at Move.java for more info on how moves work
    private Move[] learnset = new Move[] {
            new Move("earthquake", "ground", 100, false),
            new Move("u-turn", "bug", 70, false),
            new Move("knock off", "dark", 65, false),
            new Move("hp ice", "ice", 60, true),
            new Move("stone edge", "rock", 100, false),
    };

    public LandorusT(String name) {
        super(name, "ground", "flying", 89, 145, 90, 105, 80, 91);
        learn(learnset[0]);
        learn(learnset[1]);
        learn(learnset[2]);
        learn(learnset[3]);
    }
}
