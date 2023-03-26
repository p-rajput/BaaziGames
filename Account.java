public class Account implements OnlineAccount, Comparable<Account> {

    private int noOfRegularMovies;
    private int noOfExclusiveMovies;
    private String ownerName;

    /**
     * Q3 Account Comparisons —- Coding
     */
    public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
        this.ownerName = ownerName;
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
    }

    @Override
    public int monthlyCost() {
        return basePrice + (noOfRegularMovies * regularMoviePrice) + (noOfExclusiveMovies * exclusiveMoviePrice);
    }

    @Override
    public int compareTo(Account other) {
        return this.monthlyCost() - other.monthlyCost();
    }

    @Override
    public String toString() {
        return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD.";
    }
}

