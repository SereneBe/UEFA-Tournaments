/**
 * This class describes one of UEFA's tournaments and will inherit from the Tournament class.
 * @author Serene Belhadj
 * @version 1.1
 */
public class SummerShowdown extends Tournament {
    private String backupReferee;
/**
 * This constructor takes in 5 parameters.
 * @param numTeams inherited from Tournament
 * @param knockout inherited from Tournament
 * @param finalReferee inherited from Tournament
 * @param maxCapacity inherited from Tournament
 * @param backupReferee just a backup referee because every referee can only referee 1 tournament's final
 */
    public SummerShowdown(int numTeams, boolean knockout, String finalReferee, int maxCapacity, String backupReferee) {
        super("Summer Showdown", numTeams, knockout, finalReferee, maxCapacity);
        this.backupReferee = backupReferee;
    }
/**
 * This constructor takes in 2 parameters.
 * @param finalReferee a variable inherited from Tournament
 * @param backupReferee a backup referee in case something happens to one of the referees
 */
    public SummerShowdown(String finalReferee, String backupReferee) {
        super("Summer Showdown", 64, false, finalReferee, 20000);
        this.backupReferee = backupReferee;
    }
/**
 * This method returns the parameters as Strings.
 */
    @Override
    public String toString() {
        return "Name: " + getName()
                + ", Number of Teams: " + getNumTeams()
                + ", Final Referee: " + getFinalReferee()
                + ", Backup Referee: " + backupReferee
                + ", Maximum Capacity: " + getMaxCapacity();
    }
/**
 * This method overrides Object's equals() method.
 * @param obj casting for showdown
 * @return false if variables finalReferee and maxCapacity aren't equal
 */
    @Override
    public boolean equals(Object obj) {
        boolean f = false;
        boolean m = false;
        if (!super.equals(obj) && !(obj instanceof SummerShowdown)) {
            return false;
        }
        Tournament tournament = (Tournament) obj;
        SummerShowdown showdown = (SummerShowdown) tournament;
        if (this.getFinalReferee() == showdown.getFinalReferee()) {
            f = true;
        }
        if (this.getMaxCapacity() == showdown.getMaxCapacity()) {
            m = true;
        }
        return f == m;
    }
/**
 * This method determines if backupReferee is undecided.
 * It also decides if maxCapacity should be divided by 2.
 */
    @Override
    public void refereeHire(String refName) {
        if (this.getFinalReferee() == refName) {
            System.out.println("We need a new referee! " + backupReferee + " is already refereeing the final!");
            this.backupReferee = "Undecided";
        } else if (this.backupReferee == refName) {
            System.out.println("Be ready for some conflicts!");
            setMaxCapacity(this.getMaxCapacity() / 2);
        } else {
            System.out.println("Ready to play!");
        }
    }
}