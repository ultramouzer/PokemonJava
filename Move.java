public class Move {
    private String name;
    private String type;
    private int bp;
    private boolean special;

    public Move(String name, String type, int bp, boolean special){
        this.name = name;
        this.type = type;
        this.bp = bp;
        this.special = special;
    }

    public String name(){
        return name;
    }
    public String type(){
        return type;
    }
    public int bp(){
        return bp;
    }
    public boolean special(){
        return special;
    }
}
