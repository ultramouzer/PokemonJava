public class Pokemon {
    private String name;
    private String type1;
    private String type2;

    private int hp;
    private int atk;
    private int def;
    private int spatk;
    private int spdef;
    private int spd;

    public Pokemon(String name, String type1, String type2, int hp, int atk, int def, int spatk, int spdef, int spd) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spatk = spatk;
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
        return hp;
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
}