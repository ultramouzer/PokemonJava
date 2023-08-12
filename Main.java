import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        //display enemy
        //display player
        //ask player for move
        //say effectiveness
        //loop until hp hits 0

        //damage:
        // (42 x bp x A/D + 2)/50 x STAB x type effectveness
        Scanner scan = new Scanner(System.in);
        Pokemon p1 = new LandorusT("Landoge1");
        Pokemon p2 = new LandorusT("Landoge2");

        while( p1.hpPercent() != 0 && p2.hpPercent() != 0){
            Pokemon firstmon;
            Pokemon secondmon;
            if(p1.spd() > p2.spd()){
                firstmon = p1;
                secondmon = p2;
            }
            else if(p1.spd() < p2.spd()){
                firstmon = p2;
                secondmon = p1;
            }
            else{
                int rand = (int)(Math.random()*2);
                firstmon = p1;
                secondmon = p2;
                if(rand == 1){
                    firstmon = p2;
                    secondmon = p1;
                }
            }

            System.out.println(secondmon.name() + ": " + secondmon.hpPercent());
            System.out.println(firstmon.name() + ": " + firstmon.hpPercent());
            System.out.println(firstmon.name() + "'s moves:");
            System.out.println("1: " + firstmon.move(0).name() + " 2: " + firstmon.move(1).name());
            System.out.println("3: " + firstmon.move(2).name() + " 4: " + firstmon.move(3).name());
            System.out.println("which move?");
            int idx = scan.nextInt() - 1;
            scan.nextLine();
            Move move = firstmon.move(idx);
            System.out.println(firstmon.name() + " used " + move.name());
            
            int dmg = calcDmg(firstmon, secondmon, move);
            secondmon.reduceHp(dmg);

            System.out.println(secondmon.name() + ": " + secondmon.hpPercent());
            System.out.println(secondmon.name() + ": " + firstmon.hpPercent());
            System.out.println(secondmon.name() + "'s moves:");
            System.out.println("1: " + secondmon.move(0).name() + " 2: " + secondmon.move(1).name());
            System.out.println("3: " + secondmon.move(2).name() + " 4: " + secondmon.move(3).name());
            System.out.println("which move?");
            idx = scan.nextInt() - 1;
            scan.nextLine();
            move = secondmon.move(idx);
            System.out.println(secondmon.name() + " used " + move.name());
            
            dmg = calcDmg(secondmon, firstmon, move);
            firstmon.reduceHp(dmg);
        }

        scan.close();
    }

    public static int calcDmg(Pokemon attacker, Pokemon defender, Move move){
        int atk = attacker.atk();
        int def = defender.def();
        if(move.special()){
            atk = attacker.spatk();
            def = defender.spdef();
        }

        double stab = 1.0;
        if(attacker.type1().equals(move.type()) || attacker.type2().equals(move.type())){
            stab = 1.5;
        }
        
        // (2*level)/4 + 2;
        double dmg = ((22.0* move.bp() * atk/def + 2.0) / 50.0);
        dmg *= stab;
        double eff = effectiveness(move.type(), defender.type1()) * effectiveness(move.type(), defender.type2());
        dmg *= eff;
        if(eff >= 2){
            System.out.println("it's super effective");
        }
        else if(eff == 0){
            System.out.println("it had no effect");
        }
        else if(eff > 1){
            System.out.println("it's not very effective");
        }
        return (int)dmg;
    }

    public static double effectiveness(String attacktype, String defendtype){
        if(attacktype.equals("ground")){
            if(defendtype.equals("fire")||defendtype.equals("steel")||
            defendtype.equals("rock")||defendtype.equals("poison")||
            defendtype.equals("electric")){
                return 2.0;
            }
            else if(defendtype.equals("grass")||defendtype.equals("bug")){
                return 0.5;
            }
            else if(defendtype.equals("flying")){
                return 0.0;
            }
            else{
                return 1.0;
            }
        }

        if(attacktype.equals("ice")){
            if(defendtype.equals("flying")||defendtype.equals("ground")||
            defendtype.equals("grass")||defendtype.equals("dragon")){
                return 2.0;
            }
            else if(defendtype.equals("water")||defendtype.equals("fire")||
            defendtype.equals("steel")||defendtype.equals("ice")){
                return 0.5;
            }
        }
        return 1.0;
    }
}