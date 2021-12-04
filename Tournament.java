/**
 * This abstract class represents any tournament that UEFA runs.
 * @author Serene Belhadj
 * @version 1.0
 */
public abstract class Tournament {
    private String name;
    private int numTeams;
    private boolean knockout;
    private String finalReferee;
    protected int maxCapacity;
    private static final int FINAL_CAPACITY = 30000;
/**
 * This constructor takes in 5 parameters.
 * @param name name of tournament
 * @param numTeams number of teams in tournament
 * @param knockout type of tournament
 * @param finalReferee name of referee for final game
 * @param maxCapacity maximum capacity for all stadiums
 */
    public Tournament(String name, int numTeams, boolean knockout, String finalReferee, int maxCapacity) {
        this.name = name;
        setNumTeams(numTeams);
        this.knockout = knockout;
        this.finalReferee = finalReferee;
        this.maxCapacity = maxCapacity;
        if (numTeams > 64 && !knockout) {
            this.knockout = true;
        }
    }
/**
 * This method returns the parameters as Strings.
 */
    @Override
    public String toString() {
        String koStr;
        if (knockout) {
            koStr = "this is a KO tournament";
        } else {
            koStr = "this isn't a KO tournament";
        }
        return "Name: " + name
                + ", Number of Teams: " + numTeams
                + ", KO: " + koStr
                + ", Final Referee: " + finalReferee
                + ", Maximum Capacity: " + maxCapacity;
    }
/**
 * This method overrides Object's equals() method.
 * @param obj casting for tournament
 * @return false if variables name, numTeams, and knockout aren't equal
 */
    @Override
    public boolean equals(Object obj) {
        boolean n = false;
        boolean t = false;
        boolean k = false;
        if (!(obj instanceof Tournament)) {
            return false;
        }
        Tournament tournament = (Tournament) obj;
        if (this.name == tournament.getName()) {
            n = true;
        }
        if (this.numTeams == tournament.getNumTeams()) {
            t = true;
        }
        if (this.knockout == tournament.getKnockout()) {
            k = true;
        }
        return n == t == k;
    }
/**
 * This method is abstract and takes in a String.
 * @param refName the inputted value
 */
    public abstract void refereeHire(String refName);
/**
 * This is a getter for variable name.
 * @return name
 */
    public String getName() {
        return name;
    }
/**
 * This is a setter for variable name.
 * @param name name of tournament
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * This is a setter for variable numTeams.
 * @param numTeams number of teams in tournament have to be even. if not, set to 16.
 */
    public void setNumTeams(int numTeams) {
        if (numTeams % 2 == 1) {
            this.numTeams = 16;
        } else {
            this.numTeams = numTeams;
        }
    }
/**
 * This is a getter for variable numTeams.
 * @return numTeams
 */
    public int getNumTeams() {
        return numTeams;
    }
/**
 * This is a getter for variable knockout.
 * @return knockout
 */
    public boolean getKnockout() {
        return knockout;
    }
/**
 * This is a setter for variable knockout.
 * @param knockout type of tournament and its default value is true
 */
    public void setKnockout(boolean knockout) {
        if (knockout) {
            knockout = true;
        }
    }
/**
 * This is a getter for variable maxCapacity.
 * @return maxCapacity
 */
    public int getMaxCapacity() {
        return maxCapacity;
    }
/**
 * This is a setter for variable maxCapacity.
 * @param maxCapacity maximum capacity of all stadiums
 */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
/**
 * This is a getter for variable finalReferee.
 * @return finalReferee
 */
    public String getFinalReferee() {
        return finalReferee;
    }
/**
 * This is a setter for variable finalReferee.
 * @param finalReferee name of the referee for the final
 */
    public void setFinalReferee(String finalReferee) {
        this.finalReferee = finalReferee;
    }
/**
 * This is a getter for variable FINAL_CAPACITY.
 * @return FINAL_CAPACITY
 */
    public int getFinalCapacity() {
        return FINAL_CAPACITY;
    }
}