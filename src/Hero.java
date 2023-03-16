import java.util.Random;

public class Hero {

 String name;
 int hitPoints;

    public Hero(String name) {
        this.name = name;
        hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    private void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }


    public void attack (Hero opponent)
    {
        double x = Math.random();

        if ( x < 0.5)
        {
            opponent.setHitPoints(opponent.getHitPoints() - 10);
        }
        else
        {
            hitPoints = hitPoints - 10;
        }

    }

    public void senzuBean ()
    {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent)
    {
        while (hitPoints > 0 && opponent.getHitPoints() > 0)
        {
            attack(opponent);
        }

    }

    public String fightUntilTheDeath (Hero opponent)
    {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);

        return (name + ": " + hitPoints + "  " +
                opponent.getName() + ": " + opponent.getHitPoints());
    }

    private int[] nFightsToTheDeathHelper (Hero opponent, int n)
    {
        int[] results = new int[n];

        for (int i = 0; i < n; i++)
        {
            fightUntilTheDeath(opponent);
            // if opponent win, 0
            if (opponent.getHitPoints() > hitPoints)
            {
                results[i] = 0;
            }
            // if hero win, 1
            else
            {
                results [i] = 1;
            }
        }

        return results;

    }

    public String nFightsToTheDeath (Hero opponent, int n)
    {
        int [] results = nFightsToTheDeathHelper(opponent,n);
        int hero = 0;
        int opp = 0;

        for (int i : results)
        {
            if (i == 0)
            {
                opp++;
            }
            if (i == 1)
            {
                hero++;
            }
        }

        if (hero > opp)
        {
            return (name + ": " + hero +" wins/n" +
                    opponent.getName() + ": " + opp + " wins/n" +
                    name + " wins!" );
        }
        else if (hero < opp)
        {
            return (name + ": " + hero +" wins/n" +
                    opponent.getName() + ": " + opp + " wins/n" +
                    opponent.getName() + " wins!" );
        }
        else
        {
            return (name + ": " + hero +" wins/n" +
                    opponent.getName() + ": " + opp + " wins/n" +
                   "OMG! It was actually a draw!" );
        }

    }

    public void dramaticFightToTheDeath (Hero opponent)
    {

        senzuBean();
        opponent.senzuBean();

        while (hitPoints > 0 && opponent.getHitPoints() > 0)
        {
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "     " +
                    opponent.getName() + ": " + opponent.getHitPoints());
        }

        if (hitPoints > opponent.getHitPoints())
        {
            System.out.println(name + "wins!");
        }
        else
        {
            System.out.println(opponent.getName() + "wins!");
        }

    }




}
