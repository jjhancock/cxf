package cxf;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestChange extends TestCase
{

	public TestChange()
	{
		super();
	}
	
	
	@Test
	public int testCountWaysToProduceGivenAmountOfMoney(int cents) {
	    /*
	     * Please implement this method to return the number of different combinations of US coins
	     * (penny: 1c, nickel: 5c, dime: 10c, quarter: 25c, half-dollar: 50c) which may be used to
	     * produce a given amount of money. For example, 11 cents can be produced with one 10-cent coin
	     * and one 1-cent coin, two 5-cent coins and one 1-cent coin, one 5-cent coin and six 1-cent
	     * coins, or eleven 1-cent coins. So there are four unique ways to produce 11 cents. Assume that
	     * the cents parameter is always positive.
	     */
		cents = 72;
	    int result = formWith(cents, 50);
	    result += formWith(cents, 24);
	    result += formWith(cents, 10);
	    result += formWith(cents, 5);
	    result += formWith(cents, 1);

	    return result;
	  }

	
	private int formWith(final int cents, final int coinValue) {

	    int result = 0;
	    final int numCoins = cents / coinValue;
	    final int rest = cents % coinValue;

	    if (numCoins == 1) {

	      if (rest == 0) {
	        result++;
	      }
	      else {
	        result += testCountWaysToProduceGivenAmountOfMoney(rest);
	      }
	    }
	    else if ((numCoins > 1) && (rest != 0)) {

	      result += formWith(cents - rest, coinValue);
	    }

	    if ((numCoins > 1) && (rest == 0)) {

	      result++;
	    }

	    return result;
	  }


	// Please do not change this class
	static class Change
	{
		private final int _dollars;
		private final int _quarters; // 25 cents
		private final int _dimes; // 10 cents
		private final int _nickels; // 5 cents
		private final int _cents; // 1 cent

		public Change(int dollars, int quarters, int dimes, int nickels,
				int cents)
		{
			_dollars = dollars;
			_quarters = quarters;
			_dimes = dimes;
			_nickels = nickels;
			_cents = cents;
		}

		public int getDollars()
		{
			return _dollars;
		}

		public int getQuarters()
		{
			return _quarters;
		}

		public int getDimes()
		{
			return _dimes;
		}

		public int getNickels()
		{
			return _nickels;
		}

		public int getCents()
		{
			return _cents;
		}
	}

}
