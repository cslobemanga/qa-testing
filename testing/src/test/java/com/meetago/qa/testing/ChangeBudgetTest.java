package com.meetago.qa.testing;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ChangeBudgetTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ChangeBudgetTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ChangeBudgetTest.class );
    }
    
   
    public void testRoundAmount()
    {
    	ChangeBudget cBudget = new ChangeBudget();
    	int[] expected = new int[] {654, 6028, 37, 12507};
    	int actual[] = new int[expected.length];
    	
    	for (int i=0; i<expected.length; i++) {
    		actual[i] = cBudget.roundAmount(expected[i]);
    	}
    	
    	assertEquals(actual[0], 660);
    	assertEquals(actual[1], 6030);
    	assertEquals(actual[2], 40);
    	assertEquals(actual[3], 12510);
    	
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
