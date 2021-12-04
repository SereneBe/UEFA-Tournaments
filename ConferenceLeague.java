/**
 * This class describes the second of UEFA's tournaments and will inherit from the Tournament class.
 * @author Serene Belhadj
 * @version 1.2
 */
public class ConferenceLeague extends Tournament {
    private int teamsPerLeague;
    private String currentHolder;
/**
 * This constructor takes in 3 parameters.
 * @param finalReferee inherited from tournament.
 * @param teamsPerLeague number of particpating teams from each league
 * @param currentHolder the current holder of the Conference League trophy
 */
    public ConferenceLeague(String finalReferee, int teamsPerLeague, String currentHolder) {
        super("Conference League", 32, true, finalReferee, 15000);
        this.teamsPerLeague = teamsPerLeague;
        this.currentHolder = currentHolder;
    }
/**
 * This method returns the parameters as Strings.
 */
    @Override
    public String toString() {
        return "Name: " + getName()
                + ", Number of Teams: " + getNumTeams()
                + ", Final Referee: " + getFinalReferee()
                + ", Teams per League: " + teamsPerLeague
                + ", Current Holder: " + currentHolder;
    }
/**
 * This method overrides Object's equals() method.
 * @param obj casting for league
 * @return false if variables currentHolder and finalReferee aren't equal
 */
    @Override
    public boolean equals(Object obj) {
        boolean a = false;
        boolean b = false;
        if (!super.equals(obj)) {
            return false;
        }
        Tournament tournament = (Tournament) obj;
        ConferenceLeague league = (ConferenceLeague) tournament;
        if (this.currentHolder == league.getCurrentHolder()) {
            a = true;
        }
        if (this.getFinalReferee() == league.getFinalReferee()) {
            b = true;
        }
        return a == b;
    }
/**
 * This method decides if numTeams should be halved.
 * It also decides if maxCapacity should hold the same value as FINAL_CAPACITY
 */
    public void nextRound() {
        if (this.getKnockout() && this.getNumTeams() > 2) {
            setNumTeams(this.getNumTeams() / 2);
        } else {
            System.out.println("We have reached the final!");
            if (this.getMaxCapacity() > this.getFinalCapacity()) {
                setMaxCapacity(this.getFinalCapacity());
            }
        }
    }
/**
 * This method determines if finalReferee is undecided.
 * It also decides if maxCapacity should be doubled.
 */
    @Override
    public void refereeHire(String refName) {
        if (this.getFinalReferee() == refName) {
            System.out.println("We need a new referee!");
            this.setFinalReferee("Undecided");
        } else {
            System.out.println("We're ready to go!");
            this.setMaxCapacity(this.getMaxCapacity() * 2);
        }
    }
/**
 * This method is the getter for the variable currentHolder.
 * @return currentHolder for the trophy
 */
    public String getCurrentHolder() {
        return currentHolder;
    }
}