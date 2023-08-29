public class Pokemon {
    private String name;
    private String type1;
    private String type2;

    private int maxHp;
    private int currentHp;
    private int atk;
    private int def;
    private int spatk;
    private int spdef;
    private int spd;
    private Move[] moveset = new Move[4];

    public Pokemon(String name, String type1, String type2, int hp, int atk, int def, int spatk, int spdef, int spd) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        maxHp = 2 * hp;
        currentHp = 2 * hp;
        this.atk = atk;
        this.def = def;
        this.spatk = spatk;
        this.spdef = spdef;
        this.spd = spd;
    }

    public String name() {
        return name;
    }

    public String type1() {
        return type1;
    }

    public String type2() {
        return type2;
    }

    public int hp() {
        return maxHp;
    }

    public int atk() {
        return atk;
    }

    public int def() {
        return def;
    }

    public int spatk() {
        return spatk;
    }

    public int spdef() {
        return spdef;
    }

    public int spd() {
        return spd;
    }

    public void reduceHp(int damage) {
        currentHp -= damage;
    }

    public double hpPercent() {
        // 1 decimal place
        return ((double) Math.round(1000 * currentHp / maxHp)) / 10;
    }

    public Move move(int idx) {
        return moveset[idx];
    }

    public void learn(Move move) {
        for (int i = 0; i < moveset.length; i++) {
            if (moveset[i] == null) {
                moveset[i] = move;
                return;
            }
        }
    }
}