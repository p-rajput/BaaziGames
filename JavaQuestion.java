import java.util.List;

public class JavaQuestion {

  /**
   * Q1 Balanced Array —- Coding
  */
  public int balancedSum(Integer[] arr) {
    int sum = 0, tempSum = 0;
    for (int i = 0; i < arr.length; i++) sum += arr[i];
    for (int i = 0; i < arr.length; i++) {
      tempSum += arr[i];
      if (tempSum % 2 == 0 && tempSum * 2 == sum) {
        return i;
      }
    }
    return -1;
  }

    /**
     * Q2 Scoring System — DbRank
     */
  public void ScoringSystem(){
    String hql = "SELECT ID, NAME FROM STUDENT ORDER BY SCORE DESC, ID ASC LIMIT 3;";
  }

}
